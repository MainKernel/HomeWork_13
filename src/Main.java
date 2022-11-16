public class Main {
    public static void main(String[] args) {
        UsersMethods um = new UsersMethods();
        String uri = "https://jsonplaceholder.typicode.com/users";
        um.getAllUserInfo(uri);
    }
}
