import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
public class ExecuteJavascript {
    public static void main(String[] args) throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "/Users/meaghanlewis/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        driver.findElement(By.id("first-name")).sendKeys("Long");

        driver.findElement(By.id("radio-button-1")).click();
        driver.findElement(By.id("radio-button-2")).click();

        driver.findElement(By.cssSelector("option[value='2']")).click();

        driver.findElement(By.id("datepicker")).sendKeys("08/15/1989");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        //driver.findElement(By.cssSelector(".btn .btn-lg .btn-primary")).click();
        driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));
        String expected = "The form was successfully submitted!";
        String alertText = alert.getText();

        assertEquals(expected, alertText);

        Thread.sleep(3000);
        driver.quit();
    }


}
