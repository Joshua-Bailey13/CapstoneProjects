package com.techelevator.vendables;
import java.math.BigDecimal;

public class Vendable {
    private String consume;
    private double price; //= new BigDecimal("");
    private String slot;
    private String name;
    private String type;
    private int quantity;
    public Vendable (String slot, double price, String name, String type, int quantity) {
        this.price = price;
        this.slot = slot;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public int getQuantity(){return quantity;}
    public String getType(){
        return type;}
    public String getConsume(){
        return consume;
    }
    /*public void setConsume(){
        this.consume = consume;
    }*/
    public double getPrice(){
        return price;
    }
    public String getSlot(){
        return slot;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    }
