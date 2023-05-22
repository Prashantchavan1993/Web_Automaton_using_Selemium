import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PackersAndMovers {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\selenium\\chromedriver.exe");
        ChromeOptions option =new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
        driver.get("https://porter.in/packers-and-movers?utm_source=google&utm_medium=cpc&utm_campaign=19012047507&utm_term=142241233605&utm_content=house%20movers%20and%20packers%20near%20me&click_id=CjwKCAjw5dqgBhBNEiwA7PryaGHnsq10U1xN9KrkzUO9JJKI4f984KQJLb9obykoSBaZnALA6ojDxxoC0mcQAvD_BwE&gclid=CjwKCAjw5dqgBhBNEiwA7PryaGHnsq10U1xN9KrkzUO9JJKI4f984KQJLb9obykoSBaZnALA6ojDxxoC0mcQAvD_BwE");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Ex. Amit']")).sendKeys("Pankaj Sharma");
        driver.findElement(By.xpath("//div[text()='+91 - ']/following-sibling::input")).sendKeys("9284195867");
        driver.findElement(By.xpath("//input[@id='custom-autocomplete-Moving From']")).sendKeys("Pune");
        //wait.until(ExpectedConditions.presenceOfElementLocated(""))
        Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        driver.findElement(By.xpath("//input[@id='custom-autocomplete-Moving To']")).sendKeys("Mumbai");
        Thread.sleep(3000);
        act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        driver.findElement(By.xpath("//label[text()='Shifting Date']/following::div/input")).click();
        String expectedMonthAndYear= "March 2023";
        String date= "24";
        while(true){
            String actualMonthAndYear= driver.findElement(By.xpath("//p[text()='March 2023']")).getText();

            if(expectedMonthAndYear.equalsIgnoreCase(actualMonthAndYear)){
                break;
            }
            else{
                driver.findElement(By.xpath("//div[@class='MuiPickersCalendarHeader-switchHeader']/descendant::button[@tabindex='0']")).click();
            }
        }

        driver.findElement(By.xpath("//p[text()='"+date+"']/ancestor::button")).click();
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
        driver.findElement(By.xpath("//div[text()='Appliances(0)']")).click();
        for(int i =1;i<=5; i++){

            driver.findElement(By.xpath("(//div[text()='+'])["+i+"]")).click();
        }

        driver.findElement(By.xpath("//div[text()='Clear all']/following::div[@class='right-content']/button")).click();

        driver.findElement(By.xpath("")).sendKeys("1");
        driver.findElement(By.xpath("")).click();
        driver.findElement(By.xpath("")).sendKeys("2");
        driver.findElement(By.xpath("//div[text()='Drop Details']/following::input[@id='service_lift']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'If your building has a working service lift')]")).click();


        driver.findElement(By.xpath(""));
        driver.findElement(By.xpath("//div[text()='End to end shifting help']/following::button")).click();


    }















}
