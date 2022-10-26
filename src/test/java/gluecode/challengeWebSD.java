package gluecode;

import gluecode.Stepdefinitions.challengeWebStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class challengeWebSD {
    public static WebDriver driver;

    challengeWebStep challengeWebStep = new challengeWebStep(driver);

    @Given("que ingresamos a la web de Product Store")
    public void queIngresamosALaWebDeProductStore() throws InterruptedException {
        driver = challengeWebStep.IEDriverConnection();

        challengeWebStep.visit("https://www.demoblaze.com/index.html");
        Thread.sleep(2000);
        driver.manage().window().maximize();
    }

    @When("seleccionamos la opcion del menu Sing up")
    public void seleccionamosLaOpcionDelMenuSingUp() throws InterruptedException {
        challengeWebStep.SeleccionarSingUp();
    }

    @And("ingresamos el {string} y la {string}")
    public void ingresamosElYLa(String nombre, String contrasenia) throws InterruptedException {
        challengeWebStep.IngresarDatos(nombre,contrasenia);
    }

    @And("presionamos el boton Sign up")
    public void presionamosElBotonSignUp() throws InterruptedException {
        challengeWebStep.GuardarUsuario();
    }

    @Then("se da de alta el usuario con exito")
    public void seDaDeAltaElUsuarioConExito() throws InterruptedException {
        challengeWebStep.validaAlta();
    }

    @When("seleccionamos la opcion del menu Login")
    public void seleccionamosLaOpcionDelMenuLogin() throws InterruptedException {
        challengeWebStep.SeleccionarLogin();
    }

    @And("ingresamos nuestro {string} y {string}")
    public void ingresamosNuestroY(String usuario, String contrasenia) throws InterruptedException {
        challengeWebStep.IngresarDatosLogin(usuario,contrasenia);
    }

    @And("presionamos el boton Login")
    public void presionamosElBotonLogin() throws InterruptedException {
        challengeWebStep.SeleccionarBtnLogin();
    }

    @Then("presionar el boton Logout")
    public void presionarElBotonLogout() throws InterruptedException {
        challengeWebStep.SeleccionarBtnLogout();
    }

    @And("nos dirigimos a la {string}")
    public void nosDirigimosALaCategoria(String categoria) throws InterruptedException {
        challengeWebStep.Categoria(categoria);
    }

    @And("seleccionamos el {string}")
    public void seleccionamosEl(String modelo) throws InterruptedException {
        challengeWebStep.Modelo(modelo);
    }

    @And("agregamos al carrito")
    public void agregamosAlCarrito() throws InterruptedException {
        challengeWebStep.AgregarCarrito();
    }

    @Then("comprobamos que se haya agregado al carrito")
    public void comprobamosQueSeHayaAgregadoAlCarrito() throws InterruptedException {
        challengeWebStep.IrACarrito();
    }

}
