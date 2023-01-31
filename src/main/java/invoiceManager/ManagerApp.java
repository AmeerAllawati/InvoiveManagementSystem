package invoiceManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagerApp {

    public static void main(String[] args) {
        //Add main menu items
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

        //Initializing important variables
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

        // main program loop
        while(!programEnded) { 
            mainMenu.printMenu();


            //User input for the main menu

            while(true) {
                try {
                    System.out.print("Please enter your choice: ");
                    mainMenuUserInput = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("Invalid input, try again");
                    sc.nextLine();
                }
            }

            switch(mainMenuUserInput) {
            // if user chose 1 in the main menu
            case 1:
                firstOptionCounter++;
                mainMenu.menuItems.get(0).printItem();
                int shopSettingsUserInput = 0;
                while(true) {
                    try {
                        System.out.print("Please enter your choice: ");
                        shopSettingsUserInput = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Invalid input, try again");
                        sc.nextLine();
                    }
                }

                switch(shopSettingsUserInput) {
                case 1:
                    mainShop.loadData(); //TODO: This needs to be changed, loading the data should read from a file.
                    break;
                case 2:
                    String newShopName = null;
                    while(true) {
                        try {
                            System.out.print("Please enter the new shop name: ");
                            newShopName = sc.nextLine();
                            break;
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Invalid input, try again");
                            sc.nextLine();
                        }
                    }
                    mainShop.setShopName(newShopName);
                    //System.out.print(mainShop.shopName);
                    break;
                case 3:
                    int newPhone = 0;
                    while(true) {
                        try {
                            System.out.print("Enter the new phone number: ");
                            newPhone = Integer.parseInt(sc.nextLine());
                            break;
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Invalid input, try again");
                            sc.nextLine();
                        }
                    }
                    //sc.nextLine();

                    int newFax = 0;
                    while(true) {
                        try {
                            System.out.print("Enter the new fax number: ");
                            newFax = Integer.parseInt(sc.nextLine());
                            break;
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Invalid input, try again");
                            sc.nextLine();
                        }
                    }

                    //sc.nextLine();

                    String newEmail = null;
                    while(true) {
                        try {
                            System.out.print("Enter the new Email: ");
                            newEmail = sc.nextLine();
                            break;
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Invalid input, try again");
                            sc.nextLine();
                        }
                    }

                    String newWebsite = null;
                    while(true) {
                        try {
                            System.out.print("Enter the new website: ");
                            newWebsite = sc.nextLine();
                            break;
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Invalid input, try again");
                            sc.nextLine();
                        }
                    }


                    mainShop.setInvoiveHeader(newPhone, newFax, newEmail, newWebsite);
                    break;
                case 4:
                    continue;
                default:
                    System.out.println("Invalid input");
                }
                break;
            // if user chose 2 in the main menu
            case 2:
                secondOptionCounter++;
                mainMenu.menuItems.get(1).printItem();
                
                int manageShopUserInput = 0;
                while(true) {
                    try {
                        System.out.print("Please enter your choice: ");
                        manageShopUserInput = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Invalid input, try again");
                        sc.nextLine();
                    }
                }
                
                switch(manageShopUserInput) {
                case 1: 
                    int productId = 0;
                    while(true) {
                        try {
                            System.out.print("Enter the product ID: ");
                            productId = sc.nextInt();
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Invalid input, try again");
                            sc.nextLine();
                        }
                    }
                    
                    String productName = null;
                    while(true) {
                        try {
                            System.out.print("Enter the product name: ");
                            productName = sc.nextLine();
                            break;
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Invalid input, try again");
                            sc.nextLine();
                        }
                    }
                    
                    double productUnitPrice = 0;
                    while(true) {
                        try {
                            System.out.print("Enter the product unit price: ");
                            productUnitPrice = sc.nextDouble();
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Invalid input, try again");
                            sc.nextLine();
                        }
                    }
                    
                    int productQuantity =0;
                    while(true) {
                        try {
                            System.out.print("Enter the product quantity: ");
                            productQuantity = sc.nextInt();
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Invalid input, try again");
                            sc.nextLine();
                        }
                    }
                    

                    mainShop.addProduct(productId, productName, productUnitPrice, productQuantity);
                    break;
                case 2:
                    int deletedId = 0;
                    while(true) {
                        try {
                            System.out.print("Enter the product ID you want to delete: ");
                            deletedId = sc.nextInt();
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Invalid input, try again");
                            sc.nextLine();
                        }
                    }
                    

                    mainShop.deleteProduct(deletedId);
                    break;
                case 3:
                    int productToModifyId = 0;
                    while(true) {
                        try {
                            System.out.print("Enter the product ID you want to change the price of: ");
                            productToModifyId = sc.nextInt();
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Invalid input, try again");
                            sc.nextLine();
                        }
                    }
                    
                    double newProductPrice = 0;
                    while(true) {
                        try {
                            System.out.print("Enter the new price of the mentioned product: ");
                            newProductPrice = sc.nextDouble();
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println("Invalid input, try again");
                            sc.nextLine();
                        }
                    }
                    

                    mainShop.changeItemPrice(productToModifyId, newProductPrice);;
                    break;
                case 4:
                    mainShop.printProducts();
                    break;
                case 5: 
                    continue;
                default:
                    System.out.println("Invalid Input");
                }
                break;
            // if user chose 3 in the main menu
            case 3:
                thirdOptionCounter++;
                // take user input for a new invoice
                String customerName = null;
                while(true) {
                    try {
                        System.out.print("Enter the name of the customer: ");
                        customerName = sc.nextLine();
                        break;
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Invalid input, try again");
                        sc.nextLine();
                    }
                }
                

                int customerPhone = 0;
                while(true) {
                    try {
                        System.out.print("Enter the phone number of the customer: ");
                        customerPhone = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Invalid input, try again");
                        sc.nextLine();
                    }
                }
                
                String invoiceDate = null;
                while(true) {
                    try {
                        System.out.print("Enter the date of the invoice: ");
                        invoiceDate = sc.nextLine();
                        break;
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Invalid input, try again");
                        sc.nextLine();
                    }
                }
                
                int numberOfItems = 0;
                while(true) {
                    try {
                        System.out.print("Enter the number of items: ");
                        numberOfItems = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Invalid input, try again");
                        sc.nextLine();
                    }
                }
                
                double totalAmount = 0;
                while(true) {
                    try {
                        System.out.print("Enter the total amount: ");
                        totalAmount = sc.nextDouble();
                        sc.nextLine();
                        break;
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Invalid input, try again");
                        sc.nextLine();
                    }
                }
                
                double paidAmount = 0;
                while(true) {
                    try {
                        System.out.print("Enter the paid amount: ");
                        paidAmount = sc.nextDouble();
                        sc.nextLine();
                        break;
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Invalid input, try again");
                        sc.nextLine();
                    }
                }
                
                double balance = 0;
                while(true) {
                    try {
                        System.out.print("Enter the balance: ");
                        balance = sc.nextDouble();
                        sc.nextLine();
                        break;
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Invalid input, try again");
                        sc.nextLine();
                    }
                }
                

                mainShop.addInvoice(customerName, customerPhone, invoiceDate, numberOfItems, totalAmount, paidAmount, balance);
                break;
            // if user chose 4 in the main menu
            case 4:
                fourthOptionCounter++;
                System.out.println("The number of items: " + mainShop.products.size());
                System.out.println("The number of invoices: " + mainShop.invoices.size());
                System.out.println("The total number of sales: " + mainShop.totalSales());
                break;
            // if user chose 5 in the main menu
            case 5:
                fifthOptionCounter++;
                mainShop.printInvoices();
                break;
            // if user chose 6 in the main menu
            case 6:
                sixthOptionCounter++;
                Integer searchedInvoice = 0;
                while(true) {
                    try {
                        System.out.print("Enter the invoice number you want to search: ");
                        searchedInvoice = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Invalid input, try again");
                        sc.nextLine();
                    }
                }
                
                mainShop.printSingleInvoice(searchedInvoice);
                break;
            // if user chose 7 in the main menu
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
            // if user chose 8 in the main menu
            case 8:
                
                System.out.println("Are you sure you want to exit?");
                String userResponse = sc.nextLine();

                if (userResponse.contains("Yes") || userResponse.contains("yes")) {
                    System.out.println("Program Ended!");
                    programEnded = true;
                }
                break;
            default:
                System.out.println("Invalid input");
            }
        }

    }
}
