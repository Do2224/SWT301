package bach_bach123;

import java.util.logging.Logger;

class Animal {
    private static final Logger logger = Logger.getLogger(Animal.class.getName());
    void speak() {
        logger.info("Animal speaks");
    }
}

class Dog extends Animal {
    private static final Logger logger = Logger.getLogger(Dog.class.getName());
    void bark() {
        logger.info("Dog barks");
    }
}

public class MissingOverrideAnnotationExample {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.speak();
        Dog dog = new Dog();
        dog.bark();
    }
}
