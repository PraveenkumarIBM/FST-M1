package runner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        dryRun = false,
        tags = "@activity7",
        monochrome = true,
        stepNotifications = true,

        plugin = {
                "pretty",
                "html:src/reports/HTML_REPORT.html"
        },
        publish = false
)

public class Activity7Runner {
}
