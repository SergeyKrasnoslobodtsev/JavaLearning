package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cup = 9;
    static int money = 550;

    public static void main(String[] args) {
        Process();
    }
    static void Process() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
            String str = scanner.nextLine();
            if(str.equals("exit"))
                break;
            switch (str) {
                case "buy":
                    OnBuy();
                    break;
                case "fill":
                    OnFill();
                    break;
                case "take":
                    OnTake();
                    break;
                case "remaining":
                    OnRemaining();
                    break;
                default:
                    break;
            }
        }
    }

    static void OnRemaining(){
        System.out.println(GetStatus());
    }

    static void OnTake(){
        System.out.println("I gave you $" + money);
        money = 0;
        System.out.println(GetStatus());
    }

    static  void OnFill(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        water = water + scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk = milk + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeBeans = coffeeBeans + scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cup = cup + scanner.nextInt();
    }
    static void OnBuy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String command = scanner.next();
        if(command.length() == 1) {
            int typeCoffee = Character.getNumericValue(command.charAt(0));
            if ( water < GetWater(1, typeCoffee) )
                System.out.println("Sorry, not enough water!");
            else if ( milk < GetMilk(1, typeCoffee) )
                System.out.println("Sorry, not enough milk!");
            else if ( coffeeBeans < GetCoffeeBeans(1, typeCoffee) )
                System.out.println("Sorry, not enough coffee beans!");
            else if ( cup == 0 )
                System.out.println("Sorry, not enough disposable cups!");
            else {
                water = water - GetWater(1, typeCoffee);
                milk = milk - GetMilk(1, typeCoffee);
                coffeeBeans = coffeeBeans - GetCoffeeBeans(1, typeCoffee);
                cup = cup - 1;
                money = money + GetMoney(1, typeCoffee);
                System.out.println("I have enough resources, making you a coffee!");
            }
        }
    }

    static String GetStatus(){
        return "\nThe coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                coffeeBeans + " of coffee beans\n" +
                cup + " of disposable cups\n" +
                "$"+money + " of money";
    }

    static int GetWater(int cup, int coffee) {
        switch (coffee) {
            case 1:
                return 250 * cup;
            case 2:
                return 350 * cup;
            case 3:
                return 200 * cup;
            default: return 0;
        }
    }

    static int GetMilk(int cup, int coffee){
        switch (coffee) {
            case 2:
                return 75 * cup;
            case 3:
                return 100 * cup;
            default: return 0;
        }
    }

    static int GetCoffeeBeans(int cup, int coffee){
        switch (coffee) {
            case 1:
                return 16 * cup;
            case 2:
                return 20 * cup;
            case 3:
                return 12 * cup;
            default: return 0;
        }
    }

    static  int GetMoney(int cup, int coffee){
        switch (coffee) {
            case 1:
                return 4 * cup;
            case 2:
                return 7 * cup;
            case 3:
                return 6 * cup;
            default: return 0;
        }
    }
}

