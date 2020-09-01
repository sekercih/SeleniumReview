import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {
    WebDriver driver;
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        WebElement element=driver.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys("baby strolle"+ Keys.ENTER);
        WebElement ikinciSira=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
               ikinciSira.click();
     WebElement fiyat=driver.findElement(By.id("priceblock_ourprice"));
        System.out.println("arabanın fiyatı  :"+fiyat.getText());
        driver.close();


    }
    @Test
    public void test2(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        WebElement element=driver.findElement(By.name("q"));
        element.sendKeys("kemal"+Keys.ENTER);
        WebElement sonuc=driver.findElement(By.id("result-stats"));
        System.out.println("sonuc sayısı= "+sonuc.getText());
        driver.manage().timeouts().implicitlyWait(8000,TimeUnit.SECONDS);
        driver.quit();

    }
}
