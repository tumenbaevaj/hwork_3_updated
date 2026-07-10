package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Text box form")
public class TextBoxTests extends TestBase {

    @Test
    @DisplayName("Fill all fields")
    void successfulFillFormTest() {
        step("Open form", () -> {
            textBoxPage.openPage()
                    .removeBanners();
        });

        step("Fill all fields", () -> {
            textBoxPage.typeUserName(testData.userName)
                    .typeUserEmail(testData.userEmail)
                    .typeCurrentAddress(testData.currentAddress)
                    .typePermanentAddress(testData.permanentAddress)
                    .submitForm();
        });

        step("Verify results", () -> {
            textBoxPage.checkField("name", "name", testData.userName)
                    .checkField("email", "email", testData.userEmail)
                    .checkField("currentAddress", "current address", testData.currentAddress)
                    .checkField("permanentAddress", "permanent address", testData.permanentAddress);
        });
    }

    @Test
    @DisplayName("Fill user name only")
    void successfulMinimalFieldsTest() {
        step("Open form", () -> {
            textBoxPage.openPage()
                    .removeBanners();
        });

        step("Fill user name only", () -> {
            textBoxPage.typeUserName(testData.userName)
                    .submitForm();
        });

        step("Verify results", () -> {
            textBoxPage.checkField("name", "name", testData.userName);
        });
    }

    @Test
    @DisplayName("Submit invalid email")
    void invalidEmailTest() {
        step("Open form", () -> {
            textBoxPage.openPage()
                    .removeBanners();
        });

        step("Fill invalid email", () -> {
            textBoxPage.typeUserName(testData.userName)
                    .typeUserEmail(testData.invalidEmail)
                    .submitForm();
        });

        step("Check email validation error", () -> {
            textBoxPage.checkEmailError();
        });
    }
}
