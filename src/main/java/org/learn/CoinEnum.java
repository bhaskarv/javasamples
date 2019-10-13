package org.learn;

/**
 * Created by vinay on 24/3/18.
 */
public enum  CoinEnum {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    private int value;

    CoinEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

}
