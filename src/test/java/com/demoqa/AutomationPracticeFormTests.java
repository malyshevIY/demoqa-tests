package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.demoqa.Data.email;
import static com.demoqa.Data.mobilePhone;

public class AutomationPracticeFormTests {



    @BeforeAll
    static void configuration() {

        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void fillStudentRegistrationFormTest() {

        open("/automation-practice-form");
        AutomationPracticeFormPage.fillingOutTheForm(email, mobilePhone);
        AutomationPracticeFormPage.validationForm();


    }


}
