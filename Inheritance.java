class Animal 
{
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Memom");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        animal.makeSound();
        cat.makeSound();
    }
}