package gceone.gceone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class steps {
   
	private static WebDriver driver = null;
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		  driver = new FirefoxDriver();
 	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 
	        driver.get("http:172.30.59.48/gce/");
	        
	  
	         Thread.sleep(3000);
	        driver.navigate().refresh();
	     
	        driver.findElement(By.xpath(".//*[@id='chp:USER']")).sendKeys("GNC");
	        driver.findElement(By.xpath(".//*[@id='chp:PASSWORD']")).sendKeys("INFOR1");
	        driver.findElement(By.xpath(".//*[@id='validation']")).click();

   
	    
	}
	
	 
	@When("^User enters Function$")
	public void user_enters_Function() throws Throwable {
	 	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	 driver.switchTo().frame("mbanner") ;
		 	driver.findElement(By.xpath(".//*[@id='chp:Fct']")).sendKeys("I_ACHAT_F") ;
	 	driver.findElement(By.xpath(".//*[@id='Fct']/input[2]")).click();
	 	 
   //  driver.get("http://172.30.59.48/gce/GCE/ServletControl?sourceview=I_ACHAT_F&cinematic=forward%280%29&&chp:Origine=I_ACHAT_F&entity=1&id=&frame=default&forceDisplay=");
	     Thread.sleep(5000);
	  //      driver.navigate().refresh();
 
	}
 /*
	@And("^clicks on start$")
	public void clicks_on_start() throws Throwable {
		 driver.findElement(By.xpath(".//*[@id='Fct']/input[2]")).click();
	    throw new PendingException();
	}*/

	@Then("^User able to go to purchase portal$")
	public void user_able_to_go_to_purchase_portal() throws Throwable {
		
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs1.get(1));
	    
	 	driver.switchTo().frame("banner") ;
	String titleone = 	driver.findElement(By.xpath("html/body/div[2]/h1")).getText() ;
	    System.out.println("Successfully opened " + titleone );
	    
	

	}

	@When("^User click on supplier returns and enters details$")
	public void user_click_on_supplier_returns() throws Throwable {
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	  System.out.println(tabs2.get(1));
	    
		driver.switchTo().frame("portal") ;
		WebElement menu = driver.findElement(By.id("gnxMenuLayer@mainMenu@Item/GFP0006")) ;
		Actions act = new Actions(driver) ;
		act.moveToElement(menu).build().perform();
	 driver.findElement(By.xpath(".//*[@id='gnxMenuLayer@mainMenu@GFP0006@Item/I_AREA_F']")).click();
	 System.out.println("Successfully opened Supplier Return" );
	 driver.switchTo().frame("iframe-container_I_AREA_F") ;
	 driver.switchTo().frame("recherche_AREAC") ;
		
	 Select supp = new Select(driver.findElement(By.name("chp:Typact")));
		supp.selectByVisibleText("Central buying");
		
		 driver.findElement(By.xpath(".//*[@id='chp:Sigtie']")).sendKeys("DIRINTEG");
			driver.findElement(By.xpath(".//*[@id='but_create']")).click();
		
			
	
	}




 

	@Then("^Supplier return should be created$")
	public void supplier_return_should_be_created() throws Throwable {

		ArrayList<String> tabs6 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs6.get(2));
	    
	    System.out.println(tabs6.get(2));
		 System.out.println("Successfully created Supplier Return"  );
	     Thread.sleep(6000);
	//	 driver.switchTo().frame("listeentete") ;
//		 driver.switchTo().frame("entete") ;
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	//	String sno = driver.findElement(By.xpath(".//*[@id='Evenement']/table[1]/tbody/tr[1]/td/span[1]")).getText();
	//	 System.out.println(sno );
		 driver.quit();
	    
	}
  
 

}
