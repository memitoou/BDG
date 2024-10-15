package Proyecto1.steps;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

public class ReqResSteps {

    private Actor actor;

    // Métodos para inicializar y validar los endpoints

    public void verifyResponse() {
        actor.should(
            seeThatResponse("La respuesta contiene los usuarios esperados",
                response -> response.statusCode(200)
                                    .body("data", not(empty()))
            )
        );
    }
}

