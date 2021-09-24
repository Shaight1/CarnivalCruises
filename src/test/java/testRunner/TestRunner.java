package testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * This a Runner class and settled down the configuration for cucumber as the implementation of the ExtentReport
 *
 * @author Alvaro Ariza
 */
//@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/functionalTestsFeatures/",
        glue = "stepDefinitions", tags = {"@EXECUTE"},
        plugin = { "json:target/cucumber-report.json"},
        snippets = SnippetType.CAMELCASE
)

@Test
public class TestRunner extends AbstractTestNGCucumberTests {
    static public String browser = "";

    @Parameters("browser")
    @BeforeClass
    public void setBrowser(String browserName) {
        browser = browserName;
    }
}


