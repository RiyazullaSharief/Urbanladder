package scripts;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScreenShot
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver=new ChromeDriver();
		driver.get("https://www.urbanladder.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();
		Thread.sleep(1000);
		
		List<WebElement> menu=driver.findElements(By.xpath("//span[@class='topnav_itemname']|//a[.='Interiors']"));
		Actions act=new Actions(driver);
		int i=1;
		for(WebElement a:menu)
		{
			act.moveToElement(a).perform();
			String text=a.getText();
			System.out.println(text);
			System.out.println("==================");
			Thread.sleep(3000);
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try
			{
				FileUtils.copyFile(src,new File ("./photos/"+i+"-"+text+".jpg"));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			//captureScreenShot("C://Users//TYSS//Desktop//riyaz//urbanladder//photos//");
			i++;
		}
		driver.close();
	}
}
