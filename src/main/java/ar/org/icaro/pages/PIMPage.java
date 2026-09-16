package ar.org.icaro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage {

        // Locators (Adjust selectors based on OrangeHRM's actual DOM structure)
        private By employeeNameBox = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input");
        private By searchButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
        private By employeeRecordTable = By.xpath("//div[@class='oxd-table-card']");
        private By noRecordsMessage = By.xpath("//span[text()='No Records Found']");
        private By pimModuleHeader = By.xpath("//h6[text()='PIM']");

        // Constructor inheriting the driver
        public PIMPage(WebDriver driver) {
            super(driver);
        }

        // 1. Search functionality
        public void searchEmployeeByName(String employeeName) {
            type(employeeNameBox, employeeName);
            click(searchButton);
        }

        // 2. Results verification methods
        public boolean hasResults() {
            return isElementVisible(employeeRecordTable);
        }

        // 3. Page verification
        public boolean isOnPIMPage() {
            return isElementVisible(pimModuleHeader);
        }

        // 4. Negative Scenario verification (Non-static)
        public boolean isNoRecordsDisplayed() {
            return isElementVisible(noRecordsMessage);
        }
    }


