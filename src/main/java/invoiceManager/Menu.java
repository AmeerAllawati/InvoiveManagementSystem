package invoiceManager;

import java.util.ArrayList;

public class Menu {
    public String menuName;
    public ArrayList<MenuItems> menuItems = new ArrayList<MenuItems>();
    
    public Menu(String menuName, MenuItems newItem) {
        // TODO Auto-generated constructor stub
        menuItems.add(newItem);
        this.menuName = menuName;
    }
    
    public void addItem(int id, String menuName) {
        menuItems.add(new MenuItems(id, menuName));
    }

    public void printMenu() {
        // TODO Auto-generated method stub
        System.out.println(menuName);
        for (MenuItems items : menuItems) {
            items.printItem();
        }
    }

    public void printSubMenu() {
        // TODO Auto-generated method stub
        for (MenuItems items : menuItems) {
            items.printSubItem();
        }
    }
}
