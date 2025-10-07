import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FirstJUnitTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Maxim");
        $("#lastName").setValue("Barkalov");
        $("#userEmail").setValue("asjldh@als.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1231231231");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--021").click();
        $("#subjectsInput").setValue("Ma").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#currentAddress").setValue("asdasdasd1");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#react-select-3-option-3").click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#react-select-4-option-1").click();
        $("#uploadPicture").uploadFromClasspath("testFile.png");
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Maxim Barkalov"));
        $(".table-responsive").shouldHave(text("asjldh@als.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1231231231"));
        $(".table-responsive").shouldHave(text("21 July,1997"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("testFile.png"));
        $(".table-responsive").shouldHave(text("asdasdasd1"));
        $(".table-responsive").shouldHave(text("Rajasthan Jaiselmer"));
    }
}

