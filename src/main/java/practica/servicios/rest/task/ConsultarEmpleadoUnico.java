package practica.servicios.rest.task;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultarEmpleadoUnico implements Task {
 public String numero;

    public ConsultarEmpleadoUnico(String num) {
        this.numero=num;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                //Get.resource("/employee/"+numero)
                Get.resource("/employee/{id}").with(req->req
                    .header("Content-Type","application/json")
                    .pathParam("id", numero)

                )
        );
        SerenityRest.lastResponse().prettyPrint();



    }

    public static ConsultarEmpleadoUnico forId(String numero) {
        return new ConsultarEmpleadoUnico(numero);
    }
}
