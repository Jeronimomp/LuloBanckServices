package practica.servicios.rest.StepDefinitions;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import practica.servicios.rest.questions.ValidarTodos;
import practica.servicios.rest.task.*;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class StepDefinitionConsultarTodos {

    //Get2
    @When("^se consulta el servicio web de todos los empleados$")
    public void seConsultaElServicioWebDeTodosLosEmpleados() {
     OnStage.theActorInTheSpotlight().attemptsTo(
             ConsultarTodos.losEmpleados()
     );
    }

    @Then("^se ve un mensaje de exito: (.*)$")
    public void seVeUnCodigoDeEstadoDeExito(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidarTodos.losEmpleados(mensajeEsperado),equalTo(true))
        );

    }

}
