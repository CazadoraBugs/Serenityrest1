import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SerenityRunner.class)
public class Serenitytest {
  // private  static final String restApiUrl="http://localhost:5000/api";
   private  static final String restApiUrl="https://reqres.in/";
    @Test
    public void getUsers(){
        Actor julian= Actor.named("Fiorella the trainer")
                .whoCan(CallAnApi.at(restApiUrl));

        julian.attemptsTo(Get.resource("api/users?page=2"));
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);

    }

    @Test
    public void getUsersFailed(){
        Actor julian= Actor.named("Fiorella the trainer")
                .whoCan(CallAnApi.at(restApiUrl));

        julian.attemptsTo(Get.resource("api/users?page=2"));
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(400);

    }
}
