package com.procurement.invoice.poinvoice.checklist;
import com.poc.base.BaseTest;
import org.testng.annotations.Test;

public class ChecklistRejectTest extends BaseTest {

    @Test
    public void ChecklistRejectTestMethod(){
        try {
            poInvChecklistReject.ChecklistRejectMethod();
        } catch (Exception error) {
            System.out.println("What is the error: " + error.getMessage());
        }
    }
}