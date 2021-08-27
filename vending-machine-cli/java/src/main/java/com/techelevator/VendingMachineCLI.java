package com.techelevator;

import com.techelevator.vendables.*;
import com.techelevator.view.Menu;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private Menu menu;
    private Scanner userInput;
    private MakeChange newBalance = new MakeChange();
    private String log;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a ");
    // 01/01/2016 12:00:00 PM FEED MONEY: \$5.00 \$5.00
    private LocalDateTime currentDateTime = LocalDateTime.now();
    private String currentDateTimeformatted = currentDateTime.format(dateTimeFormatter);
    private ItemImportMap itemImportMap = new ItemImportMap();


    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
        this.userInput = new Scanner(System.in);
        this.log = currentDateTimeformatted;
    }

    public void run() {

        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
//				for (Vendable item : itemImportMap.readInventory()){
//				System.out.println(item);
//				}	System.out.println("Press [enter] to continue: ");
//				userInput.nextLine();

                subMenu1();

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
                subMenu2();
            } else {
                writeLog(currentDateTimeformatted + " Change Tendered: \\$" + newBalance.getBalance());
                System.out.println(newBalance.giveChange(newBalance.getBalance()));
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }

    public void subMenu1() {
        System.out.println("Please select an option: ");

        Menu menu1SubMenu = new Menu(System.in, System.out);
        String typesMenuChips = "Chips";
        String typesMenuGum = "Gum";
        String typesMenuDrink = "Drink";
        String typesMenuCandy = "Candy";
        String typesMenuExit = "Exit to main menu";
        String[] typesMenu = {typesMenuChips, typesMenuGum, typesMenuDrink, typesMenuCandy, typesMenuExit};

        while (true) {
            String choice = (String) menu1SubMenu.getChoiceFromOptions(typesMenu);
            if (choice.equals(typesMenuChips)) {
                for (Vendable item : itemImportMap.readInventory()) {
                    if (item.getType().equals("Chip")) {
                        System.out.println(item);
                    }
                }
                System.out.println("Press [enter] to continue: ");
                userInput.nextLine();
            } else if (choice.equals(typesMenuGum)) {
                for (Vendable item : itemImportMap.readInventory()) {
                    if (item.getType().equals("Gum")) {
                        System.out.println(item);
                    }
                }
                System.out.println("Press [enter] to continue: ");
                userInput.nextLine();
            } else if (choice.equals(typesMenuDrink)) {
                for (Vendable item : itemImportMap.readInventory()) {
                    if (item.getType().equals("Drink")) {
                        System.out.println(item);
                    }
                }
                System.out.println("Press [enter] to continue: ");
                userInput.nextLine();

            } else if (choice.equals(typesMenuCandy)) {
                for (Vendable item : itemImportMap.readInventory()) {
                    if (item.getType().equals("Candy")) {
                        System.out.println(item);
                    }
                }
                System.out.println("Press [enter] to continue: ");
                userInput.nextLine();
            } else {
                break;
            }
        }
    }

    public void subMenu2() {
        System.out.println("Please select an option: ");

        Menu menu2Submenu = new Menu(System.in, System.out);
        String purchaseMenu1 = "Feed Money";
        String purchaseMenu2 = "Select Product";
        String purchaseMenu3 = "Finish Transaction";
        String[] purchaseMenu = {purchaseMenu1, purchaseMenu2, purchaseMenu3};
        String purchaseChoice = (String) menu2Submenu.getChoiceFromOptions(purchaseMenu);

        while (true) {
           System.out.println("Your Current Balance: $" + newBalance.getBalance());
            if (purchaseChoice.equals(purchaseMenu1)) {
                System.out.println("Machine accepts: $1, $2, $5, $10");
                System.out.print("Feed Money: ");
                String enteredAmount = userInput.nextLine();
                if (enteredAmount.equals("1") || (enteredAmount.equals("2") || (enteredAmount.equals("5") || (enteredAmount.equals("10"))))) {
                    double enteredAmountAsDouble = Double.parseDouble(enteredAmount);
                    newBalance.setBalance(newBalance.getBalance()+enteredAmountAsDouble);
                    writeLog(currentDateTimeformatted + " Feed Money: $" + enteredAmount);
                    System.out.println("[enter] to continue");
                    userInput.nextLine();
                    System.out.println("Your Current Balance: $" + newBalance.getBalance());


                } else {
                    System.out.println("Please enter a valid dollar amount:1, 2, 5, 10");
                } return;
            } else if (purchaseChoice.equals(purchaseMenu2)) {
                System.out.println("Please enter item slot location ex:(A1, B2, etc.): ");
                /*for (Vendable item : itemImportMap.readInventory()) {
                    System.out.println(item);
                }*/
                String selectedItem = userInput.nextLine();
                for (Vendable item : itemImportMap.readInventory()) {
                   if (((selectedItem.equals(item.getSlot()))&&(item.getQuantity()>=1))&&(newBalance.getBalance()>=item.getPrice())) {
                       System.out.println("Enjoy your " + item.getName() + "!");
                       System.out.println(item.getConsume());
                        item.setQuantity(item.getQuantity() - 1);
                        writeLog(currentDateTimeformatted + " " + item.getName() + " " + selectedItem + " \\$" + newBalance.getBalance() );//+ selectedProduct);
                        newBalance.setBalance(newBalance.getBalance() - item.getPrice());
                    }else if (item.getQuantity()==0){
                       System.out.println("Item out of stock");
                   }else if (newBalance.getBalance()< item.getPrice()) {System.out.println("Please insert sufficient money");
                       break;}/* else if (!selectedItem.exists){ //.exists not a keyword
                       System.out.println("Please select a valid item");
                   }*/


                }
                System.out.println("[enter] to continue");

                //quantity -=1 if quantity ==0 return "Out of Stock" and do not take money

               // writeLog(currentDateTimeformatted + selectedItem);//+ selectedProduct);
                userInput.nextLine();
                //send log to writeLog
                System.out.println("Your Current Balance: $" + newBalance.getBalance());
                return;
            } else {
                writeLog(currentDateTimeformatted + " Change Tendered: \\$" + newBalance.getBalance() );
                System.out.println(newBalance.giveChange(newBalance.getBalance()));
                System.exit(0);
                break;


            }

        }

    }

    private void writeLog(String log) {
        //path
        Path path = Paths.get("log.txt");

        //File object
        File fileToWrite = new File(path.toAbsolutePath().toString());

        //try catch
        try (
                FileWriter fileWriter = new FileWriter(fileToWrite, true);
                PrintWriter pw = new PrintWriter(fileWriter)
        ) {
            //write the message to the file
            pw.println(log);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}