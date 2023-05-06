package co.com.test.definitions;

import co.com.test.models.RegistroModel;
import co.com.test.steps.RegistroParabankSteps;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class RegistroParaBankDefinition {
    @Steps
    RegistroParabankSteps registroParabankSteps;

    @Dado("^se necesita registrar un nuevo usuario$")
    public void seNecesitaRegistrarUnNuevoUsuario() {
        registroParabankSteps.abrirPagina();
    }

    @Cuando("^se ingresan todos los datos del usuario$")
    public void seIngresanTodosLosDatosDelUsuario(List<RegistroModel> registroModel) {
        registroParabankSteps.registrarNuevoUsuario(registroModel.get(0));
    }

    @Entonces("^se valida la bienvenida al usuario (.*)$")
    public void seValidaElRegistroCorrectamente(String usuario) throws InterruptedException {
        registroParabankSteps.validarRegistro(usuario);
    }

    @Dado("^el usario (.*) se registra en la plataforma de parabank$")
    public void elUsarioSeRegistraEnLaPlataformaDeParabank(String usuario, List<RegistroModel> registroModel) throws InterruptedException {
        registroParabankSteps.abrirPagina();
        registroParabankSteps.registrarNuevoUsuario(registroModel.get(0));
        registroParabankSteps.validarRegistro(registroModel.get(0).getUser());
        registroParabankSteps.cerrarSesion();
    }

    @Cuando("^se intenta realizar nuevamente el registro del usario jeferson$")
    public void seIntentaRealizarNuevamenteElRegistroDelUsarioJeferson(List<RegistroModel> registroModel) {
        registroParabankSteps.registrarNuevoUsuario(registroModel.get(0));
    }

    @Entonces("^se valida el error '(.*)' en el nuevo registro$")
    public void seValidaElErrorThisUsernameAlreadyExistsEnElNuevoRegistro(String mensaje) {
        registroParabankSteps.validarErrorRegistro(mensaje);
    }
}
