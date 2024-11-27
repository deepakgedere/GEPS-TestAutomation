package com.procurement.poc.classes.requisition.approve;
import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.options.LoadState;
import com.procurement.poc.interfaces.logout.ILogout;
import com.procurement.poc.interfaces.requisitions.IPrApprove;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.procurement.poc.interfaces.login.ILogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.factory.PlaywrightFactory.waitForLocator;
import static com.procurement.poc.constants.requisitions.LPrApprove.*;

public class Approve implements IPrApprove {

    private ILogin iLogin;
    private ILogout iLogout;
    private Properties properties;
    private Page page;

//TODO Constructor
    public Approve(ILogin iLogin, Properties properties, Page page, ILogout iLogout){
        this.iLogin = iLogin;
        this.properties = properties;
        this.page = page;
        this.iLogout = iLogout;
    }

    public void approve() {
        try {
            int x = Integer.parseInt(properties.getProperty("ApproverCount"));
            List<String> approvers = new ArrayList<>();
            for(int i=1;i<=x;i++){
                approvers.add(properties.getProperty("Approver"+i));
            }
            String PRReferenceNumber = properties.getProperty("PRReferenceNumber");
            for (String approverMailId : approvers) {
                ApproveMethod(approverMailId , PRReferenceNumber);
            }
        } catch (Exception error) {
            System.out.println(error);
        }
    }

    public void ApproveMethod(String ApproverMailId , String PRReferenceNumber) throws InterruptedException {
        iLogin.performLogin(ApproverMailId);
        page.locator(MY_APPROVALS.getLocator()).click();
        String title = "Requisition "+ PRReferenceNumber;
        page.locator(getString(title)).first().click();
        page.locator(APPROVE.getLocator()).click();
        Response response = page.waitForResponse(
                resp -> resp.url().startsWith("https://geps_hopes_yil.cormsquare.com/Procurement/Requisitions/POC_Details") && resp.status() == 200,
                page.locator(YES.getLocator())::click
        );
        iLogout.performLogout();
    }
}