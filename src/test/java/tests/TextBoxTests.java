package tests;

import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage()
                .removeBanners()
                .typeUserName(testData.userName)
                .typeUserEmail(testData.userEmail)
                .typeCurrentAddress(testData.currentAddress)
                .typePermanentAddress(testData.permanentAddress)
                .submitForm()
                .checkField("name", testData.userName)
                .checkField("email", testData.userEmail)
                .checkField("currentAddress", testData.currentAddress)
                .checkField("permanentAddress", testData.permanentAddress);
    }

    @Test
    void successfulMinimalFieldsTest() {
        textBoxPage.openPage()
                .removeBanners()
                .typeUserName(testData.userName)
                .submitForm()
                .checkField("name", testData.userName);
    }

    @Test
    void invalidEmailTest() {
        textBoxPage.openPage()
                .removeBanners()
                .typeUserName(testData.userName)
                .typeUserEmail(testData.invalidEmail)
                .submitForm()
                .checkEmailError();
    }
}
