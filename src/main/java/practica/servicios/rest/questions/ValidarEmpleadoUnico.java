package practica.servicios.rest.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.rest.SerenityRest.lastResponse;


public class ValidarEmpleadoUnico implements Question <Boolean>{

    private  int code;

    public ValidarEmpleadoUnico(int code) {
        this.code = code;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return lastResponse().statusCode()==code;

    }

    public static ValidarEmpleadoUnico porCodigoEstado(int code){
        return new ValidarEmpleadoUnico(code);
    }
}
