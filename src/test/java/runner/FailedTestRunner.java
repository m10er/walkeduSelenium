package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "@target/failed_scenarios.txt",
    glue = {"com.bison.steps", "com.bison.hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/failed/cucumber-pretty.html",
        "json:target/cucumber-reports/failed/cucumber.json"
    },
    monochrome = true
)
public class FailedTestRunner {
} 