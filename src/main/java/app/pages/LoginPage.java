package app.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private final SelenideElement inputButton = $x("//span[text()='Войти']");
    private final SelenideElement authWithPassword = $x("//span[text()='С постоянным паролем']");
    private final SelenideElement inputField = $x("//input[@name=\"login\"]");
    private final SelenideElement passwordField = $x("//input[@name=\"password\"]");
    private final SelenideElement inputButtonModal = $x("//span[text()='Войти']");

    public LoginPage(){
    }

    public LoginPage(String pageUrl){
        super(pageUrl);
    }

    @Step("Открыть страницу авторизации")
    public LoginPage openLoginPage() {
        this.open();
        return new LoginPage();
    }

    @Step("Авторизация в ЕЛК")
    public void login(String login, String password) {
        inputButton.shouldBe(visible).click();
        authWithPassword.shouldBe(visible).click();
        inputField.shouldBe(visible).sendKeys(login);
        passwordField.shouldBe(visible).sendKeys(password);
//        inputButtonModal.shouldBe(visible).click();
//        $x("//span[text()='Главная']").shouldBe(visible);
    }

}
