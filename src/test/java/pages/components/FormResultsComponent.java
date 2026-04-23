package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FormResultsComponent {
    public void checkResult(String key, String value) {
        $(".table-responsive tbody")
                .$$("tr")
                .findBy(text(key))
                .shouldHave(text(value));
    }
}
