package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.bison.steps", "com.bison.hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/smoke/cucumber-pretty.html",
        "json:target/cucumber-reports/smoke/cucumber.json"
    },
    tags = "@smoke",
    monochrome = true
)
public class SmokeTestRunner {
} 