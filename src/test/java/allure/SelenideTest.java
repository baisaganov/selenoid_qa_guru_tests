package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import jdk.jfr.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideTest {

    @BeforeEach
    public void setup(){
        Configuration.pageLoadTimeout = 60000;
    }

    @Name("Проверка нахождения issue под номер 80")
    @Test
    public void testIssueSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем сайт", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий", () -> {
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("[data-target='query-builder.input']")
                    .setValue("eroshenkoam/allure-example")
                    .pressEnter();
        });

        step("Кликаем по ссылке репозитория", ()-> {
            $$("div.bItZsX")
                    .first().$("a").click();
        });

        step("Открываем вкладку Issues", ()-> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие Issue под номером 80", ()-> {
            $(Selectors.withText("#80")).should(Condition.exist);
        });

    }
}
