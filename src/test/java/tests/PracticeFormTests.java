package tests;

import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {

    @Test
    void successfulFullFormTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .typeFirstName(testData.firstName)
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
                .submitForm()
                .checkFormSubmitted()
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
    }

    @Test
    void successfulRequiredFieldsTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .setGender(testData.gender)
                .typeMobileNumber(testData.mobileNumber)
                .submitForm()
                .checkFormSubmitted()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.mobileNumber);
    }

    @Test
    void emptyRequiredFieldsTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .submitForm()
                .checkFormNotSubmitted();
    }

    @Test
    void emptyFirstNameTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .typeLastName(testData.lastName)
                .setGender(testData.gender)
                .typeMobileNumber(testData.mobileNumber)
                .submitForm()
                .checkFormNotSubmitted();
    }

    @Test
    void invalidPhoneTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .setGender(testData.gender)
                .typeMobileNumber(testData.invalidPhone)
                .submitForm()
                .checkFormNotSubmitted();
    }
}
