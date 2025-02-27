package com.procurement.poc.classes.requestforquotations.readyforevaluation;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.interfaces.ILogin;
import com.interfaces.ILogout;
import com.procurement.poc.interfaces.requestforquotation.IReadyForEvalutation;

import java.util.Properties;

import static com.factory.PlaywrightFactory.statusAssertion;
import static com.procurement.poc.constants.requestforquotations.LReadyForEvaluation.*;
import static com.factory.PlaywrightFactory.waitForLocator;

public class ReadyForEvaluation implements IReadyForEvalutation {

    Properties properties;
    Page page;
    ILogin iLogin;
    ILogout iLogout;

    private ReadyForEvaluation(){
    }

//TODO Constructor
    public ReadyForEvaluation(ILogin iLogin, Properties properties, Page page, ILogout iLogout){
        this.iLogin = iLogin;
        this.properties = properties;
        this.page = page;
        this.iLogout = iLogout;
    }

    public void readyForEvaluationButton(){
        try {
        String buyerMailId = properties.getProperty("buyerEmail");
        iLogin.performLogin(buyerMailId);

        Locator rfqNavigationBarLocator = page.locator(RFQ_NAVIGATION_BAR.getLocator());
        waitForLocator(rfqNavigationBarLocator);
        rfqNavigationBarLocator.click();

        String title = properties.getProperty("currentTitle");
        Locator titleLocator = page.locator(getString(title));
        waitForLocator(titleLocator);

        statusAssertion(page,titleLocator.first()::click,"rfq","QuotationPhase");

        Locator readyForEvaluationButtonLocator = page.locator(READY_FOR_EVALUATION_BUTTON.getLocator());
        waitForLocator(readyForEvaluationButtonLocator);
        readyForEvaluationButtonLocator.click();

        Locator acceptLocator = page.locator(YES.getLocator());
        waitForLocator(acceptLocator);
        acceptLocator.click();

        statusAssertion(page,page::reload,"rfq","ReadyForEvaluation");

        iLogout.performLogout();
        } catch (Exception error) {
            System.out.println("What is the error: " + error.getMessage());
        }
    }
}