package ar.org.icaro;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = {
                "src/main/resources/flujo_completo.feature",
                "src/main/resources/negative_testing.feature"
        },
        glue = "ar.org.icaro",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // This class remains empty; the annotations do all the heavy lifting
}