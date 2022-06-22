package practica.servicios.rest.StepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import practica.servicios.rest.model.CrearEmpleadoModel;
import practica.servicios.rest.questions.ValidarCreacion;
import practica.servicios.rest.task.CrearEmpleado;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class StepDefinitionsCrear {

    //Post
    @When("^se crea un empleado por medio del servicio$")
    public void seCreaUnEmpleadoPorMedioDelServicio(List<CrearEmpleadoModel> datosEmpleado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CrearEmpleado.conSusDatos(datosEmpleado));
    }

    @Then("^se ve el usurio creado con codigo de exito (.*)$")
    public void seVeElUsurioCreadoConCodigoDeExito(int codigoEstado) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidarCreacion.empleados(), Matchers.equalTo(codigoEstado)));

    }
}
