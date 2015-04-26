package com.github.linsolas.kata.fruitsshop;

public enum Fruit {

    POMME(100, "pomme", "pommes"),
    APPLES(100, "apple", "apples"),
    MELE(100, "mele"),
    BANANE(150, "banane", "bananes"),
    CERISE(75, "cerise", "cerises");

    private int price;
    private String[] names;

    Fruit(int price, String... names) {
        this.price = price;
        this.names = names;
    }

    public int getPrice() {
        return price;
    }

    public static Fruit what(String s) {
        for (Fruit f : values()) {
            for (String n : f.names) {
                if (n.equalsIgnoreCase(s.trim())) {
                    return f;
                }
            }
        }
        return null;
    }

}
