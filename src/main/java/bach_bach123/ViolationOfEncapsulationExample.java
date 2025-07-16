package bach_bach123;

import java.util.logging.Logger;

class User {
    private static final Logger logger = Logger.getLogger(User.class.getName());
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        if (name != null && age >= 0) {
            logger.info(String.format("Name: %s, Age: %d", name, age));
        }
    }
}

public class ViolationOfEncapsulationExample {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Alice");
        user.setAge(30);
        user.display();
    }
}
