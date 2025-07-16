package bach_bach123;

interface LoginHandler {
    boolean login(String username, String password);
}

class SimpleLoginHandler implements LoginHandler {
    @Override
    public boolean login(String username, String password) {
        // Example logic: accept any non-empty username and password
        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }
}

public class InterfaceNamingInconsistencyExample {
    public static void main(String[] args) {
        LoginHandler handler = new SimpleLoginHandler();
        boolean result = handler.login("user", "pass");
        System.out.println("Login successful: " + result);
    }
}
