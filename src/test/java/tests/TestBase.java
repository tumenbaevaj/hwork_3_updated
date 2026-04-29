package tests;

import com.codeborne.selenide.Configuration;
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
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void setupTestData() {
        testData = new TestData();
    }

    @AfterEach
    void closeBrowserAfterTest() {
        closeWebDriver();
    }
}
