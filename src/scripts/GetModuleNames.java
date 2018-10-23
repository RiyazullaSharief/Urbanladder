package scripts;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
public class GetModuleNames
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.urbanladder.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();
		Thread.sleep(1000);
		
		List<WebElement> menu=driver.findElements(By.xpath("//span[@class='topnav_itemname']|//a[.='Interiors']"));
		Actions act=new Actions(driver);
		
		String[] expectedTitle={"Sale","Living","Bedroom","Dining","Storage","Study","Mattresses","Interiors","Decor","New","Collections"};
		int i=0;
		for(WebElement a:menu)
		{
			String actualTitle=a.getText();
			System.out.println(actualTitle);
			Assert.assertEquals(actualTitle,expectedTitle[i]);
			Reporter.log("Matched...!!",true);
			act.moveToElement(a).perform();
			i++;
			Thread.sleep(3000);
		}
		driver.close();
	}
}
