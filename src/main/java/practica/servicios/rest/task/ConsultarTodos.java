package practica.servicios.rest.task;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultarTodos implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/employees").with(req->req
                        .header("Content-Type","application/json")
                )
        );
        SerenityRest.lastResponse().prettyPrint();
    }

    public static ConsultarTodos losEmpleados(){
        return new ConsultarTodos();
    }
}
