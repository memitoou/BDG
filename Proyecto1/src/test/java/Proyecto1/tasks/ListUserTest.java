package Proyecto1.tasks;

import net.serenitybdd.screenplay.actors.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import org.junit.jupiter.api.Test;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ListUserTest {
    
    @Test
    public void testListUserTask() {
        // Setup the actor
        Actor user = Actor.named("User");
        OnStage.setTheStage(new net.serenitybdd.screenplay.Stage(user));

        // Assuming you have a defined endpoint
        String endpoint = "/api/users"; // Replace with your actual endpoint
        
        // Create the task
        ListUser listUserTask = ListUser.from(endpoint);

        // Perform the task
        user.attemptsTo(listUserTask);

        // Add an assertion based on what you expect
        user.should(seeThatResponse("The response contains expected users", response -> 
            response.statusCode(200))); // Adjust based on expected response
    }
}

