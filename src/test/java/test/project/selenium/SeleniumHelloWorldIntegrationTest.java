package test.project.selenium;

import junit.framework.TestCase;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleniumException;

public class SeleniumHelloWorldIntegrationTest extends TestCase {
	
	private DefaultSelenium selenium;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		selenium = createSeleniumClient("http://localhost:8181");
//		selenium = createSeleniumClient("http://localhost:9082/");
		selenium.start();
	}
	
	private DefaultSelenium createSeleniumClient(String url) throws Exception{
		return new DefaultSelenium("localhost", 4444, "*iexplore", url);
	}

	@Override
	protected void tearDown() throws Exception {
		selenium.stop();
		super.tearDown();
	}

	@Test
	public void testHelloWorld() throws Exception {
		try {
			selenium.open("http://localhost:8181/test-automation-app/index.jsp");
			Thread.sleep(7000);
			assertEquals("Hello World!", selenium.getText("//h1"));
		} catch (SeleniumException e) {
			fail(e.getMessage());
			throw e;
		}
	}

}
