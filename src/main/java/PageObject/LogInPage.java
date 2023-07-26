package PageObject;

import org.openqa.selenium.By;

public class LogInPage {
    protected By userField = By.id("userName");
    protected By passwordField = By.id("newPass");
    protected By logInButton = By.id("submitAuth");
    protected By alert = By.id("growlText");
    protected By currencyRates = By.linkText("ვალუტის კურსები");
    protected By locations = By.linkText("ლოკაციები");
    protected By contact = By.linkText("კონტაქტი");
    protected By checkboxMark = By.id("checkBoxSavedUser");
    protected By personalNum = By.id("personalNumRegistration");
    protected By registrationButton = By.id("subbnitButton");

}
