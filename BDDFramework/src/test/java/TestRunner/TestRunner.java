package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@End-To-End", features = { "src/test/resources/Features" }, glue = {
		"POMStepDefinitions" }, plugin = { "pretty", "html:target/htmlreport.html" }, monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

}
