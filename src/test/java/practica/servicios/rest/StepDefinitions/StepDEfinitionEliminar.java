package practica.servicios.rest.StepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import practica.servicios.rest.questions.ValidarEmpleadoEliminado;
import practica.servicios.rest.task.EliminarEmpleado;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;


public class StepDEfinitionEliminar {

    //Delete
    @When("^se busca el empleado a eliminar por id (\\d+)$")
    public void seBuscaElEmpleadoAEliminarPorId(int idEliminar) {
        OnStage.theActorInTheSpotlight().attemptsTo(EliminarEmpleado.forId(idEliminar));
    }

    @Then("^se observa el mensaje de eliminación (.*)$")
    public void seObservaElMensajeDeEliminación(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidarEmpleadoEliminado.porMensaje(mensajeEsperado),equalTo(true)));
    }
}
