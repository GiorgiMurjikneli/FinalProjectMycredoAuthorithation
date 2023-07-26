package StepObject;

import PageObject.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInStep extends LogInPage {
    WebDriver driver;

    public LogInStep(WebDriver driver1) {
        driver = driver1;
    }

    public void userInput(String st) {
        driver.findElement(userField).sendKeys(st);
    }

    public void passwordInput(String st) {
        driver.findElement(passwordField).sendKeys(st);
    }

    public void loginButton() {
        driver.findElement(logInButton).click();
    }

    public String getError() {
        new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500))
                .until(ExpectedConditions.presenceOfElementLocated(alert));
        return driver.findElement(alert).getText();
    }

    public boolean loginButtonIsEnabled() {
        return driver.findElement(logInButton).isEnabled();
    }

    public void clickCurrencyRates() {
        driver.findElement(currencyRates).click();
    }

    public void clickLocation() {
        driver.findElement(locations).click();
    }

    public void clickContact() {
        driver.findElement(contact).click();
    }

    public void checkboxMarkClick() {
        driver.findElement(checkboxMark).click();
    }

    public boolean getCheckboxIsSelected() {
        return driver.findElement(checkboxMark).isSelected();
    }

    public void inputPersonalNum(String personalNumber) {
        driver.findElement(personalNum).sendKeys(personalNumber);
    }

    public String getPersonalNumber() {
        return driver.findElement(personalNum).getAttribute("value");
    }

    public void registrationButtonClick() {
        driver.findElement(registrationButton).click();
    }

    public String getPasswordType() {
        return driver.findElement(passwordField).getAttribute("type");
    }

}
