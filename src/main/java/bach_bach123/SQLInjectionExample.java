package bach_bach123;

import java.util.logging.Logger;

public class SQLInjectionExample {
    private static final Logger logger = Logger.getLogger(SQLInjectionExample.class.getName());

    public static void main(String[] args) {
        String userInput = "' OR '1'='1";
        String query = String.format("SELECT * FROM users WHERE username = '%s'", userInput);
        logger.info("Executing query: " + query);
    }
}
