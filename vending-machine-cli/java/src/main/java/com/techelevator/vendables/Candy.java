package com.techelevator.vendables;
import java.math.BigDecimal;

public class Candy extends Vendable{

private String consume;

public Candy(String slot, double price, String name, String type, int quantity ) {
    super(slot, price, name, type, quantity);}

    @Override
    public String getConsume() {
        return "Munch Munch, Yum!";
    }
    @Override
    public String toString(){
        return (getSlot() + " " + getName() + " " + getPrice()+ " Quantity: " + getQuantity() );
    }
}

