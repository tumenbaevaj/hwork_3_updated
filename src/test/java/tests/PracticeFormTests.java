package tests;

import org.junit.jupiter.api.Test;

import static testdata.TestData.*;

public class PracticeFormTests extends TestBase {

    @Test
    void successfulFullFormTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .setGender(genderFemale)
                .typeMobileNumber(mobileNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjectMaths)
                .setHobby(hobbySports)
                .uploadPicture(uploadImage)
                .typeCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitForm()
                .checkFormSubmitted()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", genderFemale)
                .checkResult("Mobile", mobileNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjectMaths)
                .checkResult("Hobbies", hobbySports)
                .checkResult("Picture", uploadImage)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successfulRequiredFieldsTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(genderFemale)
                .typeMobileNumber(mobileNumber)
                .submitForm()
                .checkFormSubmitted()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", genderFemale)
                .checkResult("Mobile", mobileNumber);
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
                .typeLastName(lastName)
                .setGender(genderFemale)
                .typeMobileNumber(mobileNumber)
                .submitForm()
                .checkFormNotSubmitted();
    }

    @Test
    void invalidPhoneTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(genderFemale)
                .typeMobileNumber(invalidPhone)
                .submitForm()
                .checkFormNotSubmitted();
    }
}
