package app.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public abstract class BasePage {

    protected String pageUrl = "https://moskva.beeline.ru/customers/products/";

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public BasePage() {
    }

    @Step("Открыть страницу")
    public void open() {
        Selenide.open(this.pageUrl);
    }
}
