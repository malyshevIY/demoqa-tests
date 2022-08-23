package github.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PricingHoverTest {

    @BeforeAll
    static void configuration() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void goToContactSalesUsingHover() {
        open(Configuration.baseUrl);
        $(".HeaderMenu").find(byText("Pricing")).hover();
        $("a[href='https://github.com/enterprise/contact']").click();
        $("div h3").shouldHave(Condition.text("Talk to our sales team"));
    }
}
