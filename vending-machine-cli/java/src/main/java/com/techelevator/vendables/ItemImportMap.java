package com.techelevator.vendables;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
public class ItemImportMap {


    private final String currentDirrectory = System.getProperty("user.dir");
    private final File inventoryFile = new File(currentDirrectory + "/vendingmachine.csv");
    public List<Vendable> readInventory() {
        if (inventoryFile.exists()) {
            ArrayList<Vendable> arrayListOfItems = new ArrayList<Vendable>();
            try (Scanner fileReader = new Scanner(inventoryFile)) {
                while (fileReader.hasNextLine()){
                    String line = fileReader.nextLine();
                    String[] list = line.split("\\|");
                    if(list[3].equals("Chips")){

                        arrayListOfItems.add(new Chip(list[0],  Double.parseDouble(list[2]),list[1], list[3],5));
                    }else if (list[3].equals("Gum")) {

                        arrayListOfItems.add(new Gum(list[0], Double.parseDouble(list[2]), list[1], list[3],5));
                    }else if(list[3].equals("Drink")){
                        arrayListOfItems.add(new Drink(list[0], Double.parseDouble(list[2]),list[1], list[3],5));

                    }else {
                        arrayListOfItems.add(new Candy(list[0], Double.parseDouble(list[2]),list[1], list[3],5));

                    }

                }return arrayListOfItems;
            } catch (Exception ex) {
                System.out.println("Exception occurred" + ex);
            }return arrayListOfItems;
        }

        return null;
    }
}
/*
//This was a good idea but we need to do it differently per conversation with BK and MG
public class ItemImportMap {
    //perhaps change to array[3]
    private Map<String, List<Vendable>> items = readInventory();

    public Map<String, List<Vendable>> getInventory(){
    return items;
}
    public Map<String, List<Vendable>> readInventory() {
        File inventoryFile = new File(
                "C:/Users/Student/workspace/mod1-capstone-orange-t4/java/vendingmachine.csv");

        Map<String, List<Vendable>> items = new TreeMap<>();

        //String currentDirectory = System.getProperty("user.dir");

        try (Scanner fileReader = new Scanner(inventoryFile)) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(line);
                if (!line.isEmpty()) {
                    String[] fileReaderArray = line.split("\\|");

                    if (fileReaderArray[0].contains("B")) {
                        ArrayList<Vendable> itemArray = new ArrayList<>();
                        for (int i = 0; i < 6; i++) {
                            Candy temp = new Candy(fileReaderArray[0], new BigDecimal(fileReaderArray[2]),fileReaderArray[1], fileReaderArray[3]);
                            itemArray.add(temp);
                        }
                        items.put(fileReaderArray[0], itemArray);

                    } else if (fileReaderArray[0].contains("A")) {
                        List<Vendable> itemArray = new ArrayList<>();
                        for (int i = 0; i < 6; i++) {
                            Chip temp = new Chip(fileReaderArray[0], new BigDecimal(fileReaderArray[2]), fileReaderArray[1], fileReaderArray[3]);
                            itemArray.add(temp);
                        }
                        items.put(fileReaderArray[0], itemArray);

                    } else if (fileReaderArray[0].contains("C")) {
                        List<Vendable> itemArray = new ArrayList<>();
                        for (int i = 0; i < 6; i++) {
                            Drink temp = new Drink(fileReaderArray[0], new BigDecimal(fileReaderArray[2]), fileReaderArray[1],fileReaderArray[3]);
                            itemArray.add(temp);
                        }
                        items.put(fileReaderArray[0], itemArray);
                    } else {
                        List<Vendable> itemArray = new ArrayList<>();
                        for (int i = 0; i < 6; i++) {
                            Gum temp = new Gum(fileReaderArray[0], new BigDecimal(fileReaderArray[2]), fileReaderArray[1], fileReaderArray[3]);
                            itemArray.add(temp);
                        }
                        items.put(fileReaderArray[0],itemArray);
                    }
                }
            }
                return items;

            }catch(Exception ex){
            System.out.println("Oops, something happened" + ex);
            System.exit(1);
            return items;
        }
    }

    public Iterable<? extends Vendable> getItems() {
        return (Iterable<? extends Vendable>) items;
    }
}*/
