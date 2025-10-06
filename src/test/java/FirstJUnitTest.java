import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


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
        sleep(20000);
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

    }

    @AfterAll
    static void afterAll() {
        sleep(10000);

    }
}
