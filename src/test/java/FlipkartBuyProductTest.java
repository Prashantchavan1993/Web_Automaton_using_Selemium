import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FlipkartBuyProductTest {



    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
        driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("ipad");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='Y5N33s']//div/a")));

        Actions act = new Actions(driver);
        act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        driver.findElement(By.xpath("//div[contains(@data-tkid,'SEARCH')]//a")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        String parentWindow = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();

        for (String window : allWindow) {
            if (!parentWindow.equals(window)) {
                driver.switchTo().window(window);
            }

        }

        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
        driver.findElement(By.xpath("//span[text()='Place Order']/parent::button")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("123456789");
        driver.findElement(By.xpath("//span[text()='CONTINUE']/parent::button")).click();


    }

}



