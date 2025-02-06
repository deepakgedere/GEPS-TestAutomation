package com.procurement.poc.classes.requestforquotations.technicalevaluation;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.interfaces.ILogin;
import com.interfaces.ILogout;
import com.procurement.poc.interfaces.requestforquotation.ITeReject;

import java.util.Properties;

import static com.procurement.poc.constants.requestforquotations.LTeReject.*;
import static com.factory.PlaywrightFactory.waitForLocator;

public class TechnicalEvaluationReject implements ITeReject {

    ILogin iLogin;
    Properties properties;
    Page page;
    ILogout iLogout;

    private TechnicalEvaluationReject(){
    }

//TODO Constructor
    public TechnicalEvaluationReject(ILogin iLogin, Properties properties, Page page, ILogout iLogout){
        this.iLogin = iLogin;
        this.page = page;
        this.properties = properties;
        this.iLogout = iLogout;
    }

    public void technicalEvaluationRejectMethod(){
        try {
        iLogin.performLogin(properties.getProperty("requesterEmail"));

        Locator rfqNavigationBarLocator = page.locator(RFQ_NAVIGATION_BAR.getLocator());
        waitForLocator(rfqNavigationBarLocator);
        rfqNavigationBarLocator.click();

        String title = properties.getProperty("orderTitle");
        Locator titleLocator = page.locator(getTitle(title));
        waitForLocator(titleLocator);
        titleLocator.first().click();

        Locator teCreateButtonLocator = page.locator(TE_CREATE_BUTTON.getLocator());
        waitForLocator(teCreateButtonLocator);
        teCreateButtonLocator.click();

        Locator vendorSelectCheckboxLocator = page.locator(VENDOR_SELECT_CHECKBOX.getLocator());
        waitForLocator(vendorSelectCheckboxLocator);
        vendorSelectCheckboxLocator.click();

        Locator createTeButtonLocator = page.locator(CREATE_TECHNICAL_EVALUATION_BUTTON.getLocator());
        waitForLocator(createTeButtonLocator);
        createTeButtonLocator.click();

        Locator remarksAccept = page.locator(YES.getLocator());
        waitForLocator(remarksAccept);
        remarksAccept.click();

        Locator sendForApprovalLocator = page.locator(SEND_FOR_APPROVAL.getLocator());
        waitForLocator(sendForApprovalLocator);
        sendForApprovalLocator.click();

        Locator teApproverSelectLocator = page.locator(APPROVER_SELECT.getLocator());
        waitForLocator(teApproverSelectLocator);
        teApproverSelectLocator.first().click();

        String teApprover = properties.getProperty("teApprover");
        Locator teApproverSearchLocator = page.locator(SEARCH_FIELD.getLocator());
        waitForLocator(teApproverSearchLocator);
        teApproverSearchLocator.fill(teApprover);

        Locator getTeApproverLocator = page.locator(getTeApprover(teApprover));
        waitForLocator(getTeApproverLocator);
        getTeApproverLocator.click();

        Locator saveApproverLocator = page.locator(SAVE_APPROVER.getLocator());
        waitForLocator(saveApproverLocator);
        saveApproverLocator.click();

        Locator acceptLocator = page.locator(YES.getLocator());
        waitForLocator(acceptLocator);
        acceptLocator.click();

        Locator rejectButtonLocator = page.locator(REJECT_BUTTON.getLocator());
        waitForLocator(rejectButtonLocator);
        rejectButtonLocator.click();

        Locator remarksInputLocator = page.locator(REMARKS_INPUT_LOCATOR.getLocator());
        waitForLocator(remarksInputLocator);
        remarksInputLocator.fill("TE Rejected");

        Locator acceptLocator1 = page.locator(YES.getLocator());
        waitForLocator(acceptLocator1);
        acceptLocator1.click();

        iLogout.performLogout();
        } catch (Exception error) {
            System.out.println("What is the error: " + error.getMessage());
        }
    }
}