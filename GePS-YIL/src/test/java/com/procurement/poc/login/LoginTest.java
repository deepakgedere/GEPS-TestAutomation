package com.procurement.poc.login;
import com.procurement.poc.base.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        try {
            iLogin.performLogin();
        } catch (Exception error) {
            System.out.println("What is the error: " + error.getMessage());
        }
    }
}