import StepObject.LogInStep;
import Utils.ChromeRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static DataObject.LoginData.*;

public class Authorization extends ChromeRunner {
    SoftAssert softAssertion = new SoftAssert();
    LogInStep logInStep = new LogInStep(driver);

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://mycredo.ge/landing/main/auth");
    }

    @Test(priority = 1)
    @Description("დალოგინება არასწორი მონაცემებით")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://mycredo.ge/")
    public void logInWithIncorrectData(){
        logInStep.userInput(incorrectUserData);
        logInStep.passwordInput(incorrectPasswordData);
        logInStep.loginButton();

        String expectedResult = "მონაცემები არასწორია";
        String actualResult = logInStep.getError();
        softAssertion.assertEquals(actualResult, expectedResult);
        softAssertion.assertAll();
    }

    @Test(priority = 2)
    @Description("დალოგინება სწორი იუზერით და არასწორი პაროლით")
    @Severity(SeverityLevel.BLOCKER)
    public void logInWithCorrectUserAndInCorrectPassword(){
        logInStep.userInput(correctUserData);
        logInStep.passwordInput(incorrectPasswordData);
        logInStep.loginButton();
        String expectedResult = "მონაცემები არასწორია";
        String actualResult = logInStep.getError();

        softAssertion.assertEquals(actualResult, expectedResult);
        softAssertion.assertAll();
    }
    @Test(priority = 3)
    @Description("მოწმდება ცარიელი იუზერით და არასწორი პაროლით აქტიურდება თუ არა შესვლის ღილაკი")
    @Severity(SeverityLevel.MINOR)
    public void withEmptyUserDisabledLoginButton(){
        logInStep.userInput(emptyUserData);
        logInStep.passwordInput(incorrectPasswordData);
        softAssertion.assertFalse(logInStep.loginButtonIsEnabled());
    }

    @Test(priority = 4)
    @Description("მოწმდება სწორი იუზერით და არასწორი პაროლით აქტიურდება თუ არა შესვლის ღილაკი")
    @Severity(SeverityLevel.MINOR)
    public void withEmptyPasswordDisabledLoginButton(){
        logInStep.userInput(correctUserData);
        logInStep.passwordInput(emptyPasswordData);
        softAssertion.assertFalse(logInStep.loginButtonIsEnabled());
    }

    @Test(priority = 5)
    @Description("მოწმდება ვალუტის კურსების გვერდი")
    @Severity(SeverityLevel.MINOR)
    public void currencyRatesPage(){
        logInStep.clickCurrencyRates();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://mycredo.ge/landing/currency");
    }

    @Test(priority = 6)
    @Description("მოწმდება ლოკაციების გვერდი")
    @Severity(SeverityLevel.MINOR)
    public void locations() {
        logInStep.clickLocation();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://mycredo.ge/landing/atms");
    }

    @Test(priority = 7)
    @Description("მოწმდება კონტაქტის გვერდი")
    @Severity(SeverityLevel.NORMAL)
    public void contactPage() {
        logInStep.clickContact();
        String contactURL = driver.getCurrentUrl();
        Assert.assertEquals(contactURL, "https://mycredo.ge/landing/contact");
    }
    @Test(priority = 8)
    @Description("შემოწმდა მომხმარებლის დამახსოვრების ღილაკის მონიშვნა")
    @Severity(SeverityLevel.NORMAL)
    public void checkbox(){
        logInStep.checkboxMarkClick();
        Assert.assertTrue(logInStep.getCheckboxIsSelected());
    }
    @Test(priority = 9)
    @Description("შემოწმდა რეგისტრაციაში პირადი ნომრის ველში შეყვანილი სიმბოლოების რაოდენობა")
    @Severity(SeverityLevel.MINOR)
    public void characterLimit(){
        logInStep.registrationButtonClick();
        logInStep.inputPersonalNum(personalNumLength);
        Assert.assertEquals(logInStep.getPersonalNumber().length(), 11);
    }
    @Test(priority = 10)
    @Description("შემოწმდა პასვორდის ველის ტიპი")
    @Severity(SeverityLevel.NORMAL)
    public void passwordFieldCheck(){
        Assert.assertEquals(logInStep.getPasswordType(), "password");
    }

}
