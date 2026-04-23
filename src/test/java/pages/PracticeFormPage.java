package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.FormResultsComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    CalendarComponent calendar = new CalendarComponent();
    FormResultsComponent formResults = new FormResultsComponent();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderContainer = $("#genterWrapper");
    private final SelenideElement mobileNumberInput = $("#userNumber");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateSelect = $("#state");
    private final SelenideElement citySelect = $("#city");
    private final SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement modalDialog = $(".modal-dialog");
    private final SelenideElement modalTitle = $("#example-modal-sizes-title-lg");

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public PracticeFormPage removeBanners() {
        executeJavaScript("""
                    document.getElementById('fixedban')?.remove();
                    document.querySelector('footer')?.remove();
                """);

        return this;
    }

    public PracticeFormPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage typeMobileNumber(String value) {
        mobileNumberInput.setValue(value);

        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setHobby(String value) {
        hobbiesContainer.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage uploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public PracticeFormPage setState(String value) {
        stateSelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setCity(String value) {
        citySelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }

    public PracticeFormPage submitForm() {
        submitButton.click();

        return this;
    }

    public PracticeFormPage checkResult(String key, String value) {
        formResults.checkResult(key, value);

        return this;
    }

    public PracticeFormPage checkFormSubmitted() {
        modalDialog.shouldHave(appear);
        modalTitle.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public PracticeFormPage checkFormNotSubmitted() {
        modalDialog.shouldNot(exist);

        return this;
    }
}
