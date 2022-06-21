package practica.servicios.rest.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/RestFeature.feature",
                 glue="practica.servicios.rest.StepDefinitions",
                 snippets= SnippetType.CAMELCASE ,tags="@Delete"
                 )

public class RunnerServices {

}
