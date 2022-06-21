package practica.servicios.rest.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;



public class ValidarEmpleadoUnico implements Question <Integer>{

    int STATUS_CODE=200;

    @Override
    public Integer answeredBy(Actor actor) {

        return STATUS_CODE;

    }

    public static ValidarEmpleadoUnico porNombre(){
        return new ValidarEmpleadoUnico();
    }
}
