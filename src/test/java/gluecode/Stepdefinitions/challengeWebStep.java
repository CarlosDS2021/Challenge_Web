package gluecode.Stepdefinitions;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Base;



public class challengeWebStep extends Base {

    By btnSignUp = By.id("signin2");
    By sign_username = By.id("sign-username");
    By sign_password = By.id("sign-password");
    By btnRegistro = By.xpath("/html/body/div[2]/div/div/div[3]/button[2]");


    By btnLogin = By.id("login2");
    By login_username = By.id("loginusername");
    By login_password = By.id("loginpassword");
    By btnIngresar = By.xpath("/html/body/div[3]/div/div/div[3]/button[2]");

    By btnLogout = By.id("logout2");

    By btnAgregarCarrito = By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a");

    By btnCarrito = By.id("cartur");

    By txtTotalPago = By.xpath("/html/body/div[6]/div/div[2]/div/div/h3");

    String TotalPagar;

    public challengeWebStep(WebDriver driver){//, Robot robo) {
        super(driver);//, robo);
        // TODO Auto-generated constructor stub
    }


    public void SeleccionarSingUp() throws InterruptedException {
        Thread.sleep(2000);
        click(btnSignUp);
        Esperar(1);

    }

    public void IngresarDatos(String nombre, String contrasenia) throws InterruptedException {
        Thread.sleep(2000);
        click(sign_username);
        write(sign_username,nombre);
        Esperar(1);
        click(sign_password);
        write(sign_password,contrasenia);
        Esperar(4);
    }

    public void GuardarUsuario() throws InterruptedException {
        Thread.sleep(2000);
        click(btnRegistro);
        Esperar(10);
    }

    public void validaAlta() throws InterruptedException {
        Thread.sleep(2000);
        int parametro = 1;
        for (int i = 0; parametro > i; i++) {
            String Message = alertacept();
            System.out.println("" + Message);
            if (Message.contains("Sign up successful.")) {
                Thread.sleep(2000);
                driver.close();
            } else if (Message.contains("This user already exist.")) {
                driver.close();
            } else {
                parametro = parametro + 1;
                Thread.sleep(2000);
            }
        }
    }


    public void SeleccionarLogin() throws InterruptedException {
        Thread.sleep(2000);
        click(btnLogin);
        Esperar(1);
    }


    public void IngresarDatosLogin(String usuario, String contrasenia) throws InterruptedException {
        Thread.sleep(2000);
        click(login_username);
        write(login_username,usuario);
        Esperar(1);
        click(login_password);
        write(login_password,contrasenia);
        Esperar(4);
    }

    public void SeleccionarBtnLogin() throws InterruptedException {
        Thread.sleep(2000);
        click(btnIngresar);
        Esperar(10);
    }

    public void SeleccionarBtnLogout() throws InterruptedException {
        Thread.sleep(5000);
        click(btnLogout);
        Esperar(5);
        driver.close();
    }

    public void Categoria(String categoria) throws InterruptedException {
        Thread.sleep(2000);
        By categorias = By.linkText(categoria);
        click(categorias);
        Esperar(15);
    }

    public void Modelo(String modelo) throws InterruptedException {
        Thread.sleep(2000);
        By modelos = By.linkText(modelo);
        click(modelos);
        Esperar(15);
    }

    public void AgregarCarrito() throws InterruptedException {
        Thread.sleep(2000);
        click(btnAgregarCarrito);
        btnacept();

        }

    public void IrACarrito() throws InterruptedException {
        Thread.sleep(5000);
        click(btnCarrito);
        Thread.sleep(8000);
        TotalPagar = getText(txtTotalPago);
        Assert.assertEquals("1100", TotalPagar);

        driver.close();

    }

}