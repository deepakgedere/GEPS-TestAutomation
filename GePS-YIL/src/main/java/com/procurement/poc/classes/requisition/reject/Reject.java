package com.procurement.poc.classes.requisition.reject;
import com.google.gson.JsonParser;
import com.microsoft.playwright.Response;
import com.procurement.poc.interfaces.logout.ILogout;
import com.procurement.poc.interfaces.requisitions.IPrEdit;
import com.procurement.poc.interfaces.requisitions.IPrReject;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.procurement.poc.interfaces.login.ILogin;

import java.util.Properties;
import static com.factory.PlaywrightFactory.waitForLocator;
import static com.procurement.poc.constants.requisitions.LPrReject.*;

public class Reject implements IPrReject {

    private ILogin iLogin;
    private ILogout iLogout;
    private Properties properties;
    private Page page;
    private IPrEdit iPrEdit;

    private Reject(){
    }

//TODO Constructor
    public Reject(ILogin iLogin, Properties properties, Page page, ILogout iLogout, IPrEdit iPrEdit){
        this.iLogin = iLogin;
        this.properties = properties;
        this.page = page;
        this.iLogout = iLogout;
        this.iPrEdit = iPrEdit;
    }

    public void reject(String approver)  {
        try {
        iLogin.performLogin(approver);
        String title = properties.getProperty("orderTitle");
        String getTitle = getTitle(title);
        Locator titleLocator = page.locator(getTitle);
        waitForLocator(titleLocator);
        titleLocator.first().click();

        Locator rejectButtonLocator = page.locator(REJECT_BUTTON.getLocator());
        waitForLocator(rejectButtonLocator);
        rejectButtonLocator.click();

        Locator remarksLocator = page.locator(REMARKS.getLocator());
        waitForLocator(remarksLocator);
        remarksLocator.fill("Rejected");

        Locator yesButtonLocator = page.locator(YES.getLocator());
        waitForLocator(yesButtonLocator);

        Response response1 = page.waitForResponse(
                resp -> resp.url().startsWith("https://geps_hopes_yil.cormsquare.com/api/Requisitions/") && resp.status() == 200,
                yesButtonLocator::click
        );
        //Assertion Start
        String prStatus = JsonParser.parseString(response1.text()).getAsJsonObject().get("status").getAsString();
        String expectedStatus = "Rejected";
        assert expectedStatus.equals(prStatus) : "Expected status to be: " + expectedStatus + ", but got: " + prStatus;
        assert page.locator("//span[@id='status']//span").innerText().contains(prStatus) : "Expected status text to contain: " + prStatus;
        //Assertion End

        iLogout.performLogout();
        } catch (Exception error) {
            System.out.println("What is the error: " + error.getMessage());
        }
    }
}