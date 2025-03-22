import java.util.*;

class UserRegistry {
    private static UserRegistry instance;
    private Map<String, User> users = new HashMap<>();

    private UserRegistry() {}

    public static UserRegistry getInstance() {
        if (instance == null) instance = new UserRegistry();
        return instance;
    }

    public void createUser(String username, double wallet) {
        if (users.containsKey(username)) throw new IllegalArgumentException("User exists");
        users.put(username, new User(username, wallet));
    }

    public User getUser(String username) {
        User user = users.get(username);
        if (user == null) throw new IllegalArgumentException("User not found");
        return user;
    }
}