package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        tags = "@activity4",

        plugin = {
                "pretty",
                "html: test-reports/TestReport.html",
                "json: test-reports/TestReport.json"
        },


        publish = false,
        monochrome = true
)

public class Activity4Runner {
}
