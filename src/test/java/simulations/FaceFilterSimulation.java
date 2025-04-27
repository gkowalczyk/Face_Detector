package simulations;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
public class FaceFilterSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8081")
            .acceptHeader("application/json")
            .contentTypeHeader("application/json");

    String jsonBody = """
        {
          "ageMin": 20.0,
          "ageMax": 30.0
        }
        """;

    ScenarioBuilder scn = scenario("Filter FaceObjects by Age")
            .exec(
                    http("POST /api/face/filter")
                            .post("/api/face/filter")
                            .body(StringBody(jsonBody)).asJson()
                            .check(status().is(200))
            );
    {
        setUp(
                scn.injectOpen(atOnceUsers(1000))
        ).protocols(httpProtocol);
    }
}
