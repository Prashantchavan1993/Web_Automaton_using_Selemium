import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SoulUp {
    public static void main(String[] args) {

        //User Story=Peer-conversation Dropdown->Life choices->Filters>>click on topic>>clci on Anxiety>>clcik on one of the Psychatrist>>>validate the schdule buton display
        //click on schedule button>>pick date>>pick time slot>>confirm the slot>>check header is displyed i.e Your conversation.

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.soulup.in/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[text()='Peer Conversations']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='HeaderMenu-MenuList-1']/descendant::a[contains(text(),'Life Choices')]")));
        driver.findElement(By.xpath("//ul[@id='HeaderMenu-MenuList-1']/descendant::a[contains(text(),'Life Choices')]")).click();
        driver.findElement(By.xpath("//details[@id='Details-1-template--14492551577662__product-grid']/child::summary/descendant::span")).click();
        WebElement ele=driver.findElement(By.xpath("//ul[@class=' facets__list list-unstyled no-js-hidden']/descendant::input[@value='Anxiety']"));
        Actions act = new Actions(driver);
        act.moveToElement(ele).click().build().perform();
        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'How Peer Conversations help.')]"));
        act.moveToElement(header).click().build().perform();

        driver.findElement(By.xpath("//a[@id='CardLink-template--14492551577662__product-grid-7047759626302']")).click();
        WebElement scheduleButton=  driver.findElement(By.xpath("//div[@id='appointo-btn']"));
        wait.until(ExpectedConditions.visibilityOf(scheduleButton));
        scheduleButton.click();

        //write code for calender
        //  Boolean scheduleBtn=driver.findElement(By.xpath("//div[@id='appointo-btn']")).isDisplayed();
        //  Assert.assertTrue(scheduleBtn);
        //  driver.quit();
        //  System.out.println("Test passed successfully");

        WebElement timeTExt= driver.findElement(By.xpath("//p[text()='Timezone: Asia/Calcutta']"));
        wait.until(ExpectedConditions.visibilityOf(timeTExt));
        String expectedMonthAndYear= "March 2023";
        String date= "21";
        String timeSlotIndex="1";

        while(true){
            String actualMonthAndYear= driver.findElement(By.xpath("//div[@data-calendar-label='month']")).getText();

            if(expectedMonthAndYear.equalsIgnoreCase(actualMonthAndYear)){
               break;
            }
            else{
                driver.findElement(By.xpath("//button[@data-calendar-toggle='next']")).click();
            }
        }

        driver.findElement(By.xpath("//span[text()='"+date+"']/parent::div")).click();
        WebElement timeSlot=driver.findElement(By.xpath("//div[@id='appointo-slot-"+timeSlotIndex+"']"));
        timeSlot.click();
        driver.findElement(By.xpath("//div[@id='appointo-confirm']")).click();
        Boolean headerOfConversation =driver.findElement(By.xpath("//h1[text()='Your conversations']")).isDisplayed();
        Assert.assertTrue(headerOfConversation);
        System.out.println("Header is displayed successfully ");
        System.out.println("Test passed successfully");



    }
}
