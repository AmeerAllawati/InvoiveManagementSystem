package invoiceManager;

public class MenuItems {

    public int id;
    public String menuText;
    public Menu subMenu = null;
    
    public MenuItems(int id, String menuText) {
        // TODO Auto-generated constructor stub
        this.id = id;
        this.menuText = menuText;
    }
    
    public void setAsMenu(Menu newMenu) {
        this.subMenu = newMenu;
    }
    
    public boolean isAMenu() {
        return subMenu != null;
    }
    
    public void printItem() {
        System.out.println(id + "- " + menuText);
        if (this.isAMenu()) {
            subMenu.printSubMenu();
        }
    }

    public void printSubItem() {
        // TODO Auto-generated method stub
        System.out.println("    "+id + "- " + menuText);
        if (this.isAMenu()) {
            subMenu.printSubMenu();
        }
    }
}
