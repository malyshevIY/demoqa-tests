package com.demoqa;

import com.codeborne.selenide.ClickOptions;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.demoqa.AutomationPracticeFormTests.email;
import static com.demoqa.AutomationPracticeFormTests.mobilePhone;

public class AutomationPracticeFormPage {

    public static String addedEmail() {
        return "mail_test_ui" + RandomStringUtils.randomAlphanumeric(5) + "@mail.com";
    }

    public static String generatedMobilePhone() {
        return RandomStringUtils.randomNumeric(10);
    }


    public static void fillingOutTheForm(String email, String mobilePhone) {
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue(email);
        $("#gender-radio-1").click(ClickOptions.usingJavaScript()); // add gender
        $("#userNumber").setValue(mobilePhone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(9);
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day--015").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("English").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/beautiful-modern-house.jpg"));
        $("#currentAddress").setValue("Санкт-Петербург, ул.Короблестроителей, 2 корп. 1");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Lucknow")).click();
        $("#submit").click(ClickOptions.usingJavaScript());

    }

    public static void validationForm() {
        $(".modal-body").shouldHave(text("Ivan Ivanov"));
        $(".modal-body").shouldHave(text(email));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text(mobilePhone));
        $(".modal-body").shouldHave(text("15 October,1992"));
        $(".modal-body").shouldHave(text("Maths, English"));
        $(".modal-body").shouldHave(text("Sports, Reading, Music"));
        $(".modal-body").shouldHave(text("beautiful-modern-house.jpg"));
        $(".modal-body").shouldHave(text("Санкт-Петербург, ул.Короблестроителей, 2 корп. 1"));
        $(".modal-body").shouldHave(text("Uttar Pradesh Lucknow"));
        $(".modal-footer").shouldHave(text("Close"));
    }
}
