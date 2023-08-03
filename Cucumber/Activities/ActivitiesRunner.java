package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        dryRun = false,
        monochrome = true,
        stepNotifications = true,

        plugin = {
                "pretty",
                "html:src/reports/HTML_REPORT.html"
        },
        publish = false
)

public class ActivitiesRunner {
    //empty
}