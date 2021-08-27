package com.techelevator.vendables;

import java.math.BigDecimal;

public class Chip extends Vendable{

    public Chip(String slot, double price, String name, String type, int quantity) {
        super(slot, price, name, type, quantity);
    }

    public String getConsume() {
        return "Crunch Crunch, Yum!";

    }

    @Override
    public String toString() {
        return (getSlot() + " " + getName() + " " + getPrice() + " Quantity: " + getQuantity());

    }
    
}
