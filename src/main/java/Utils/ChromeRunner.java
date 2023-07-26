package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ChromeRunner {
    public static WebDriver driver = new ChromeDriver();

    @BeforeTest (description = "Chrome ბრაუზერის გახსნა")
    public void openChrome(){
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest (description = "Chrome ბრაუზერის დახურვა")
    public void closeChrome(){
        driver.close();
    }
}
