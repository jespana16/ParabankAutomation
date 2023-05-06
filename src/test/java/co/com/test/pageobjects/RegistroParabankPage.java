package co.com.test.pageobjects;

import co.com.test.models.RegistroModel;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.seleniumhq.jetty9.util.log.Log;
import org.slf4j.Logger;

@DefaultUrl("https://parabank.parasoft.com/parabank/index.htm")
public class RegistroParabankPage extends PageObject {

    @FindBy (xpath = "/html/body/div[1]/div[3]/div[1]/div/p[2]/a")
    WebElementFacade btnRegistro;

    @FindBy (id = "customer.firstName")
    WebElementFacade txtFirsName;

    @FindBy (id = "customer.lastName")
    WebElementFacade txtLastname;

    @FindBy (id = "customer.address.street")
    WebElementFacade txtaddress;

    @FindBy (id = "customer.address.city")
    WebElementFacade txtCity;

    @FindBy (id = "customer.address.state")
    WebElementFacade txtState;

    @FindBy (id = "customer.address.zipCode")
    WebElementFacade txtZipCode;

    @FindBy (id = "customer.phoneNumber")
    WebElementFacade txtPhone;

    @FindBy (id = "customer.ssn")
    WebElementFacade txtSSN;

    @FindBy (id = "customer.username")
    WebElementFacade txtUser;

    @FindBy (id = "customer.password")
    WebElementFacade txtPassword;

    @FindBy (id = "repeatedPassword")
    WebElementFacade txtConfirm;

    @FindBy (xpath = "/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[13]/td[2]/input")
    WebElementFacade btnregistrar;

    @FindBy (xpath = "//*[@id=\"rightPanel\"]/h1")
    WebElementFacade txtBienvenida;

    @FindBy (xpath = "/html/body/div[1]/div[3]/div[1]/ul/li[8]/a")
    WebElementFacade linkLogout;

    @FindBy (id = "customer.username.errors")
    WebElementFacade txtErrorRegistro;


    int wait = 1000;

    public void ingresarRegistro(RegistroModel registroModel) {
        btnRegistro.click();

        txtFirsName.sendKeys(registroModel.getFirsname());
        txtLastname.sendKeys(registroModel.getLastname());
        txtaddress.sendKeys(registroModel.getAddress());
        txtCity.sendKeys(registroModel.getCity());
        txtState.sendKeys(registroModel.getState());
        txtZipCode.sendKeys(registroModel.getZipcode());
        txtPhone.sendKeys(registroModel.getPhone());
        txtSSN.sendKeys(registroModel.getSsn());
        txtUser.sendKeys(registroModel.getUser());
        txtPassword.sendKeys(registroModel.getPass());
        txtConfirm.sendKeys(registroModel.getConfir());
        btnregistrar.click();
    }

    public void validarRegistro(String usuario) throws InterruptedException {
        Thread.sleep(wait);
        Serenity.takeScreenshot();
        Serenity.recordReportData().withTitle("Mensaje ingreso").andContents(txtBienvenida.getText());
        Assert.assertTrue(txtBienvenida.getText(), txtBienvenida.getText().contains(usuario));
    }

    public void cerrarSesion() throws InterruptedException {
        Thread.sleep(wait);
        linkLogout.click();
    }

    public void validarErrorRegistro(String mensaje){
        Assert.assertTrue(txtErrorRegistro.getText(), txtErrorRegistro.getText().contains(mensaje));
    }
}
