package com.techelevator.vendables;

import java.math.BigDecimal;

public class MakeChange {
    private double balance = 0;
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public MakeChange(){}
    String change = "";
    int quarters = 0;
    int dimes = 0;
    int nickles = 0;
    public String giveChange (double finalBalance) {
        while (finalBalance!=0){
            if (finalBalance>=0.25){
                quarters+= 1;
                finalBalance-=0.25;
            }else if (finalBalance>=0.10){
               dimes +=1;
                finalBalance-=0.10;
            }else if (finalBalance>=0.049){//done due to rounding issues from doubles
                nickles= 1 ;
                finalBalance-=0.05;
            }else{
              return "Thank you for your purchase your change is: " + quarters +
                        " Quarters "+ dimes + " Dimes "+ nickles + " Nickles";
            }
        }return "Thank you for your purchase your change is: " + quarters +
                " Quarters "+ dimes + " Dimes "+ nickles + " Nickles";

    }

   /* private BigDecimal balance = new BigDecimal(0);
    private final BigDecimal  quarter = new BigDecimal(0.25);
    private final BigDecimal dime = new BigDecimal(0.10);
    private final BigDecimal nickel = new BigDecimal(0.05);
    private final BigDecimal zero = new BigDecimal(0);
    private String change = "";

    public MakeChange(){
    }

    public void setBalance(String balance) {
        this.balance = new BigDecimal(balance);
    }
    public BigDecimal getBalance(){
        return balance;
    }

    public void giveChange (BigDecimal finalBalance) {
        while (finalBalance.compareTo(zero) != 0){
            if (finalBalance.compareTo(quarter) >= 0){
                //.compare to gives -1(<) 0(==) or 1(>)
                change+="1 quarter";
                finalBalance.subtract(quarter);
            }else if (finalBalance.compareTo(dime) >=0){
                change+= "1 dime";
                finalBalance.subtract(dime);
            }else if (finalBalance.compareTo(nickel) >=0){
                change+= "1 nickle";
                finalBalance.subtract(nickel);
            }
        }
        balance = finalBalance;
        System.out.println("Your change is " + balance);


    }*/
}
