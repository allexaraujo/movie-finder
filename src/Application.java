import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Application {

    private static final String APIKEY = "API_KEY_FORNECIDA_PELA_IMDB";

    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest
            .newBuilder(URI.create(new StringBuilder()
                .append("https://imdb-api.com/br/API/Top250Movies/")
                .append(APIKEY).toString()))
            .GET()
            .build();

        client.sendAsync(httpRequest, BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println)
            .join();


    }
}
