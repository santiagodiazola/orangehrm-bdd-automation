package ar.org.icaro.tests.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test

@CucumberOptions(
        features = {
                "src/test/resources/features/flujo_completo.feature",
                "src/test/resources/features/negative_testing.feature"
        },
        glue = "ar.org.icaro",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "json:target/cucumber.json"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // This class remains empty; the annotations do all the heavy lifting
}