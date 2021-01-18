package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int water = SetWater(scanner);
        int milk  = SetMilk(scanner);
        int coffee = SetCoffee(scanner);
        int cup = SetCup(scanner);
        int makeCup = GetMakeCup(water,milk, coffee);
        if(cup == makeCup)
            System.out.println("Yes, I can make that amount of coffee");
        else if (cup > makeCup)
            System.out.println("No, I can make only "+makeCup+" cup(s) of coffee");
        else
            System.out.println("Yes, I can make that amount of coffee (and even "+ (makeCup-cup) +" more than that)");


    }

    static int GetMakeCup(int water, int milk, int coffee){
        water = water / GetWater(1);
        milk = milk / GetMilk(1);
        coffee = coffee / GetCoffee(1);

        return  Math.min(Math.min(water, milk), coffee);
    }

    static int GetWater(int cup){
        return 200 * cup;
    }
    static int GetMilk(int cup){
        return 50 * cup;
    }
    static int GetCoffee(int cup){
        return  15 * cup;
    }
    static int SetWater(Scanner scanner){
        System.out.println("Write how many ml of water the coffee machine has:");
        return scanner.nextInt();
    }
    static int SetMilk(Scanner scanner){
        System.out.println("Write how many ml of milk the coffee machine has:");
        return scanner.nextInt();
    }
    static int SetCoffee(Scanner scanner){
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        return scanner.nextInt();
    }
    static int SetCup(Scanner scanner){
        System.out.println("Write how many cups of coffee you will need:");
        return scanner.nextInt();
    }
}
