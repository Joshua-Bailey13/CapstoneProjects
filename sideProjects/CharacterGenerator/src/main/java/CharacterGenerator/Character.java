package CharacterGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public /*abstract*/ class Character {
    private String enteredClass;
    private int str;
    private int dex;
    private int wis;
    private int cha;
    private int intelligence;
    private List<Integer> stats = new ArrayList<Integer>();
public Character(String enteredClass){
    this.enteredClass=enteredClass;
    str = (int) (3+(Math.random()*((18-3)+1)));
    cha = (int) (3+(Math.random()*((18-3)+1)));
    dex = (int) (3+(Math.random()*((18-3)+1)));
    wis = (int) (3+(Math.random()*((18-3)+1)));
    intelligence = (int) (3+(Math.random()*((18-3)+1)));

}
    public int getCha() {
        return cha;
    }

    public int getDex() {
        return dex;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStr() {
        return str;
    }

    public int getWis() {
        return wis;
    }

    public void setEnteredClass(String enteredClass) {
        this.enteredClass = enteredClass;
    }

    public String getEnteredClass() {
        return enteredClass;
    }
    public /*abstract*/ List<Integer> getStats;
}
