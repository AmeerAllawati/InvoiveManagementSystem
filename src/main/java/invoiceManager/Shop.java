package invoiceManager;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Shop {
    public String shopName;
    public int tel;
    public int fax;
    public String email;
    public String website;
    public ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    public ArrayList<Product> products = new ArrayList<Product>();
    
    public void addProduct(int id, String name, double unitPrice, int quantity) {
        products.add(new Product(id, name, unitPrice, quantity));
        saveData(true);
    }
    
    public void deleteProduct(int id) {
        for(int i = 0; i < products.size(); ++i) {
            if (products.get(i).getID() == id) {
                products.remove(i);
            }
        }
        saveData(false);
    }
    
    public void setShopName(String shopName) {
        this.shopName = shopName;
        saveData(false);
    }
    public void setInvoiveHeader(int tel, int fax, String email, String website) {
        this.tel = tel;
        this.fax = fax;
        this.email = email;
        this.website = website;
        saveData(false);
    }
    public void loadData() {
        // TODO: Change loading the data so that it loads the information from a file
        System.out.println("There are "+ invoices.size() + " invoices and " + products.size() + " products.");
    }
    public void saveData(boolean append) {
//        Gson gson = new Gson();
//        String output = gson.toJson(this);
//        System.out.print(output);
    }
}
