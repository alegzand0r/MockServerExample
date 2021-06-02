import org.mockserver.integration.ClientAndServer;
import static org.mockserver.model.HttpClassCallback.callback;
import static org.mockserver.model.HttpRequest.request;

public class TestMock {
    public static void main(String[] args) {
        ClientAndServer mockServer = new ClientAndServer(8888);
        mockServer.when(request()).respond(callback().withCallbackClass(TestExpectationResponseCallback.class.getName()));
    }
}