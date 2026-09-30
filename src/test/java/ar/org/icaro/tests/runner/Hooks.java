package ar.org.icaro.tests.runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        // Automatically setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Configure Chrome Options for local and CI/CD execution
        ChromeOptions options = new ChromeOptions();

        // Check if running in GitHub Actions or any CI environment
        String ciEnv = System.getenv("CI");
        if (ciEnv != null && ciEnv.equals("true")) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        driver = new ChromeDriver(options);

        // Maximize window only if running locally with a graphical interface
        if (ciEnv == null) {
            driver.manage().window().maximize();
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        // Capture screenshot if the test fails
        if (scenario.isFailed() && driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }

        // Safely close the browser after the test scenario finishes
        if (driver != null) {
            driver.quit();
        }
    }

    // A getter so your Step Definitions can access the shared driver instance
    public static WebDriver getDriver() {
        return driver;
    }
}