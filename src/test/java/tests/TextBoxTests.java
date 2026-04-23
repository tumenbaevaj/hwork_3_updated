package tests;

import org.junit.jupiter.api.Test;

import static testdata.TestData.*;

public class TextBoxTests extends TestBase {


    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage()
                .removeBanners()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm()
                .checkField("name", userName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);
    }

    @Test
    void successfulMinimalFieldsTest() {
        textBoxPage.openPage()
                .removeBanners()
                .typeUserName(userName)
                .submitForm()
                .checkField("name", userName);
    }

    @Test
    void invalidEmailTest() {
        textBoxPage.openPage()
                .removeBanners()
                .typeUserName(userName)
                .typeUserEmail(invalidEmail)
                .submitForm()
                .checkEmailError();
    }
}
