package com.procurement.nonPoc.requisition.sendforapproval;
import com.procurement.nonPoc.base.BaseTest;
import org.testng.annotations.Test;

public class SendForApprovalTest extends BaseTest {

    @Test
    public void assign() {
        try {
            iPrSendForApproval.SendForApproval();
        } catch (Exception error) {
            System.out.println("What is the error: " + error.getMessage());
        }
    }
}