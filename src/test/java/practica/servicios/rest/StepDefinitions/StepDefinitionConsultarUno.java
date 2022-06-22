package practica.servicios.rest.StepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matchers;
import practica.servicios.rest.model.ConsultatEmpleadoModel;
import practica.servicios.rest.task.ConsultarEmpleadoUnico;

import java.util.List;

public class StepDefinitionConsultarUno {

    //Get1
    @When("^consultar usuario con id (.*)$")
    public void consultarUsuarioCoId(String id) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ConsultarEmpleadoUnico.forId(id)
        );
    }

    @Then("^Deberia ver la insofrmacion del usuario$")
    public void deberiaVerLaInsofrmacionDelUsuario(List<ConsultatEmpleadoModel> empleado) {

        OnStage.theActorInTheSpotlight().should(
                ResponseConsequence.seeThatResponse("response employee_name", response ->response
                        .body("data.employee_name", Matchers.equalTo(empleado.get(0).getEmployee_name())))
        );

    }
}
