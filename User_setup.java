package automation1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class User_setup {
	
	public static String url ="https://automationexercise.com/";
	public static ChromeDriver driver;
	
	@BeforeSuite
	public static void openbrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		WebElement link = driver.findElement(By.linkText("Signup / Login"));
        link.click();
        
        //sign up Process
            driver.findElement(By.name("name")).sendKeys("srijan");
            driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("srijan222@gmail.com");
            driver.findElement(By.xpath("//button[contains(text(),'Signup')]")).click();
      		
      		driver.findElement(By.id("uniform-id_gender1")).click();
     		driver.findElement(By.id("password")).sendKeys("Shopping88");
      		Select day=new Select(driver.findElement(By.name("days")));
      		day.selectByIndex(1);
      		Select month=new Select(driver.findElement(By.name("months")));
      		month.selectByIndex(1);
      		Select year=new Select(driver.findElement(By.name("years")));
     		year.selectByIndex(1);
      		driver.findElement(By.id("first_name")).sendKeys("abc");
      		driver.findElement(By.id("last_name")).sendKeys("xyz");
      		driver.findElement(By.id("company")).sendKeys("home");
      		driver.findElement(By.id("address1")).sendKeys("ktm");
      		Select coun=new Select(driver.findElement(By.name("country")));
      		coun.selectByIndex(2);
      		driver.findElement(By.id("state")).sendKeys("cal");
      		driver.findElement(By.id("city")).sendKeys("la");
      		driver.findElement(By.id("zipcode")).sendKeys("+80");
      		driver.findElement(By.id("mobile_number")).sendKeys("09876");
      		driver.findElement(By.xpath("//button[contains(text(),'Create Account')]")).click();
     		driver.findElement(By.linkText("Continue")).click();
	}
	
}



