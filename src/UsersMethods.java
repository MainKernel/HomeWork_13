import UserData.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import japa.parser.ast.expr.ArrayAccessExpr;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class UsersMethods {

    public void userToGson(User user) {
        try (Writer writer = new FileWriter("src/UsersOutput/User.json", true)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(user, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void getAllUserInfo(String url) {
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .build();
//
//        try {
//            HttpResponse<Path> response = client.send(request,
//                    HttpResponse.BodyHandlers.ofFile(Paths.get("src/UsersOutput/UserGet.txt")));
//        } catch (IOException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void postUser(User user, String url) {
        // Post user works: response.statusCode() = 201
//        response.body() = {
//                "id": 11
//}
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(user).toString()))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("response.statusCode() = " + response.statusCode());
            System.out.println("response.body() = " + response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public ArrayList<User> jsonToObjectArray(File file) throws FileNotFoundException { // Works Fine
        Gson gson = new Gson();
        return new Gson().fromJson(new JsonReader(new FileReader(file)), new TypeToken<List<User>>() {
        }
                .getType());
    }

    public void putUser(ArrayList<User> user, String url) {


        String gson = new Gson().toJson(user.get(1));
        System.out.println(gson);

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(user))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("response.statusCode() = " + response.statusCode());
            System.out.println("response.body() = " + response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
