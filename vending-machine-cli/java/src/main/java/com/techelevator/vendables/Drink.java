package com.techelevator.vendables;

import java.math.BigDecimal;

public class Drink extends Vendable{
    private String consume;
    public Drink(String slot, double price, String name, String type, int quantity) {
        super(slot, price, name, type, quantity);
    }
    public String getConsume(){
        return "Glug Glug, Yum!";
    }

    @Override
    public String toString() {
        return (getSlot()  + " " + getName() + " " + getPrice()+ " Quantity: " + getQuantity() );
    }

}
