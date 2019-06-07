package core;

import java.util.concurrent.atomic.AtomicIntegerArray;

public enum Stock {

    APPLE, SUN, EA, ORACLE, YANDEX, GOOGLE, BLIZZARD;

    public static AtomicIntegerArray prices = new AtomicIntegerArray(new int[]{
            5,  //Apple
            6,  //Sun
            7,  //EA
            4,  //Oracle
            3,  //Yandex
            6,  //Google
            4,  //Blizzard
    });

    public int getPrice() {
        return prices.get(this.ordinal());
    }

    public void setPrice(int price) {
        prices.set(ordinal(), price);
    }
}