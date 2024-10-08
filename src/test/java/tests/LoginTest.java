package tests;


import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Screens;

import static utilities.Hooks.page;

@Listeners(utilities.Hooks.class)
public class LoginTest {
    private Screens screens;

    @Epic("User Interface Tests")
    @Feature("Login Feature")
    @Story("Successful Login")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test for successful login with valid credentials")
    @Test
    public void loginTest() {
        screens = new Screens(page);

        Allure.step("Navigate to the login page", () -> {
            System.out.println("Hello");
        });
    }
}
