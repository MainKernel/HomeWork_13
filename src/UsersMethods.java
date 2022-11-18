import Comments.Comment;
import UserData.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class UsersMethods<T> {


    public void getAllUserInfo(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<Path> response = client.send(request,
                    HttpResponse.BodyHandlers.ofFile(Paths.get("src/UsersOutput/UserGet.txt")));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

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

    public ArrayList<T> jsonToObjectArray(File file) throws FileNotFoundException { // Works Fine
        Gson gson = new Gson();
        return new Gson().fromJson(new JsonReader(new FileReader(file)), new TypeToken<List<T>>() {
        }
                .getType());
    }


    public void putUser(ArrayList<User> user, int id, String url) {

        String uri = url + "/" + (id);
        String userWithId = String.valueOf(user.get(id));



        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .version(HttpClient.Version.HTTP_1_1)
                    .timeout(Duration.ofMinutes(1))
                    .PUT(HttpRequest.BodyPublishers.ofString(userWithId))
                    .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("response_PUT_statusCode() = " + response.statusCode());
            System.out.println("response.body() = " + response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void deleteUser(ArrayList<User> user, int id, String url){

        String uri = url + "/" + (id);
        String userWithId = String.valueOf(user.get(id));

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .version(HttpClient.Version.HTTP_1_1)
                .timeout(Duration.ofMinutes(1))
                .method("DELETE", HttpRequest.BodyPublishers.ofString(userWithId))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("response_Delete_statusCode() = " + response.statusCode());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }



    }

    public void getUserInfoWithID(int id, String url){
        String uri = url + "/" + id;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        try {
            HttpResponse<Path> response = client.send(request,
                    HttpResponse.BodyHandlers.ofFile(Paths.get("src/UsersOutput/Get$" + id + "$User.txt")));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void getUserInfoWithUserName(String name, String url){

        String uri = url + "?username=" + name;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        try {
            HttpResponse<Path> response = client.send(request,
                    HttpResponse.BodyHandlers.ofFile(Paths.get("src/UsersOutput/Get$" + name + "$User.txt")));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void getComments(){
        try {
            URI url = new URI("https://jsonplaceholder.typicode.com/users/1/posts");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
