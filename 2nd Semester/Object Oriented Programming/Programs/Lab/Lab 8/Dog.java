class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void sound() {
        System.out.println(name + " makes a animal sound.");
    }
}
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void sound() {
        super.sound();
        System.out.println(name + " says: Woof! Woof!");
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Teeni");
        dog.sound();

        System.out.println("Another Dog-");
        Dog dog2 = new Dog("Meeroo");
        dog2.sound();
    }
}
