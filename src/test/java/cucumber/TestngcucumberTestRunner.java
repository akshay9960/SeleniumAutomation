package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/cucumber",               
    glue = "SeleniumFrameworkDesign.stepDefination",        
    monochrome = true,
    plugin = {"pretty", "html:target/cucumber.html"}         
)
public class TestngcucumberTestRunner extends AbstractTestNGCucumberTests {}
