package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test   // doesn't work
    void dragAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").find("header").shouldHave(text("B"));
        $("#column-b").find("header").shouldHave(text("A"));
    }

    @Test   // doesn't work
    void dragAndDropClickAndMoveTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a header").shouldHave(text("A"));
        $("#column-b header").shouldHave(text("B"));

        actions().clickAndHold($("#column-a"))
                .moveToElement($("#column-b"))
                .release().perform();

        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }

}
