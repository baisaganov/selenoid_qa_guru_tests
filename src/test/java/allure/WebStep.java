package allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class WebStep {

    @Step("Открываем сайт Гитхаба")
    public void openPage(){
        open("https://github.com");

    }

    @Step("Вводим поисковый запрос")
    public void sendSearch(){
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("[data-target='query-builder.input']")
                .setValue("eroshenkoam/allure-example")
                .pressEnter();
    }

    @Step("Выбираем первый ответ и переходим по нему")
    public void clickOnFirstQueryResult(){
        $$("div.search-title").first().$("a").click();

    }

    @Step("Переходим во вкладку Issues")
    public void switchToIssues(){
        $("#issues-tab").click();
    }

    @Step("Проверяем наименование Issue")
    public void checkIssueName(){
        $("#issue_80_link").shouldHave(Condition.text("e.sh"));
    }

}
