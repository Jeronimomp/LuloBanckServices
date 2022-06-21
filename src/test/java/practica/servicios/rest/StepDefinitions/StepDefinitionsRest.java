package practica.servicios.rest.StepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matchers;
import practica.servicios.rest.model.CrearEmpleadoModel;
import practica.servicios.rest.model.ConsultatEmpleadoModel;
import practica.servicios.rest.questions.ValidarCreacion;
import practica.servicios.rest.questions.ValidarEmpleadoEliminado;
import practica.servicios.rest.questions.ValidarTodos;
import practica.servicios.rest.task.*;
import practica.servicios.rest.utils.Constantes;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class StepDefinitionsRest {
    Constantes constantes;
  @Before
  public void congig(){
      OnStage.setTheStage(new OnlineCast()) ;
      OnStage.theActorCalled( "El men");
      OnStage.theActorInTheSpotlight().can(CallAnApi.at(constantes.BASE_URL2));


  }
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

    //Post
    @When("^se crea un empleado por medio del servicio$")
    public void seCreaUnEmpleadoPorMedioDelServicio(List<CrearEmpleadoModel> datosEmpleado) {
    OnStage.theActorInTheSpotlight().attemptsTo(
    CrearEmpleado.conSusDatos(datosEmpleado));
    }

    @Then("^se ve el usurio creado con codigo de exito (.*)$")
    public void seVeElUsurioCreadoConCodigoDeExito(int codigoEstado) {
     OnStage.theActorInTheSpotlight().should(seeThat(ValidarCreacion.empleados(),Matchers.equalTo(codigoEstado)));

    }


    //Delete
    @When("^se busca el empleado a eliminar por id (\\d+)$")
    public void seBuscaElEmpleadoAEliminarPorId(int idEliminar) {
    OnStage.theActorInTheSpotlight().attemptsTo(EliminarEmpleado.forId(idEliminar));
    }

    @Then("^se observa el mensaje de eliminación \"([^\"]*)\"$")
    public void seObservaElMensajeDeEliminación(String mensajeEsperado) {
   OnStage.theActorInTheSpotlight().should(seeThat(ValidarEmpleadoEliminado.porMensaje(),Matchers.equalTo(mensajeEsperado)));
    }



}
