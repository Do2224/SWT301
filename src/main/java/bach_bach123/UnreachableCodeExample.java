package bach_bach123;

import java.util.logging.Logger;

public class UnreachableCodeExample {
    private static final Logger logger = Logger.getLogger(UnreachableCodeExample.class.getName());
    private static final int NUMBER = 42;

    public static void main(String[] args) {
        if (NUMBER > 0) {
            logger.info(String.valueOf(NUMBER));
        }
    }
}
