package helpers;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

    public static void initDriver(){
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = Browsers.CHROME;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.screenshots = true;
        Configuration.timeout = 10000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        /**
         Настройки для Selenoid
         */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        //capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("enableLog", true);
        capabilities.setCapability("browserVersion", "108.0");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--proxy-bypass-list=<-loopback>");
        options.addArguments("--ignore-certificate-errors");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        Configuration.browserCapabilities = capabilities;

        switch (TestParams.os)
        {
            case "win":
                System.setProperty("webdriver.chrome.driver", "chromedriver\\win\\chromedriver.exe");
                break;
            case "linux":
                System.setProperty("webdriver.chrome.driver", "chromedriver/linux/chromedriver");
                break;
        }
    }
}