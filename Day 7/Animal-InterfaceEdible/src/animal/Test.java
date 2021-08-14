package animal;

import fruit.Fruit;
import fruit.Apple;
import fruit.Orange;

public class Test {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        System.out.println(tiger.makeSound());

        Chicken chicken = new Chicken();

        System.out.println(chicken.makeSound());
        System.out.println(chicken.howToEat());

        Animal[] animals = new Animal[2];
        animals[0] = tiger;
        animals[1] = chicken;
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
//            animal.howToEat(); // can not be invoked because object tiger has no method howToEat();
        }

        Apple apple = new Apple();
        System.out.println(apple.howToEat());

        Orange orange = new Orange();
        System.out.println(orange.howToEat());

        Fruit[] fruits = new Fruit[2];
        fruits[0] = apple;
        fruits[1] = orange;

        for (Fruit element : fruits) {
            System.out.println(element.howToEat());
        }
    }
}