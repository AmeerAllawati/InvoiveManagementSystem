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
        int firstOptionCounter = 0;
        int secondOptionCounter = 0;
        int thirdOptionCounter = 0;
        int fourthOptionCounter = 0;
        int fifthOptionCounter = 0;
        int sixthOptionCounter = 0;
        int seventhOptionCounter = 0;

        while(!programEnded) {
            mainMenu.printMenu();


            //User input 

            System.out.print("Please enter your choice: ");

            mainMenuUserInput = sc.nextInt();
            sc.nextLine();

            switch(mainMenuUserInput) {
            case 1:
                firstOptionCounter++;
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
                    int newPhone = Integer.parseInt(sc.nextLine());
                    //sc.nextLine();

                    System.out.print("Enter the new fax number: ");
                    int newFax = Integer.parseInt(sc.nextLine());
                    //sc.nextLine();

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
                secondOptionCounter++;
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
                thirdOptionCounter++;
                // take user input for a new invoice
                System.out.print("Enter the name of the customer: ");
                String customerName = sc.nextLine();
                
                System.out.print("Enter the phone number of the customer: ");
                int customerPhone = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Enter the date of the invoice: ");
                String invoiceDate = sc.nextLine();
                
                System.out.print("Enter the number of items: ");
                int numberOfItems = sc.nextInt();
                
                System.out.print("Enter the total amount: ");
                double totalAmount = sc.nextDouble();
                sc.nextLine();
                
                System.out.print("Enter the paid amount: ");
                double paidAmount = sc.nextDouble();
                sc.nextLine();
                
                System.out.print("Enter the balance: ");
                double balance = sc.nextDouble();
                sc.nextInt();
                
                mainShop.addInvoice(customerName, customerPhone, invoiceDate, numberOfItems, totalAmount, paidAmount, balance);
                break;
            case 4:
                fourthOptionCounter++;
                System.out.println("The number of items: " + mainShop.products.size());
                System.out.println("The number of invoices: " + mainShop.invoices.size());
                System.out.println("The total number of sales: " + mainShop.totalSales());
                break;
            case 5:
                fifthOptionCounter++;
                mainShop.printInvoices();
                break;
            case 6:
                sixthOptionCounter++;
                System.out.print("Enter the invoice number you want to search: ");
                int searchedInvoice = sc.nextInt();
                sc.nextLine();
                mainShop.printSingleInvoice(searchedInvoice);
                break;
            case 7:
                seventhOptionCounter++;
                System.out.println("First option: " + firstOptionCounter);
                System.out.println("Second option: " + secondOptionCounter);
                System.out.println("Third option: " + thirdOptionCounter);
                System.out.println("Fourth option: " + fourthOptionCounter);
                System.out.println("Fifth option: " + fifthOptionCounter);
                System.out.println("Sixth option: " + sixthOptionCounter);
                System.out.println("Seventh option: " + seventhOptionCounter);
                break;
            case 8:
                System.out.println("Are you sure you want to exit?");
                String userResponse = sc.nextLine();
                
                if (userResponse.contains("Yes") || userResponse.contains("yes")) {
                    System.out.println("Program Ended!");
                    programEnded = true;
                }
                break;
            }
        }

    }
}
