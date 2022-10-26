package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * @author Carlos Durand Silva
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = {"gluecode"},
        strict = true,
        tags = "@ChallengeWeb"
)
public class TestRunner {

}
