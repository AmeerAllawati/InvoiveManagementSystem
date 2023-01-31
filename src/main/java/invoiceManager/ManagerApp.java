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


        Shop mainShop = new Shop();
        Scanner sc = new Scanner(System.in);
        int mainMenuUserInput = 0;
        boolean programEnded = false;

        while(!programEnded) {
            mainMenu.printMenu();


            //User input 

            System.out.print("Please enter your choice: ");

            mainMenuUserInput = sc.nextInt();
            sc.nextLine();

            switch(mainMenuUserInput) {
            case 1:
                mainMenu.menuItems.get(0).printItem();
                System.out.print("Please enter your choice: ");
                int shopSettingsUserInput = sc.nextInt();
                sc.nextLine();
                switch(shopSettingsUserInput) {
                case 1:
                    mainShop.loadData(); //TODO: This needs to be changed, loading the data should read from a file.
                    break;
                case 2:
                    System.out.print("Please enter the new shop name: ");
                    String newShopName = sc.nextLine();
                    mainShop.setShopName(newShopName);
                    //System.out.print(mainShop.shopName);
                    break;
                case 3: 
                    System.out.print("Enter the new phone number: ");
                    int newPhone = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter the new fax number: ");
                    int newFax = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter the new Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter the new website: ");
                    String newWebsite = sc.nextLine();

                    mainShop.setInvoiveHeader(newPhone, newFax, newEmail, newWebsite);
                    break;
                    case 4:
                        continue;
                }
                break;
            case 2:
                mainMenu.menuItems.get(1).printItem();
                System.out.print("Please enter your choice: ");
                int manageShopUserInput = sc.nextInt();
                sc.nextLine();
                switch(manageShopUserInput) {
                case 1: 
                    System.out.print("Enter the product ID: ");
                    int productId = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Enter the product name: ");
                    String productName = sc.nextLine();
                    
                    System.out.print("Enter the product unit price: ");
                    double productUnitPrice = sc.nextDouble();
                    sc.nextLine();
                    
                    System.out.print("Enter the product quantity: ");
                    int productQuantity = sc.nextInt();
                    sc.nextLine();
                    
                    mainShop.addProduct(productId, productName, productUnitPrice, productQuantity);
                    break;
                case 2:
                    System.out.print("Enter the product ID you want to delete: ");
                    int deletedId = sc.nextInt();
                    sc.nextLine();
                    
                    mainShop.deleteProduct(deletedId);
                    break;
                case 3:
                    System.out.print("Enter the product ID you want to change the price of: ");
                    int productToModifyId = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Enter the new price of the mentioned product: ");
                    double newProductPrice = sc.nextDouble();
                    sc.nextLine();
                    
                    mainShop.products.get(productToModifyId).setUnitPrice(newProductPrice);
                    break;
                case 4:
                    mainShop.printProducts();
                    break;
                case 5: 
                    continue;
                }
                break;
            case 3:
                // take user input for a new invoice
            }
        }

    }
}
