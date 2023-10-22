package allure;

import com.codeborne.selenide.Configuration;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestBaseExtended {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://31.129.109.167:8080/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "104.0";


        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "104.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to set session timeout */
            put("sessionTimeout", "1m");

            /* How to enable video recording */
            put("enableVideo", true);
        }});

        Configuration.browserCapabilities = options;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.getVideoUrl();
    }
}
