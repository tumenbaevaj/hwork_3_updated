package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    //Elements
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement outputResults = $("#output");


    //Actions
    @Step("Open the text box page")
    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    @Step("Remove banners from the page")
    public TextBoxPage removeBanners() {
        executeJavaScript("""
                    document.getElementById('fixedban')?.remove();
                    document.querySelector('footer')?.remove();
                """);

        return this;
    }

    @Step("Type user name: {value}")
    public TextBoxPage typeUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    @Step("Type user email: {value}")
    public TextBoxPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Type current address: {value}")
    public TextBoxPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Type permanent address: {value}")
    public TextBoxPage typePermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    @Step("Submit the text box form")
    public TextBoxPage submitForm() {
        submitButton.click();

        return this;
    }

    @Step("Check field {key} has value: {value}")
    public TextBoxPage checkField(String key, String value) {
        outputResults.$(byId(key)).shouldHave(text(value));

        return this;
    }

    @Step("Check that email validation error is displayed")
    public TextBoxPage checkEmailError() {
        userEmailInput.shouldHave(cssClass("field-error"));

        return this;
    }
}
