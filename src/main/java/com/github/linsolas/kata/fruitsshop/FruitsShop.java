package com.github.linsolas.kata.fruitsshop;

import java.util.Scanner;

public class FruitsShop {

    private int total = 0;
    private int cerises = 0;
    private int bananes = 0;
    private int apples = 0;
    private int mele = 0;
    private int fruits = 0;
    private int apple_pomme = 0;

    public void loop() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(doSomethingWithInput(input));
            System.out.print("> ");
        }
    }

    public String doSomethingWithInput(String input) {
        String[] fruits = input.split(",");
        String last = null;
        for (String s : fruits) {
            last = manageOneFruit(s);
        }
        return last;
    }

    private String manageOneFruit(String input) {
        Fruit f = Fruit.what(input);
        if (f != null) {
            System.out.println("1 " + total);
            total += f.getPrice();
            System.out.println("2 " + total);
            switch (f) {
                case APPLES:
                    if (++apples % 3 == 0) {
                        total -= Fruit.APPLES.getPrice();
                    }
                    if (++apple_pomme % 4 == 0) {
                        total -= 100;
                    }
                    break;
                case MELE:
                    if (++mele % 2 == 0) {
                        total -= 50;
                    }
                    if (++apple_pomme % 4 == 0) {
                        total -= 100;
                    }
                    break;
                case POMME:
                    if (++apple_pomme % 4 == 0) {
                        total -= 100;
                    }
                    break;
                case CERISE:
                    if (++cerises % 2 == 0) {
                        total -= 20;
                    }
                    break;
                case BANANE:
                    if (++bananes % 2 == 0) {
                        total -= Fruit.BANANE.getPrice();
                    }
                    break;
            }
            System.out.println("3 " + total);
            if (++fruits % 5 == 0) {
                total -= 200;
            }
            System.out.println("4 " + total);
            System.out.println();
        }
        return String.valueOf(total);
    }

    public static void main(String[] args) {
        new BasicLoop().loop();
    }

}
