package invoiceManager;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Shop {
    public String shopName = "A";
    public int tel = 1;
    public int fax = 1;
    public String email = "E";
    public String website = "C";
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
    public void saveData() {
        Gson gson = new Gson();
        String output = gson.toJson(this);
        System.out.print(output);
    }
}
