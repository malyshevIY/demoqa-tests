package com.demoqa;

import com.codeborne.selenide.ClickOptions;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AutomationPracticeFormPage {

    public static String addedEmail() {
        return "mail_test_ui" + RandomStringUtils.randomAlphanumeric(5) + "@mail.com";
    }

    public static String addedMobilePhone() {
        return RandomStringUtils.randomNumeric(10);
    }

    public static void fillingOutTheForm() {
        $("#firstName").setValue("Иван");
        $("#lastName").setValue("Иванов");
        $("#userEmail").setValue(AutomationPracticeFormPage.addedEmail());
        $("#gender-radio-1").click(ClickOptions.usingJavaScript()); // add gender
        $("#userNumber").setValue(AutomationPracticeFormPage.addedMobilePhone());
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
}
