package practica.servicios.rest.task;


import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import practica.servicios.rest.model.CrearEmpleadoModel;
import practica.servicios.rest.questions.ValidarCreacion;

import java.util.List;

public class CrearEmpleado implements Task {

    List<CrearEmpleadoModel> datosEmpleado;

    public CrearEmpleado(List<CrearEmpleadoModel> datosEmpleado) {
        this.datosEmpleado = datosEmpleado;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Post.to("/create").with(rq -> rq
                .header("Content-Type", "application/json")
                .body(datosEmpleado.get(0)).log().all())
        );


        SerenityRest.lastResponse().prettyPrint();
    }


    public static CrearEmpleado conSusDatos(List<CrearEmpleadoModel> datosEmpleado){
        return new CrearEmpleado(datosEmpleado);
    }


}
