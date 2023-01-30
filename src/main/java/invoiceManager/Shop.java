package invoiceManager;

import java.util.ArrayList;

public class Shop {
    public String shopName;
    public int tel;
    public int fax;
    public String email;
    public String website;
    public ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    public ArrayList<Product> products = new ArrayList<Product>();
    
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    public void setInvoiveHeader(int tel, int fax, String email, String website) {
        this.tel = tel;
        this.fax = fax;
        this.email = email;
        this.website = website;
    }
    public void loadData() {
        System.out.println("There are "+ invoices.size() + " invoices and " + products.size() + " products.");
    }
}
