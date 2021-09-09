import java.util.Scanner;

public class MyMain {
    // Write a method that asks the user to input a double between 0.0 and 1000000.0
    // Your method should keep asking them until they type in a valid value
    // The method returns the final double they type in

    // scan.nextDouble() might be useful here
    public static double inputDouble() {
        Scanner scan = new Scanner(System.in);

        double d = -1.0;

        do {
            System.out.println("Please enter a number between 0.0 and 1000000.0");
            d = scan.nextDouble();
        } while (d < 0.0 || d > 100000.0);

        return d;
    }

    // Takes a double money as input and returns the number of quarters that we
    // can return in change
    // You should use a while loop!
    public static int numQuarters(double money) {
        int quarters = 0;
        while (money > 0.25 || Math.abs(0.25 - money) < 0.00001) {
            quarters += 1;
            money -= 0.25;
        }
        return quarters;
    }

    public static int numCoins(double money, double coin) {
        int coins = 0;
        while (money > coin || Math.abs(coin - money) < 0.00001) {
            coins += 1;
            money -= coin;
        }
        return coins;
    }

    // Takes a double money as input and returns the number of dimes that we
    // can return in change
    // You should use a while loop!
    public static int numDimes(double money) {
        return numCoins(money, 0.10);
    }

    // Takes a double money as input and returns the number of nickels that we
    // can return in change
    // You should use a while loop!
    public static int numNickels(double money) {
        return numCoins(money, 0.05);
    }

    // Takes a double money as input and returns the number of pennies that we
    // can return in change
    // You should use a while loop!
    public static int numPennies(double money) {
        return numCoins(money, 0.01);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        // You should test inputDouble yourself!
//        double d = inputDouble();
//
//        // Some code to test numQuarters
//        System.out.println("\nnumQuarters tests:");
//        System.out.println("1.25 in quarters would be: " + numQuarters(1.25) + " quarters.");
//        System.out.println("10.55 in quarters would be: " + numQuarters(10.55) + " quarters.");
//        System.out.println("1000000.20 in quarters would be: " + numQuarters(1000000.20) + " quarters.");
//
//        // Some code to test numDimes
//        System.out.println("\nnumDimes tests:");
//        System.out.println("1.20 in dimes would be: " + numDimes(1.20) + " dimes.");
//        System.out.println("120.13 in dimes would be: " + numDimes(120.13) + " dimes.");
//        System.out.println("150.25 in dimes would be: " + numDimes(150.25) + " dimes.");

        double d = inputDouble();
        int quarters = numQuarters(d);
        d -= quarters * 0.25;
        int dimes = numDimes(d);
        d -= dimes * 0.10;
        int nickels = numNickels(d);
        d -= nickels * 0.05;
        int pennies = numPennies(d);

        System.out.println("You will get " + quarters + " quarters, " + dimes + " dimes, " +
                           nickels + " nickels, and " + pennies + " pennies.");
        System.out.println("You will have " + (quarters + dimes + nickels + pennies) + " coins in total");

        scan.close();
    }
}