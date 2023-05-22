import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Pr {

public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\selenium\\chromedriver.exe");
        ChromeOptions option =new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
        driver.get("https://porter.in/packers-and-movers?utm_source=google&utm_medium=cpc&utm_campaign=19012047507&utm_term=142241233605&utm_content=house%20movers%20and%20packers%20near%20me&click_id=CjwKCAjw5dqgBhBNEiwA7PryaGHnsq10U1xN9KrkzUO9JJKI4f984KQJLb9obykoSBaZnALA6ojDxxoC0mcQAvD_BwE&gclid=CjwKCAjw5dqgBhBNEiwA7PryaGHnsq10U1xN9KrkzUO9JJKI4f984KQJLb9obykoSBaZnALA6ojDxxoC0mcQAvD_BwE");
    driver.manage().window().maximize();
Thread.sleep(3000);
        List<WebElement> ele =  driver.findElements(By.xpath("//div[@class='scf-calendar-date-card']"));

        for(WebElement e:ele){
            System.out.println(e.getText());

        }

    }


}
