package invoiceManager;

import java.util.ArrayList;

public class Menu {
    public String menuName;
    public ArrayList<MenuItems> menuItems = new ArrayList<MenuItems>();
    
    public Menu(String menuName, MenuItems newItem) {
        menuItems.add(newItem);
        this.menuName = menuName;
    }
    
    public void addItem(int id, String menuName) {
        menuItems.add(new MenuItems(id, menuName));
    }

    public void printMenu() {
        System.out.println(menuName);
        for (MenuItems items : menuItems) {
            items.printItem();
        }
    }

    public void printSubMenu() {
        for (MenuItems items : menuItems) {
            items.printSubItem();
        }
    }
}
