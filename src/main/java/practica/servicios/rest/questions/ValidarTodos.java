package practica.servicios.rest.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.path.json.JsonPath.from;

public class ValidarTodos implements Question <Boolean> {
    String mensajeEsperado;

    public ValidarTodos(String mensajeRspuesta) {
        this.mensajeEsperado = mensajeRspuesta;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String mensajeResponse= SerenityRest.lastResponse().then().extract().body().asString();
        assertThat(from(mensajeResponse).get("message"),equalTo(mensajeEsperado));

        return true;

            }

    public static ValidarTodos losEmpleados(String mensajeRspuesta){
        return new ValidarTodos(mensajeRspuesta);
    }
}
