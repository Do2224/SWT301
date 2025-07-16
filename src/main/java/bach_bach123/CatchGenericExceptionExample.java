package bach_bach123;

import java.util.logging.Logger;

public class CatchGenericExceptionExample {
    private static final Logger logger = Logger.getLogger(CatchGenericExceptionExample.class.getName());
    public static void main(String[] args) {
        String s = "Hello, world!";
        if (s != null) {
            logger.info(String.format("String length: %d", s.length()));
        } else {
            logger.severe("String is null; cannot get length.");
        }
    }
}
