package tests;

import app.pages.LoginPage;
import org.testng.annotations.Test;

public class firstTest extends BaseTest{
    @Test(description="Just do it!", groups = {"positive"})
    public void doIt() {
        new LoginPage()
                .openLoginPage()
                .login("9683601762", "Qwerty44");
    }
}

