package junit;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class JUnitSimpleTest {

    static Stream<Arguments> checkingCategories(){
        return Stream.of(Arguments.of(List.of("Elements",
                "Forms",
                "Alerts, Frame & Windows",
                "Widgets",
                "Interactions",
                "Book Store Application"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Отображаются ли кнопки {0} на сайте")
    @Tag("Critical")
    void checkingCategories(List<String> buttons){
        open("https://demoqa.com");
        $$(".card").filter(visible)
                .shouldHave(CollectionCondition.texts(buttons));
    }
}
