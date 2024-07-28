package ecommerce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment {

	public static void main(String[] args) throws AWTException, IOException {
		

		        //Launching the Browser
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\Authenticate\\driver\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				
				//Launching the Amazon Website
				driver.get("https://www.amazon.in/");
				driver.manage().window().maximize();
				//Searching the Product and open the products listing page
				WebElement amsearch = driver.findElement(By.xpath("(//input[@type='text'])"));
		        amsearch.sendKeys("Titan Leather Analog Green Dial Men's Watch-1874Nl01, Band Color-Black");
		        driver.findElement(By.xpath("//input[@type='submit']")).click();
		        //Moving to the detail page by clicking the product
		        Actions ac=new Actions(driver);
		        WebElement source = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
		        WebElement dest = driver.findElement(By.xpath("(//span[contains(text(),'Watch-1874Nl01')])[2]"));
		        ac.dragAndDrop(source, dest).perform();
		        //Restricting from moving back to listing page tab
		        driver.findElement(By.xpath("(//span[contains(text(),'Watch-1874Nl01')])[2]")).click();
		        Set<String> windowHandles = driver.getWindowHandles();
		        String originalTab = driver.getWindowHandle(); // Store original tab handle
		        String newTab = null;

		        for (String handle : windowHandles) {
		            if (!handle.equals(originalTab)) {
		                newTab = handle;
		                break;
		            }
		        }

		        driver.switchTo().window(newTab);
		        
		        // Take a screenshot
		        TakesScreenshot tk=(TakesScreenshot)driver;
		        File temp1=tk.getScreenshotAs(OutputType.FILE);
		        File amstore=new File("C:\\Users\\User\\eclipse-workspace\\Authenticate\\Amazon Screenshot.png");
		        FileUtils.copyFile(temp1, amstore);
		        driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
		        driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
		        //Opening a new tab and launching the flipkart website
		        driver.switchTo().newWindow(WindowType.TAB);
		        driver.get("https://www.flipkart.com/");
		        driver.manage().timeouts().implicitlyWait(07,TimeUnit.SECONDS);

				//Searching the product
				 WebElement fpsearch = driver.findElement(By.xpath("//input[@type='text']"));
			     fpsearch.sendKeys("NQ9308BM01 Analog Watch - For Men NN9308BM01");
			     driver.findElement(By.xpath("//button[@type='submit']")).click();
			     //Moving to product and clicking view the detail page
			     WebElement fpdest = driver.findElement(By.xpath("//div[@data-id='WATEH6Y4RTVPYGDB']"));
			     driver.manage().timeouts().implicitlyWait(02,TimeUnit.SECONDS);
	             ac.moveToElement(fpdest).perform();
	             fpdest.click();

		         Set<String> handles = driver.getWindowHandles();
                 String fourthTabHandle = (String) handles.toArray()[3];
		         driver.switchTo().window(fourthTabHandle);
		         //Take screenshot   
			     driver.manage().timeouts().implicitlyWait(03,TimeUnit.SECONDS);
			     File temp2=tk.getScreenshotAs(OutputType.FILE);
			     File fpstore=new File("C:\\Users\\User\\eclipse-workspace\\Authenticate\\Flipkart Screenshot.png");
			     FileUtils.copyFile(temp2, fpstore);
			     //Add the product to the Cart
			     driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS);    
			     WebElement addcart = driver.findElement(By.xpath("//a[@class='bmE8yc roDWdc']"));
     		     ac.moveToElement(addcart).perform();
     		     driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS);
			     driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
			     //Proceeding to Checkout page
			     driver.findElement(By.xpath("//span[text()='Place Order']")).click();
			        
			        

		            //refresh  the project to view the screenshot		 
			     driver.quit();
			}
	         

		}