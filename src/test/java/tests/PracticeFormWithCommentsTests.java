package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithCommentsTests extends TestBase {

    @Test
    void successfulFullFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("""
                    document.getElementById('fixedban')?.remove();
                    document.querySelector('footer')?.remove();
                """);
        //executeJavaScript("$('#fixedban').remove()");
        //executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Jibek");
        $("#lastName").setValue("Tumenbaeva");
        $("#userEmail").setValue("jibekt@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        //$("#gender-radio-1").click(); wrong
        //$("#gender-radio-1").parent().click(); good
        //$(byText("Other")).click(); not very good
        //$("label[for=gender-radio-1]").click(); good
        $("#userNumber").setValue("5556676677");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        //$(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--026:not(.react-datepicker__day--outside-month)").click();
        //$x("//*[@class='react-datepicker__day--026'][not(contains(@class, 'react-datepicker__day--outside-month'))]");
        $("#subjectsInput").setValue("Accounting").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img.jpg");
        //$("#uploadPicture").uploadFile(new File("src/test/resources/img.jpg"));
        $("#currentAddress").setValue("Bishkek, Kyrgyzstan");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
    }
}
