package scripts;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
		
		for(WebElement a:menu)
		{
			String text=a.getText();
			System.out.println(text);
			act.moveToElement(a).perform();
			Thread.sleep(3000);
		}
		driver.close();
	}
}
