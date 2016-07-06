import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import org.openqa.jetty.html.Input;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class HoodpopperTest {

	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for Rudy compilation visualizer for each test
	@Before
	public void setUp() throws Exception {
		driver.get("http://lit-bayou-7912.herokuapp.com");
	}
	

	/**
	 * User Story 1
	 * As a user,
	 * I would like to use Hoodpopper as a Ruby editor,
	 * So that I can start coding.
	 * @author yao
	 *
	 */
	
	
	// Scenario 1
	// Given that I am on the main page
	// When I see the textarea
	// Then I can successfully write code in it.
	@Test
	   public void testCodeDisplay(){
			
		WebElement textArea = driver.findElement(By.id("code_code"));
		textArea.sendKeys("puts 'Cats'");
		assertNotNull(textArea.getText());
		
	}	
	  
	
	
	//Scenario 2
	// Given that I am on the main page
	// When my code includes operators + *
	// When I click on Tokenize link
	// Then I find operator identification on_op
	@Test
	public void testOperaterIdentification(){
		
		WebElement textArea = driver.findElement(By.id("code_code"));
		textArea.sendKeys("c=a+(b*4)");
		WebElement gotoTokenize = driver.findElement(By.xpath("//input[@value='Tokenize']"));
		gotoTokenize.submit();
		
		try{
			WebElement result = driver.findElement(By.cssSelector("code"));
			assertTrue(result.getText().contains("on_op"));
		}catch(NoSuchElementException nseex){
			fail();
		}
	}
	
	
		
	//Scenario 3	
	// Given that I am on the main page
	// When I use "puts" to print strings "Cats"
	// When I click on "Compile" button
	// Then I see the there is keyword---putString in "Compile" page
	@Test
	public void testPutString(){
		
		WebElement textArea = driver.findElement(By.id("code_code"));
		textArea.sendKeys("puts 'Cats'");
		
		WebElement gotoCompile = driver.findElement(By.xpath("//input[@value='Compile']"));
		gotoCompile.submit();
		
		try{
			WebElement result = driver.findElement(By.cssSelector("code"));
			assertTrue(result.getText().contains("putstring"));
		}catch(NoSuchElementException nseex){
			fail();
		}
		
	}
	
	
	
	 /**
	 * User Story 2
	 * As a user,
	 * I would like to see Hoodpopper work normally,
	 * So that I can learn about its functionalities
	 * @author yao
	 *
	 */
	
	// Scenario 4
	// Given that I am on the main page
	// When I click on the "Compile" button
	// Then I should be directed to the "Compile" page
	// Then I should see the head includes word "Compile Operation"
	
	@Test
	public void testCompareHeader(){
		
		WebElement gotoCompile = driver.findElement(By.xpath("//input[@value='Compile']"));
		gotoCompile.submit();
		
		try{
			WebElement result = driver.findElement(By.cssSelector("h1"));
			assertTrue(result.getText().contains("Compile Operation"));
		}catch(NoSuchElementException nseex){
			fail();
		}
		
	}
	
	
	// Scenario 5
	// Given that I am on the "Tokenize" page
	// When I click on the "back" link
	// Then I should be redirected to the main page
	
	@Test
	
	public void testBackLink(){
		
		WebElement gotoTokenize = driver.findElement(By.xpath("//input[@value='Tokenize']"));
		gotoTokenize.submit();
		
		try{
			WebElement goBackToMainPage = driver.findElement(By.linkText("Back"));
			assertTrue(goBackToMainPage.isDisplayed());
		}catch(NoSuchElementException nseex){
			fail();
		}
		
	}
	
	
		
	
	/**
	 * User Story 3
	 * As a user,
	 * I would like to know the design of Hoodpopper,
	 * So that I can talk about more details when I recommend Hoodpopper to someone else 
	 * @author yao
	 *
	 */
	
	
	// Scenario 6
	// Given that I am on the main page
	// When I see the page
	// Then I see that its Title is "Hoodpopper"
		
	@Test
	public void testTitle(){
	
		try{
		     assertEquals("Hoodpopper", driver.getTitle());
		}catch(NoSuchElementException nseex){
			fail();
		}
			
	}	
		
		
	// Scenario 7
	// Given that I am on the main page
	// When I see the page
	// Then I see that it contains word "Code"
	
	@Test
	 public void testHeaderDisplay(){
			
			WebElement mark = driver.findElement(By.cssSelector("label"));
			assertTrue(mark.getText().contains("Code"));
		}	
	
	
	
	// Scenario 8
	// When I go to the front page
	// Then I should see that a input textarea appears
	
	@Test
	public void testTextArea() {
		
		try{
			driver.findElement(By.id("code_code"));	
		}catch(NoSuchElementException nseex){
			fail();
		}
		
	}
	

	
	// Scenario 9
	// Given that I am on the main page
	// When I see the page
	// Then I see that it contains "Tokenize", "Parse", and "Compile" three buttons
	 
	@Test
	 public void testLinks(){		
			
		try{
		 	 //look for "Tokenize" button
			 driver.findElement(By.xpath("//input[@value='Tokenize']"));
			 //look for "Parse" button
			 driver.findElement(By.xpath("//input[@value='Parse']"));
			 //look for "Compile" button
			 driver.findElement(By.xpath("//input[@value='Compile']"));
		}catch(NoSuchElementException nseex){
			fail();
		}
	
	}	
	
	
	
	// Scenario 10
	// Given that I am on the main page
	// When I click on three buttons 
    // Then I am directed to different pages
		
	 @Test
	 public void testCompileContext(){	
		
		 try{
		   //look for Tokenize button and click
		    WebElement gotoTokenize = driver.findElement(By.xpath("//input[@value='Tokenize']"));
			assertTrue(gotoTokenize.isDisplayed());
			//look for Parse button and click
			WebElement gotoParse = driver.findElement(By.xpath("//input[@value='Parse']"));
			assertTrue(gotoParse.isDisplayed());
			//look for Compile button and click
			WebElement gotoCompile = driver.findElement(By.xpath("//input[@value='Compile']"));
			assertTrue(gotoCompile.isDisplayed());
		 }catch(NoSuchElementException nseex){
			 fail();
		 }		    
	}	

}
