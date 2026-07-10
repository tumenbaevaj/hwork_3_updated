package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Practice form")
public class PracticeFormTests extends TestBase {

    @Test
    @DisplayName("Fill all fields")
    void successfulFullFormTest() {
        step("Open form", () -> {
            practiceFormPage.openPage()
                    .removeBanners();
        });

        step("Fill all fields", () -> {
            practiceFormPage.typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .typeEmail(testData.email)
                    .setGender(testData.gender)
                    .typeMobileNumber(testData.mobileNumber)
                    .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                    .setSubject(testData.subject)
                    .setHobby(testData.hobby)
                    .uploadPicture(testData.uploadImage)
                    .typeCurrentAddress(testData.currentAddress)
                    .setStateAndCity(testData.state, testData.city)
                    .submitForm();
        });

        step("Verify results", () -> {
            practiceFormPage.checkFormSubmitted()
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Student Email", testData.email)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.mobileNumber)
                    .checkResult("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                    .checkResult("Subjects", testData.subject)
                    .checkResult("Hobbies", testData.hobby)
                    .checkResult("Picture", testData.uploadImage)
                    .checkResult("Address", testData.currentAddress)
                    .checkResult("State and City", testData.state + " " + testData.city);
        });
    }

    @Test
    @DisplayName("Fill required fields only")
    void successfulRequiredFieldsTest() {
        step("Open form", () -> {
            practiceFormPage.openPage()
                    .removeBanners();
        });

        step("Fill required fields", () -> {
            practiceFormPage.typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .setGender(testData.gender)
                    .typeMobileNumber(testData.mobileNumber)
                    .submitForm();
        });

        step("Verify results", () -> {
            practiceFormPage.checkFormSubmitted()
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.mobileNumber);
        });
    }

    @Test
    @DisplayName("Submit empty form")
    void emptyRequiredFieldsTest() {
        step("Open form", () -> {
            practiceFormPage.openPage()
                    .removeBanners();
        });

        step("Submit empty form", () -> {
            practiceFormPage.submitForm();
        });

        step("Verify the form is not submitted", () -> {
            practiceFormPage.checkFormNotSubmitted();
        });
    }

    @Test
    @DisplayName("Submit without first name")
    void emptyFirstNameTest() {
        step("Open form", () -> {
            practiceFormPage.openPage()
                    .removeBanners();
        });

        step("Fill form without first name", () -> {
            practiceFormPage.typeLastName(testData.lastName)
                    .setGender(testData.gender)
                    .typeMobileNumber(testData.mobileNumber)
                    .submitForm();
        });

        step("Verify the form is not submitted", () -> {
            practiceFormPage.checkFormNotSubmitted();
        });
    }

    @Test
    @DisplayName("Submit with invalid phone number")
    void invalidPhoneTest() {
        step("Open form", () -> {
            practiceFormPage.openPage()
                    .removeBanners();
        });

        step("Fill invalid phone number", () -> {
            practiceFormPage.typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .setGender(testData.gender)
                    .typeMobileNumber(testData.invalidPhone)
                    .submitForm();
        });

        step("Verify the form is not submitted", () -> {
            practiceFormPage.checkFormNotSubmitted();
        });
    }
}
