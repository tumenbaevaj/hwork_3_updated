package tests;

import com.codeborne.selenide.Configuration;
import helpers.Attachments;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.PracticeFormPage;
import pages.TextBoxPage;
import testdata.TestData;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    TestData testData;

    @BeforeAll
    static void setupSelenideEnv() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//      Configuration.browser = "chrome";
//      Configuration.browserVersion = "128.0";
//      Configuration.browserVersion = "130.0";
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @BeforeEach
    void setupTestData() {
        testData = new TestData();
    }

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
        closeWebDriver();
    }
}
