package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import jdk.jfr.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CheckIssueNameOnGitTest extends TestBaseExtended {

    @DisplayName("Тест на проверку задачи с использованием Listener")
    @Test
    void selenideTest(){
        open("https://github.com");

        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("[data-target='query-builder.input']")
                .setValue("eroshenkoam/allure-example")
                .pressEnter();

        $$("div.search-title").first().$("a").click();

        $("#issues-tab").click();

        $("#issue_80_link").shouldHave(Condition.text("e.sh"));

    }

    @DisplayName("Тест на проверку задачи с лямбд")
    @Test
    @Tag("remote")
    void selenideLambdaStep(){

        step("Открываем сайт Гитхаба", () -> {
            open("https://github.com");
        });

        step("Вводим поисковый запрос", () -> {
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("[data-target='query-builder.input']")
                    .setValue("eroshenkoam/allure-example")
                    .pressEnter();
        });

        step("Выбираем первый ответ и переходим по нему", () -> {
            $$("div.search-title").first().$("a").click();
        });

        step("Переходим во вкладку Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наименование Issue", () -> {
            $("#issue_80_link").shouldHave(Condition.text("e.sh"));
        });
    }

    @DisplayName("Тест на проверку задачи с WebStep")
    @Test
    void webStepTest(){

        WebStep webStep = new WebStep();

        webStep.openPage();
        webStep.sendSearch();
        webStep.clickOnFirstQueryResult();
        webStep.switchToIssues();
        webStep.checkIssueName();
    }




}
