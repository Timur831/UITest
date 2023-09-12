package tests;

import com.codeborne.selenide.Selenide;
import helpers.Driver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.net.MalformedURLException;

class BaseTest {

    @BeforeSuite
    public void beforeSettings(ITestContext context)  {
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        Driver.initDriver();
    }

    @AfterMethod
    public void clearCookies(){
        Selenide.clearBrowserCookies();
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}

