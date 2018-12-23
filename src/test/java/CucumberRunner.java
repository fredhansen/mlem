import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/html/"},
        features = {"src/test/java/cucumber/features"}
)
public class CucumberRunner {
}
