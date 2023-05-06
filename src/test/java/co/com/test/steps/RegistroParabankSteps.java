package co.com.test.steps;

import co.com.test.models.RegistroModel;
import co.com.test.pageobjects.RegistroParabankPage;
import net.thucydides.core.annotations.Step;


public class RegistroParabankSteps {
    RegistroParabankPage registroParabankPage;

    @Step
    public void abrirPagina() {
        registroParabankPage.open();
    }

    @Step
    public void registrarNuevoUsuario(RegistroModel registroModel){
        registroParabankPage.ingresarRegistro(registroModel);
    }

    @Step
    public void validarRegistro(String usuario) throws InterruptedException {
        registroParabankPage.validarRegistro(usuario);
    }

    @Step
    public void cerrarSesion() throws InterruptedException {
        registroParabankPage.cerrarSesion();
    }

    @Step
    public void validarErrorRegistro(String mensaje) {
        registroParabankPage.validarErrorRegistro(mensaje);
    }
}
