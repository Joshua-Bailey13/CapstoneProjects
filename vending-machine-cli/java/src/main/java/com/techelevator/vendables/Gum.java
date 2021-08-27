package com.techelevator.vendables;

import java.math.BigDecimal;

public class Gum extends Vendable {
    private String consume;

    public Gum(String slot, double price, String name, String type, int quantity) {
        super(slot, price, name, type, quantity);
    }

    @Override
    public String getConsume() {
        return "Chew Chew, Yum!";
    }

    @Override
    public String toString() {
        return (getSlot() + " " + getName() + " " + getPrice() + " Quantity: " + getQuantity());
    }
}