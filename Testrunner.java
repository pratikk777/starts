package gceone.gceone;




import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\pk\\workspace\\gceone\\src\\main\\java\\gceone\\gceone\\R_supplier.feature"}
		,glue={"gceone.gceone"}
		)
 
public class Testrunner {
 
}