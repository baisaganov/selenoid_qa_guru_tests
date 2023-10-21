package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryAtTheTop(){
        // ARRANGE
        // ACT
        // ASSERT
        Selenide.open("https://github.com");
        Selenide.$("[data-target='qbsearch-input.inputButtonText']").click();


        Selenide.$("[data-target='query-builder.input']")
                .setValue("selenide")
                .pressEnter();

        Selenide.$$("div.bItZsX")
                .first().$("a").click();

        Selenide.$("a[data-hovercard-type='organization']").shouldHave(Condition.text("\n" +
                "        selenide"));

    }

    @Test
    void bestContributorTest(){
        Selenide.open("https://github.com/selenide/selenide");
        Selenide.$(".BorderGrid")
                .$(Selectors.byText("Contributors"))
                .ancestor(".BorderGrid-cell")
                .$$("ul li").first().hover();

        Selenide.$$(".Popover").findBy(Condition.visible).shouldHave(Condition.text("Andrei Solntsev"));
    }
}
