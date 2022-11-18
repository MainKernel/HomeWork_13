import UserData.Address;
import UserData.Company;
import UserData.Geo;
import UserData.User;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Object> test = new HashMap<>() {
        };
        User user = new User(11, "Test user", "Test username", "fsdfds@mail.com",
                new Address("fdsf", "sdfsdf", "sdfsdf",
                        "sdfdsf", new Geo("Sfdsdfs", "sdfsdf", test), test), "fsdfsd", "fsdfsd",
                new Company("Test company", "fdsfdf", "bs", test), test);
        File file = new File("src/UsersOutput/UserGet.txt");
        UsersMethods um = new UsersMethods();
        String url = "https://jsonplaceholder.typicode.com/users";


//Task 1

        //getting information about all users
        um.getAllUserInfo(url);
        //Converting all users info to objects array
        ArrayList<Object> userArrayList = um.jsonToObjectArray(file);
        //creation of a new user
        um.postUser(user, url);
        //update user
        um.putUser(userArrayList, 4, url);
        //delete user
        um.deleteUser(userArrayList, 4, url);
        //gating user info with id
        um.getUserInfoWithID(3, url);
        //obtaining information about the user with the username
        um.getUserInfoWithUserName("Samantha", url);
// Task 2


    }
}
