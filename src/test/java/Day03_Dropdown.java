import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day03_Dropdown {
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public  void dropdown1(){
       driver.get("https://www.amazon.com/");
        WebElement dropdown=driver.findElement(By.xpath("searchDropdownBox"));
        Select select=new Select(dropdown);
        select.getFirstSelectedOption();
        select.selectByVisibleText("Baby");
        select.selectByIndex(5);

        List<WebElement> list=select.getOptions();
        for (WebElement tum:list){
            System.out.println(tum.getText());


        }





    }
}
