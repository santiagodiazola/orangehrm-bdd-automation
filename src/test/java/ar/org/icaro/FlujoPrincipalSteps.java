package ar.org.icaro;

import ar.org.icaro.pages.DashboardPage;
import ar.org.icaro.pages.LoginPage;
import ar.org.icaro.pages.PIMPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FlujoPrincipalSteps {

        private LoginPage loginPage = new LoginPage(Hooks.getDriver());
        private DashboardPage dashboardPage = new DashboardPage(Hooks.getDriver());
        private PIMPage pimPage = new PIMPage(Hooks.getDriver());

        // First scenario: Login successfully
        @Given("que el usuario navega a la página de login de OrangeHRM")
        public void que_el_usuario_navega_a_la_pagina_de_login() {
            loginPage.goTo();
        }
        @When("ingresa las credenciales válidas")
        public void ingresa_las_credenciales_validas() {
            loginPage.loginAs("Admin", "admin123");
        }

         @Then("el usuario debería ver el Dashboard")
        public void el_usuario_deberia_ver_el_dashboard() {

        // --- Layer 1: Verify element visibility via Page Object ---
        Assert.assertTrue(
                dashboardPage.isOnDashboard(),
                "El usuario no se encuentra en el Dashboard (el elemento no es visible)."
        );
        // --- Layer 2: Verify exact header text ---
        String actualHeader = dashboardPage.getHeaderText();
        Assert.assertEquals(
                actualHeader,
                "Dashboard",
                "El título del encabezado no coincide con lo esperado."
        );
    }

        // Second scenario: Finding an employee
        @Given("que el usuario ha iniciado sesión exitosamente")
        public void que_el_usuario_ha_iniciado_sesion_exitosamente() {
            que_el_usuario_navega_a_la_pagina_de_login();
            ingresa_las_credenciales_validas();
            el_usuario_deberia_ver_el_dashboard();
        }
        @When("navega al módulo PIM y busca al empleado {string}")
        public void navega_al_modulo_pim_y_busca_al_empleado(String employeeName) {
            dashboardPage.goToPIM();
            pimPage.searchEmployeeByName(employeeName);
        }
        @Then("el registro del empleado debería aparecer en los resultados")
        public void el_registro_del_empleado_deberia_aparecer_en_los_resultados() {
            Assert.assertTrue(pimPage.hasResults(), "No se encontraron los resultados del empleado");

        }

        // Third scenario: Logout
        @When("hace clic en logout")
        public void hace_clic_en_logout() {
            dashboardPage.logout();
        }

        @Then("el usuario debería regresar a la página de login")
        public void el_usuario_deberia_regresar_a_la_pagina_de_login() {
            Assert.assertTrue(loginPage.isOnLoginPage(), "El usuario no regresó a la página de login");
        }
    }

