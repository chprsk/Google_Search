package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Test1 {
	
	public WebDriver driver;
	
	
  @BeforeClass
  public void setup(ITestContext context) throws InterruptedException {
	  
	String browser=context.getCurrentXmlTest().getParameter("browser");
	 if(browser.equalsIgnoreCase("Chrome")){
	  System.setProperty("webdriver.chrome.driver", "D://SELENIUM IDE//chromedriver.exe");
	  
	  driver=new ChromeDriver();
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	 }
	 
	
	 
	 else if(browser.equalsIgnoreCase("firefox")){
		 System.setProperty("webdriver.gecko.driver", "D://SELENIUM IDE//geckodriver.exe");
		 driver=new FirefoxDriver();
		 
	 }
	 
  }
  @Test(priority=1)
  public void open_url(){
	  
	  driver.get("https://www.google.com/");
	  String title=driver.getTitle();
	  System.out.println("Title of page is"+title);
	  
  }
  @Test(dependsOnMethods="open_url")
  
  public void type_data() throws InterruptedException{
	 WebElement sbox= driver.findElement(By.xpath("//input[@name='q']"));
	  sbox.sendKeys("Does recesion is true in software");
	  sbox.submit();
	  
	  Thread.sleep(5000);
  }
  @Test(dependsOnMethods="type_data")
  public void tear_down(){
	  
	  driver.close();
	  
  }
}
