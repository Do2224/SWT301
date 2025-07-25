package Bach;

public class AccountService {
    public boolean registerAccount(String username, String password, String email){
        if(username == null || username.isEmpty()){
            return false;
        }
        if(!username.matches("^[a-zA-Z0-9]+$")) {
            return false;
        }
        if(password == null || password.length() <= 6) {
            return false;
        }
        if(!isValidEmail(email)){
            return false;

        }
        return true;
    }
    public boolean isValidEmail(String email){
        if(email == null || email.isEmpty()){
            return false;
        }
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
}