import java.util.NoSuchElementException;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;







public class LaunchBrowser {
	
	WebDriver driver;
	@Before
	public void launch() {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}
	//@SuppressWarnings("deprecation")
	@Test
	public void loginTest() {
		//Storing Web Element
		//Element Liberary
		
		By USERNAME_FIELD_LOCATOR = By.xpath("//input[@id='username]");
		
		WebElement USERNAME_FIELD = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_FIELD =driver.findElement(By.xpath("//input[@id='password']"));
		WebElement SIGNIN_BUTTON = driver.findElement(By.xpath("//button[@name='login']"));
		
		USERNAME_FIELD.clear();
		
		USERNAME_FIELD.sendKeys("demo@techfios.com");
		PASSWORD_FIELD.sendKeys("abc123");
		SIGNIN_BUTTON.click();
		
		boolean pageTitelDisplayStatus;
		try {
			WebElement DASHBORD_PAGE_TITEL_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));
			pageTitelDisplayStatus = true;
		}catch(NoSuchElementException e){
			pageTitelDisplayStatus = false;
			e.printStackTrace();
			
		}
		
		
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"))));
		
		//System.out.println(DASHBOARD_PAGE_TITLE_ELEMENT.getText());
		
		//Assert.assertTrue("Dashboard Page Not Founnd!",, DASHBOARD_PAGE_TITLE_ELEMENT.isDisplayed,()););
		
		//System.out.println(DASHBORD_PAGE_TITEL_ELEMENT.getText());
		//pageTitelDisplayStatus = false;
		
		Assert.assertTrue("Dashboard Page Not Founnd!",pageTitelDisplayStatus);
		
	
	}
	
//	@Test
//	public void testAddition() {
//		Assert.assertEquals(2.0, 2.02, 0.021);
//	}

}
