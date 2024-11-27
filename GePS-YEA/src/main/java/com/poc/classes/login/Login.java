package com.poc.classes.login;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.poc.interfaces.login.ILogin;

import java.util.Properties;

import static com.constants.login.LLogin.*;
import static com.factory.PlaywrightFactory.waitForLocator;

public class Login implements ILogin {

    Page page;
    Properties properties;

    private Login() {
    }

//TODO Constructor
    public Login(Properties properties, Page page) {
        this.properties = properties;
        this.page = page;
    }

    public void performLogin() {
        try {
            Locator emailLocator = page.locator(EMAIL);
            waitForLocator(emailLocator);
            emailLocator.click();
            emailLocator.fill(properties.getProperty("requesterEmail"));

            Locator passwordLocator = page.locator(PASSWORD);
            waitForLocator(passwordLocator);
            passwordLocator.click();
            passwordLocator.fill(properties.getProperty("loginPassword"));

            Locator loginButtonLocator = page.locator(LOGIN_BUTTON);
            waitForLocator(loginButtonLocator);
            loginButtonLocator.click();
        } catch (Exception error) {
            System.out.println("Login error: " + error.getMessage());
        }
    }

    public void performLogin(String emailId) {
        try {
            Locator emailLocator = page.locator(EMAIL);
            waitForLocator(emailLocator);
            emailLocator.click();
            emailLocator.fill(emailId);

            Locator passwordLocator = page.locator(PASSWORD);
            waitForLocator(passwordLocator);
            passwordLocator.click();
            passwordLocator.fill(properties.getProperty("loginPassword"));

            Locator loginButtonLocator = page.locator(LOGIN_BUTTON);
            waitForLocator(loginButtonLocator);
            loginButtonLocator.click();
        } catch (Exception error) {
            System.out.println("Login error: " + error.getMessage());
        }
    }

    public void performLogin(String emailId, Page page) {
        try {
            Locator emailLocator = page.locator(EMAIL);
            waitForLocator(emailLocator);
            emailLocator.click();
            emailLocator.fill(emailId);

            Locator passwordLocator = page.locator(PASSWORD);
            waitForLocator(passwordLocator);
            passwordLocator.click();
            passwordLocator.fill(properties.getProperty("loginPassword"));

            Locator loginButtonLocator = page.locator(LOGIN_BUTTON);
            waitForLocator(loginButtonLocator);
            loginButtonLocator.click();
        } catch (Exception error) {
            System.out.println("Login error: " + error.getMessage());
        }
    }
}