package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/ui",
        glue = {"ui.stepdefinitions"},
        plugin = {"pretty", "html:target/web-report.html"},
        tags = "@web"
)
public class WebTestRunner {}