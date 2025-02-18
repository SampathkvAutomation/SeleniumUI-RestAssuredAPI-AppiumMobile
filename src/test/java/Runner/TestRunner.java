package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(

        features = "src/test/resources/features",
        glue ="stepdefinitions",
        plugin = {                                 // Reports and Console Output
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
