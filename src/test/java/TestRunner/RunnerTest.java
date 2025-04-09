package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)


@CucumberOptions(
		
		features= {"AllFeaturesFile"},
		glue= {"Steps"},
		dryRun=false,
		monochrome=true,
		plugin= {
				
	"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"		
				
				
		}
		
		
		
		)
public class RunnerTest {

}
