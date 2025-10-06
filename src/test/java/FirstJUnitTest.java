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
        Configuration.browserCapabilities.setCapability("pageLoadStrategy", "eager");
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Maxim");
        $("#lastName").setValue("Barkalov");
        $("#userEmail").setValue("asjldh@als.ru");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("1231231231");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $("[value='6']").click();
        $(".react-datepicker__year-select").click();
        $("[value='1997']").click();
        $(".react-datepicker__day--021").click();
        $("#subjectsInput").setValue("Ma").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        $("#currentAddress").setValue("asdasdasd1");
        $(byText("Select State")).click();
        $("#react-select-3-option-3").click();
        $(byText("Select City")).click();
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
