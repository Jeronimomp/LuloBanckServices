package practica.servicios.rest.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ValidarEmpleadoEliminado implements Question {
    @Override
    public Object answeredBy(Actor actor) {

        String mensajeResponse= SerenityRest.lastResponse().then().extract().body().asString();
       String mensaje= from(mensajeResponse).get("message");
        System.out.println(mensaje);
        return mensaje;
    }

    public static ValidarEmpleadoEliminado porMensaje(){
        return new ValidarEmpleadoEliminado();
    }
}
