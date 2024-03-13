package stepdefs;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
	 
	@RunWith(Cucumber.class)
	@CucumberOptions(features = "src/test/java/features/WebTable2.feature",glue = "stepdefs")
	public class TestRunner {
	 
	}

