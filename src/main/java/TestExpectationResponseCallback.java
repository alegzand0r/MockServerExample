import org.mockserver.mock.action.ExpectationResponseCallback;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.HttpStatusCode;
import static org.mockserver.model.HttpResponse.notFoundResponse;
import static org.mockserver.model.HttpResponse.response;

public class TestExpectationResponseCallback implements ExpectationResponseCallback {
    @Override
    public HttpResponse handle(HttpRequest httpRequest) {
        if (httpRequest.getPath().getValue().equals("/hello")) {
            return response()
                    .withStatusCode(HttpStatusCode.OK_200.code())
                    .withBody("Hello, " + httpRequest.getBody().getValue().toString() + "!");
        }
        else if (httpRequest.getPath().getValue().equals("/goodbye")) {
            return response()
                    .withStatusCode(HttpStatusCode.OK_200.code())
                    .withBody("Good bye, " + httpRequest.getBody().getValue().toString() + "!");
        }
        else
            return notFoundResponse();
    }
}