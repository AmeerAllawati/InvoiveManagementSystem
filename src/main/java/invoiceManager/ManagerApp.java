package invoiceManager;

import java.util.Scanner;

public class ManagerApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MenuItems firstItems = new MenuItems(1, "Shop Settings");
        Menu mainMenu = new Menu("Main Menu", firstItems);
        mainMenu.addItem(2, "Manage Shop Items");
        mainMenu.addItem(3, "Create New Invoice");
        mainMenu.addItem(4, "Report: Statistics");
        mainMenu.addItem(5, "Report: All Invoices");
        mainMenu.addItem(6, "Search (1) Invoice");
        mainMenu.addItem(7, "Program Statistics");
        mainMenu.addItem(8, "Exit");
        
        // This is for adding sub-items for the first choice in the main menu (Shop Settings)
        MenuItems firstSubItems1 = new MenuItems(1, "Load Data"); 
        Menu shopSettingsSubMenu = new Menu("Shop Settings Sub Menu", firstSubItems1);
        shopSettingsSubMenu.addItem(2, "Set Shop Name");
        shopSettingsSubMenu.addItem(3, "Set Invoice Header");
        shopSettingsSubMenu.addItem(4, "Go Back");
        mainMenu.menuItems.get(0).setAsMenu(shopSettingsSubMenu);
        
        // Below is for adding sub-items for the second choice in the main menu (Manage Shop Items)
        MenuItems secondSubItems1 = new MenuItems(1, "Add Items");
        Menu manageShopSubItemsMenu = new Menu("Manage Shop Items Sub Menu", secondSubItems1);
        manageShopSubItemsMenu.addItem(2, "Delete Items");
        manageShopSubItemsMenu.addItem(3, "Change Item Price");
        manageShopSubItemsMenu.addItem(4, "Report All Items");
        manageShopSubItemsMenu.addItem(5, "Go Back");
        mainMenu.menuItems.get(1).setAsMenu(manageShopSubItemsMenu);
        
        mainMenu.printMenu();
        
        //User input 
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your choice: ");
        
        int mainMenuUserInput = sc.nextInt();
        sc.nextLine();
        
        switch(mainMenuUserInput) {
            case 1:
                mainMenu.menuItems.get(0).printItem();
                
                break;
            case 2:
                mainMenu.menuItems.get(1).printItem();
        }
    }

}
