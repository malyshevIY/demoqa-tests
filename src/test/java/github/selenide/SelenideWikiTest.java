package github.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiTest {

    @BeforeAll
    static void configuration() {

        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void checkWikiSelenideGithubPageTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("ul[data-filterable-for='wiki-pages-filter'] button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $(byText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
