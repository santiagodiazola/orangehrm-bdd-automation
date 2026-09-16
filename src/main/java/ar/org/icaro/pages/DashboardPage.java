package ar.org.icaro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

        // Locators
        private By pimModuleLink = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span");
        private By userDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p");
        private By logoutButton = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a");
        private By dashboardTitle = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6");


        // Constructor
        public DashboardPage(WebDriver driver){
        super(driver);
        }

        // 1. Navigation to PIM module
        public void goToPIM() {
        click(pimModuleLink);
        }

        // 2. Logout functionality
        public void logout() {
        click(userDropdown);
        click(logoutButton);
        }

         // 3. Verification methods
         public boolean isOnDashboard() {
                 waitForUrlContains("/dashboard/index");
                 return isElementVisible(dashboardTitle);
        }
        // 2. Grabs the actual text inside the header (returns String)
        public String getHeaderText() {
                return getText(dashboardTitle);
        }
}
