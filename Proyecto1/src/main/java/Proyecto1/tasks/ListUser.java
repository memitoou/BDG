package Proyecto1.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.Actor;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ListUser implements Task {
    
    private final String endpoint;

    public ListUser(String endpoint) {
        this.endpoint = endpoint;
    }

    public static ListUser from(String endpoint) {
        return instrumented(ListUser.class, endpoint);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Get.resource(endpoint)
        );
    }
}

