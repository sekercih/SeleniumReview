import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_isDisplayed {
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void isDisplayed(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement baslik=driver.findElement(By.xpath("//h4[.='Dynamic Controls']"));
        boolean gorunuyormu=baslik.isDisplayed();
        System.out.println(gorunuyormu);
        Assert.assertTrue("Dynamic Controls",gorunuyormu);
    }
    @Test
    public void isSelect(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement secim=driver.findElement(By.xpath("//input[@type='checkbox']"));
        secim.click();
        boolean secilimi=secim.isSelected();

        System.out.println(secilimi);

    }
    @Test
    public void isEnabled() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement enabled=driver.findElement(By.xpath("//input[@type='text']"));
        boolean aktifmi=enabled.isEnabled();
        System.out.println("aktif mi= "+aktifmi);

        WebElement enabletikla=driver.findElement(By.xpath("//*[.='Enable']"));
        enabletikla.click();
        Thread.sleep(5000);

        boolean aktifmi1=enabled.isEnabled();
        System.out.println("aktif mi1= "+aktifmi1);
        WebElement enableyazi=driver.findElement(By.xpath("//input[@type='text']"));
        enableyazi.sendKeys("Maşallah");
        Thread.sleep(5000);
        enabletikla.click();


    }


}
