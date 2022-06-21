package practica.servicios.rest.task;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class EliminarEmpleado implements Task {
private int id;

    public EliminarEmpleado(int id) {

        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
actor.attemptsTo(
        Delete.from("/delete/{id}").with( rq ->rq
                .header("Content-Type","application/json")
                .pathParam("id",id)
        )
);
        SerenityRest.lastResponse().prettyPrint();
    }

    public static Performable forId(int id) {
      return new EliminarEmpleado(id);
    }
}
