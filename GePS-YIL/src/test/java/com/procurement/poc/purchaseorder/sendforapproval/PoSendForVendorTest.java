package com.procurement.poc.purchaseorder.sendforapproval;
import com.procurement.poc.base.BaseTest;
import org.testng.annotations.Test;

public class PoSendForVendorTest extends BaseTest {

    @Test
    public void sendForVendor(){
        try {
            iPoSendForVendor.sendForVendor();
        } catch (Exception error) {
            System.out.println("What is the error: " + error.getMessage());
        }
    }
}