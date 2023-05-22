import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TATA1MGVeryfiyPoductDetails {


    @Test
    public static void productDetails(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.1mg.com/");
        driver.findElement(By.xpath("//div[@class='style__close-icon___3FflV']")).click();
        driver.findElement(By.xpath("//div[text()='Cancel']")).click();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Boolean searchBox = driver.findElement(By.xpath("//input[@id='srchBarShwInfo']")).isDisplayed();

        Assert.assertTrue(searchBox);  // to check that search box is present or not
        driver.findElement(By.xpath("//input[@id='srchBarShwInfo']")).sendKeys("medicine");
        driver.findElement(By.xpath("//div[@class='header_search_icon']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='SBL Tonicard Gold Drop Homeopathic Medicine']")));

        Boolean filterDisplayed=driver.findElement(By.xpath("//div[text()='Filters']")).isDisplayed();

        Boolean productName= driver.findElement(By.xpath("//div[text()='SBL Tonicard Gold Drop Homeopathic Medicine']")).isDisplayed();
        Boolean productDiscription= driver.findElement(By.xpath("//div[text()='bottle of 100 ml Drop']")).isDisplayed();
        Boolean productImage= driver.findElement(By.xpath("//img[@alt='SBL Tonicard Gold Drop Homeopathic Medicine']")).isDisplayed();
        Boolean productPrice= driver.findElement(By.xpath("//span[text()='23% off']/parent::div/following-sibling::div[text()='310']")).isDisplayed();
        Assert.assertTrue(filterDisplayed);
        Assert.assertTrue(productName);
        Assert.assertTrue(productDiscription);
        Assert.assertTrue(productImage);
        Assert.assertTrue(productPrice);
        System.out.println("We got the Product relevant information such as product name, description, image, and price");

        driver.findElement(By.xpath("//div[text()='SBL Tonicard Gold Drop Homeopathic Medicine']/ancestor::a")).click();

        String parentWindow=driver.getWindowHandle();
        Set<String> allWindows=driver.getWindowHandles();

        for(String window:allWindows){
            if(!parentWindow.equals(window)){
                driver.switchTo().window(window);
            }
        }
        Boolean addToCart = driver.findElement(By.xpath("//div[text()='Add to cart']")).isDisplayed();
        Assert.assertTrue(addToCart);   // Your on new page now if ad to cart is displayed

        String actualIndications= driver.findElement(By.xpath("//strong[text()='Indications:']")).getText();
        String expectedIndications="Indications:";
        Assert.assertEquals(actualIndications,expectedIndications);

        System.out.println("Product page is displayed and contains accurate information");
        System.out.println("Your test case is passed and you are on new webpage");









    }






}
