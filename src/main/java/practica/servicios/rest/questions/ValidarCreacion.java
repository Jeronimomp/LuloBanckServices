package practica.servicios.rest.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ValidarCreacion implements Question {


    @Override
    public Object answeredBy(Actor actor) {

        Integer status=  SerenityRest.lastResponse().statusCode();

        return status;
    }

    public static ValidarCreacion empleados(){
        return new ValidarCreacion();
    }
}
