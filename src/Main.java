import userData.Address;
import userData.Company;
import userData.Geo;
import userData.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Object> test = new HashMap<>() {
        };
        User user = new User(11, "Test user", "Test username", "fsdfds@mail.com",
                new Address("fdsf", "sdfsdf", "sdfsdf",
                        "sdfdsf", new Geo("Sfdsdfs", "sdfsdf")), "fsdfsd", "fsdfsd",
                new Company("Test company", "fdsfdf", "bs"));

        File file = new File("src/UsersOutput/UserGet.txt");

        UsersMethods usersMethods = new UsersMethods();
        String url = "https://jsonplaceholder.typicode.com/users";


        //Task 1

        //getting information about all users
        usersMethods.getAllUserInfo(url);

        //Converting all users info to objects array
        ArrayList<Object> userArrayList = null;
        try {
            userArrayList = usersMethods.jsonToObjectArray(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //creation of a new user
        usersMethods.postUser(user, url);

        //update user
        usersMethods.putUser(userArrayList, 4, url);

        //delete user
        usersMethods.deleteUser(userArrayList, 4, url);

        //gating user info with id
        usersMethods.getUserInfoWithID(3, url);

        //obtaining information about the user with the username
        usersMethods.getUserInfoWithUserName("Samantha", url);


        // Task 2

        usersMethods.getCommentsToLastPost(2);


        // Task 3

        usersMethods.toDoSList(1);


    }
}
