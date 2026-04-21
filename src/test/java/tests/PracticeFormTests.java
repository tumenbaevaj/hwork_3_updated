package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {

    @Test
    void successfulFullFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("""
                    document.getElementById('fixedban')?.remove();
                    document.querySelector('footer')?.remove();
                """);

        $("#firstName").setValue("Jibek");
        $("#lastName").setValue("Tumenbaeva");
        $("#userEmail").setValue("jibekt@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("5556676677");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--026:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Accounting").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img.jpg");
        $("#currentAddress").setValue("Bishkek, Kyrgyzstan");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").shouldHave(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Jibek"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("5556676677"));
        $(".table-responsive").shouldHave(text("26 June,1988"));
        $(".table-responsive").shouldHave(text("Accounting"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("img.jpg"));
        $(".table-responsive").shouldHave(text("Bishkek, Kyrgyzstan"));

        $(".modal-dialog").shouldHave(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Jibek Tumenbaeva"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("5556676677"));
        $(".table-responsive").shouldHave(text("26 June,1988"));
        $(".table-responsive").shouldHave(text("Accounting"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("img.jpg"));
        $(".table-responsive").shouldHave(text("Bishkek, Kyrgyzstan"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }

    @Test
    void successfulRequiredFieldsTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("""
                    document.getElementById('fixedban')?.remove();
                    document.querySelector('footer')?.remove();
                """);

        $("#firstName").setValue("Jibek");
        $("#lastName").setValue("Tumenbaeva");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("5556676677");
        $("#submit").click();

        $(".modal-dialog").shouldHave(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Jibek Tumenbaeva"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("5556676677"));
    }

    @Test
    void emptyRequiredFieldsTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("""
                    document.getElementById('fixedban')?.remove();
                    document.querySelector('footer')?.remove();
                """);

        $("#submit").click();

        $(".modal-dialog").shouldNot(exist);
    }

    @Test
    void emptyFirstNameTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("""
                    document.getElementById('fixedban')?.remove();
                    document.querySelector('footer')?.remove();
                """);

        $("#lastName").setValue("Tumenbaeva");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("5556676677");
        $("#submit").click();

        $(".modal-dialog").shouldNot(exist);
    }

    @Test
    void invalidPhoneTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("""
                    document.getElementById('fixedban')?.remove();
                    document.querySelector('footer')?.remove();
                """);

        $("#firstName").setValue("Jibek");
        $("#lastName").setValue("Tumenbaeva");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("12345");
        $("#submit").click();

        $(".modal-dialog").shouldNot(exist);
    }
}
