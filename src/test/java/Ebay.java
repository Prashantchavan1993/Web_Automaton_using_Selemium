import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ebay {
    public static void main(String[] args) {
      System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//span[text()='Condition']/ancestor::button")).click();


        List<WebElement> ele =driver.findElements(By.xpath("//ul[@id='s0-51-16-5-4[1]-54[1]-10-content-menu']/li"));
        System.out.println(ele.size());

       // driver.findElement(By.xpath("")).click();




    }


}