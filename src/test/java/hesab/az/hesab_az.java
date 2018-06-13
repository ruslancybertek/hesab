package hesab.az;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hesab_az {
	WebDriver driver;

	@BeforeMethod
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://www.hesab.az/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void test() {
		Actions action = new Actions(driver);
		try {
			driver.findElement(By.id("Img2")).click();;
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			WebElement NotClick=driver.findElement(By.xpath("//a[@class='_hj-f5b2a1eb-9b07_widget_open_close _hj-f5b2a1eb-9b07_action_toggle_widget']"));
		
		action.moveToElement(NotClick).click().perform();
		}catch(Exception e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("ucLoginArea_loginArea_UserName")).sendKeys("gitanozg@gmail.com");
		driver.findElement(By.id("ucLoginArea_loginArea_Password")).sendKeys("2259969zgH"+Keys.ENTER);
		driver.findElement(By.className("dashboard-select")).click();
		driver.findElement(By.xpath("//div[@class='dashboard-select-items']//ul//li[1]")).click();
		driver.findElement(By.xpath("//span[.='Xoş gəlmişsiniz,']")).isDisplayed();
		
		action.moveToElement(driver.findElement(By.id("settingslink"))).perform();
		driver.findElement(By.id("ctl00_ucHeader_lbtnLogout")).click();
		driver.findElement(By.id("ucLoginArea_loginArea_btnLoginMobile")).isDisplayed();
		
		
	}
	@AfterMethod
	public void afterMethod(){
		driver.close();
	}
}
