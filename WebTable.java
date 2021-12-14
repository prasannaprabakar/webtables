package login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebTable
{
    WebDriver driver;
    @BeforeTest
    public void chrome()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

    }
    @Test
    public void readData(){
        List<WebElement> tableHeader = driver.findElements(By.xpath("//thead[@style='margin: 0px; padding: 0px;']//child::*"));
        List<WebElement> cells = driver.findElements(By.xpath("//tbody[@style='margin: 0px; padding: 0px;']//child::*"));
        //System.out.println( tableHeader.getText());
        for( WebElement values : tableHeader){
            System.out.println(values.getText());
        }
        for (WebElement cell:cells)
        {
            System.out.println(cell.getText());
        }
    }
    @Test
    public void countStructure(){
        List<WebElement> structure = driver.findElements(By.xpath("//tbody/tr/th"));
        WebElement total=driver.findElement(By.xpath("//td[contains(text(),'4 buildings')]"));
       String str= total.getText();
       String num= String.valueOf(str.charAt(0));
       // System.out.println(num);
        if (structure.size() == Integer.parseInt(num)){
            System.out.println("number of structure = "+structure.size());
            System.out.println("Total = "+num);
        }

    }
@AfterTest
    public void close(){
        driver.quit();
}

}
