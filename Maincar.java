class Car {
    String make;
    String model;
    int year;
    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    void displayDetails() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Year: " + year);
    }
}
public class Maincar {
    public static void main(String[] args) {
        Car car1 = new Car("BNW", "ZVX", 2008);
        Car car2 = new Car("HUNDAI", "ULTRA", 2018);
        car1.displayDetails();
        System.out.println();
        car2.displayDetails();
    }
}