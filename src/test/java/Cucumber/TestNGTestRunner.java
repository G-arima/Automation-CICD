package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//Cucumber--->testNg,JUnit
@CucumberOptions(features="src/test/java/Cucumber",glue="rahulshettyacademy.stepDefinitions",monochrome=true,plugin={"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
