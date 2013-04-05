package test.project.selenium;

import java.io.File;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.thoughtworks.selenium.SeleniumException;

public class SeleniumUploadFileIntegrationTest extends TestCase {
	
	WebDriver driver;
	
	Boolean hasTestUploadFileTextEmpty = true;
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		driver = new FirefoxDriver();
		testUploadFileFails();
	}
	

	@After
	protected void tearDown() throws Exception {		   
		super.tearDown();
		 //Close the browser
        driver.quit();    
	}

	@Test
	public void testUploadFileFails() throws Exception {
		try {
			
	        // Create a new instance of the 'Browser' driver
	        // Notice that the remainder of the code relies on the interface, 
	        // not the implementation.
	        
			//-- Configure IExplorer server...
//			File file = new File("E:/Formacion/config_Selenium/IEDriverServer.exe");
//			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
//			WebDriver driver = new InternetExplorerDriver();
			
	        // And now testing a JSP...
	        driver.get("http://localhost:8181/test-jersey-webapp/fileTransfer.jsp");
	        System.out.println("Page Source =" + driver.getPageSource());	        
	        System.out.println("Page title is: " + driver.getTitle());
	        
	        //--Get the form tag by Id
	        WebElement elementForm = driver.findElement(By.id("uploadFileForm"));
	        System.out.println("elementForm tag name=" + elementForm.getTagName());
	        
	        // Find the User text input element by name
	        WebElement elementUserText = driver.findElement(By.name("user"));	        
	        // Enter something to the form
	        elementUserText.sendKeys("ramon");
	        
	        // Find the File text input element by name
	        WebElement elementFileText = driver.findElement(By.name("file"));		        
	        hasTestUploadFileTextEmpty = elementFileText.getText()==null || elementFileText.getText().equals("");
	        System.out.println("hasTestUploadFileTextEmpty: " + hasTestUploadFileTextEmpty);
	      
	        // Now submit the form. WebDriver will find the form for us from the element
	        WebElement elementSubmit = driver.findElement(By.name("upload"));
	        
	        elementSubmit.submit();
	     	
	        // Assert success when File Text is Null or empty...
	        assertEquals(true, hasTestUploadFileTextEmpty.booleanValue() );
	        
	       
		} catch (SeleniumException e) {
			fail(e.getMessage());
			throw e;
		}
	}

}
