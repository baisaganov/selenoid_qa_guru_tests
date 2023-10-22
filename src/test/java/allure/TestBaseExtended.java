package allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class TestBaseExtended {
    @BeforeAll
    static void beforeAll(){
        Configuration.remote = "http://localhost:8080/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "117.0";
    }

    @BeforeEach
    public void setup(){
//        Configuration.pageLoadTimeout = 60000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }
}
