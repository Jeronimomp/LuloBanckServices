package practica.servicios.rest.SetUp;

import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static practica.servicios.rest.utils.Constantes.BASE_URL2;
import static practica.servicios.rest.utils.Constantes.EL_ACTOR;

public class Principal {

    @Before
    public void congig(){
        OnStage.setTheStage(new OnlineCast()) ;
        OnStage.theActorCalled(EL_ACTOR);
        OnStage.theActorInTheSpotlight().can(CallAnApi.at(BASE_URL2));
    }
}
