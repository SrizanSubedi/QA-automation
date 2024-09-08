package automation1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Shopping extends User_setup {
	
	@Test
	public static void Login()  {
		
		//Login
//		driver.findElement(By.name("email")).sendKeys("srijan222@gmail.com");
//		driver.findElement(By.name("password")).sendKeys("Shopping88");
//		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		//Add item no 2
		driver.findElement(By.xpath("//*[@data-product-id=\"2\"]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
		
		//Scroll down to item no 24
		WebElement element= driver.findElement(By.cssSelector("[data-product-id='24']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		//Add item no 24 and view cart
		driver.findElement(By.xpath("//*[@data-product-id=\"24\"]")).click();
		driver.findElement(By.linkText("View Cart")).click();
		
		//Remove item 2 from cart and proceed to checkout
		driver.findElement(By.xpath("//*[@data-product-id=\"2\"]")).click();
		driver.findElement(By.linkText("Proceed To Checkout")).click();
		driver.findElement(By.name("message")).sendKeys("Please deliver it soon!");
		driver.findElement(By.linkText("Place Order")).click();
		
		//Confirm Payment
		driver.findElement(By.name("name_on_card")).sendKeys("SRZ");
		driver.findElement(By.name("card_number")).sendKeys("657");
		driver.findElement(By.name("cvc")).sendKeys("099");
		driver.findElement(By.name("expiry_month")).sendKeys("12");
		driver.findElement(By.name("expiry_year")).sendKeys("2028");
		driver.findElement(By.id("submit")).click();
		
		//Download Invoice
		driver.findElement(By.linkText("Download Invoice")).click();
		driver.findElement(By.linkText("Continue")).click();
		
		
	}
	
	@AfterClass
	public static void postcondition() throws InterruptedException
	{
		System.out.println("postcondition");
		Thread.sleep(2000);
		driver.close();
	}
}
