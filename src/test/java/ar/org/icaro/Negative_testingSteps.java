package ar.org.icaro;
import ar.org.icaro.pages.LoginPage;
import ar.org.icaro.pages.DashboardPage;
import ar.org.icaro.pages.PIMPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class Negative_testingSteps {

        private LoginPage loginPage = new LoginPage(Hooks.getDriver());
        private DashboardPage dashboardPage = new DashboardPage(Hooks.getDriver());
        private PIMPage pimPage = new PIMPage(Hooks.getDriver());

        @Given("que el usuario navega a la página de login")
         public void que_el_usuario_navega_a_la_pag_de_login() {
        loginPage.goTo();
        }
        @When("ingresa credenciales inválidas")
        public void ingresa_credenciales_invalidas() {
            loginPage.loginAs("Admin", "wrongPassword123");
        }
        @Then("debería ver un mensaje de error de credenciales inválidas")
        public void deberia_ver_un_mensaje_de_error_de_credenciales_invalidas() {
        String actualError = loginPage.getErrorMessageText();
        Assert.assertEquals(
                actualError,
                "Invalid credentials",
                "El mensaje de error de credenciales inválidas no coincide o no apareció."
        );
    }

        // Scenario 2 PIMPage

        @Then("debería ver el mensaje de que no hay registros")
        public void debería_ver_el_mensaje_de_que_no_hay_registros() {
                Assert.assertTrue(
                        pimPage.isNoRecordsDisplayed(),
                        "Se esperaba el mensaje 'No Records Found', pero no apareció."
                );
        }
}

