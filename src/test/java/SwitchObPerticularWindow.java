import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchObPerticularWindow {

    public static void main(String[] args) {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\selenium\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.flipkart.com/");
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://www.example.com");
            driver.findElement(By.linkText("Click Here")).click();

            Set<String> windowHandles = driver.getWindowHandles();

            for (String handle : windowHandles) {

                    driver.switchTo().window(handle);
                    String newWindowTitle = driver.getTitle();
                    if(newWindowTitle.equals("Prashant")){
                        System.out.println("perform the action ur on right page");
                    }

                }

        }

    }







