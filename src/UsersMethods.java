import UserData.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UsersMethods {

    public void userToGson(User user) {
        try (Writer writer = new FileWriter("src/UsersOutput/User.json", true)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(user, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getAllUserInfo(String uri) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson().newBuilder().disableHtmlEscaping().create();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/UsersOutput/UserGet.json"));) {
            gson.toJson(response.body(), writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
