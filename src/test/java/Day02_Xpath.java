import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day02_Xpath {
    static WebDriver driver;


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
       driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://a.testaddressbook.com/");
        WebElement sign=driver.findElement(By.linkText("Sign in"));
        sign.click();
       List<WebElement> ful=driver.findElements(By.tagName("body"));
       for (WebElement a:ful){
           System.out.println(a.getText());
           WebElement email=driver.findElement(By.cssSelector("#session_email"));
           email.sendKeys("testtechproed@gmail.com");
           WebElement password=driver.findElement(By.cssSelector("#session_password"));
           password.sendKeys("Test1234!"+ Keys.ENTER);

           Thread.sleep(4);

           List<WebElement> tum=driver.findElements(By.tagName("body"));
           for (WebElement yazi:tum) {
               System.out.println(">>>> "+yazi.getText());
           }


       }



    }
    @AfterClass
    public static void teardown(){

        //driver.quit();
    }
}
