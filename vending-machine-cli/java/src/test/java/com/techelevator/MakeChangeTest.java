package com.techelevator;

import com.techelevator.vendables.MakeChange;
import org.junit.Assert;
import org.junit.Test;

public class MakeChangeTest {
MakeChange makeChange = new MakeChange();
    @Test

    public void shouldReturn4quarters(){
        //Arrange
        double entered = 1;
        String expected = "Thank you for your purchase your change is: 4 Quarters 0 Dimes 0 Nickles";
        //Act
        String actual = makeChange.giveChange(entered);
        //Assert
        Assert.assertEquals("This should return 4 quarters",expected, actual);
    }
    @Test
    public void shouldReturn0(){
        //Arrange
        double entered = -6;
        String expected = "Thank you for your purchase your change is: 0 Quarters 0 Dimes 0 Nickles";
        //Act
        String actual = makeChange.giveChange(entered);
        //Assert
        Assert.assertEquals("This should return 4 quarters",expected, actual);
    }
    @Test
    public void shouldReturn4quarters1dime1nickle(){
        //Arrange
        double entered = 1.15;
        String expected = "Thank you for your purchase your change is: 4 Quarters 1 Dimes 1 Nickles";
        //Act
        String actual = makeChange.giveChange(entered);
        //Assert
        Assert.assertEquals("This should return 4 quarters",expected, actual);
    }

}
