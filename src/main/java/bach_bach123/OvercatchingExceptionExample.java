package bach_bach123;

import java.util.logging.Logger;

public class OvercatchingExceptionExample {
    private static final Logger logger = Logger.getLogger(OvercatchingExceptionExample.class.getName());
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            arr[0] = 42; // Write to the array
            logger.info(String.valueOf(arr[0])); // Read a valid index
            // logger.info(String.valueOf(arr[10])); // This would throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.severe("Array index is out of bounds");
        }
    }
}
