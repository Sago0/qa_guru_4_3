package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void softAssertionsTest(){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(withText("Show 2 more pages")).click();
        $("body").shouldHave(text("SoftAssertions"));
        $(withText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5"));

    }
}
