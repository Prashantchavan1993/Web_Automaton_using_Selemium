import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AmazonFiltersTest {
    @Test
    public static void amazonProduct() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //here i have not used proper xpath means it does not click on exact clickbox it simply click on link

        driver.findElement(By.xpath("//input[@aria-label='Search Amazon.in']")).sendKeys("wrist watch");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        driver.findElement(By.xpath("//i[@class='a-icon a-icon-checkbox']/following::span[text()='Titan']")).click();
        driver.findElement(By.xpath("//i[@class='a-icon a-icon-checkbox']/following::span[text()='Leather']")).click();
       driver.findElement(By.xpath("//i[@class='a-icon a-icon-checkbox']/following::span[text()='Analogue']")).click();
        driver.findElement(By.xpath("//span[text()='25% Off or more']")).click();
     //   WebDriverWait wait = new WebDriverWait(driver,30);
        //wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[@class='a-price-whole']"),3));
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();

        List<WebElement>listOfProduct=driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));

        System.out.println("list size is :"+ listOfProduct.size());

       listOfProduct.get(1).click();    //sometimes it click on fifth element sometimes not so i chose first element or product (list get updated every time)


       String mainWindow= driver.getWindowHandle();
        Set<String>allWindowId=driver.getWindowHandles();

        for(String window: allWindowId){
            if(!window.equals(mainWindow)){
                driver.switchTo().window(window);
            }
        }

            //title changes every time so we cant compare title of page
        String actualResult= driver.findElement(By.xpath("//a[contains(text(),'Back to results' )]")).getText();
        Assert.assertEquals(actualResult,"Back to results");
        System.out.println("Test is passed");







    }



}


