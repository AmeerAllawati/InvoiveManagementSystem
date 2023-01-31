package invoiceManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;

public class Shop {
    public String shopName = null;
    public int tel;
    public int fax;
    public String email;
    public String website;
    public ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    public ArrayList<Product> products = new ArrayList<Product>();

    public void addInvoice(String customerName, int customerPhone, String invoiveDate, int numberOfItems, double totalAmount, double paidAmount, 
            double balance) {
        invoices.add(new Invoice(customerName, customerPhone, invoiveDate, numberOfItems, totalAmount, paidAmount, balance));
        saveData();
    }

    public void addProduct(int id, String name, double unitPrice, int quantity) {
        products.add(new Product(id, name, unitPrice, quantity));
        saveData();
    }

    public void deleteProduct(int id) {
        for(int i = 0; i < products.size(); ++i) {
            if (products.get(i).getID() == id) {
                products.remove(i);
            }
        }
        saveData();
    }

    public void changeItemPrice(int id, double newPrice) {
        products.get(id-1).setUnitPrice(newPrice);
        saveData();
    }

    public void printProducts() {
        for(Product singleProduct: products) {
            System.out.println("Product ID: " + singleProduct.getID() + ", Product name: " + singleProduct.getName() + 
                    ", Unit price: " + singleProduct.getUnitPrice() + ", Quantity: " + singleProduct.getQuantity());
        }
    }

    public void printInvoices() {
        for(int i = 0; i < invoices.size(); i++) {
            System.out.println("Invoice number: " + (i+1) + ", Invoice date: " + invoices.get(i).invoiceDate + 
                    ", Customer name: " + invoices.get(i).invoiceDate + ", Number of items: " + invoices.get(i).numberOfItems +
                    ", Total: " + invoices.get(i).totalAmount + ", Balance: " + invoices.get(i).balance);
        }
    }

    public void printSingleInvoice(int id) {
        System.out.println("Invoice number: " + (id) + ", Invoice date: " + invoices.get(id-1).invoiceDate + 
                ", Customer name: " + invoices.get(id-1).invoiceDate + ", Number of items: " + invoices.get(id-1).numberOfItems +
                ", Total: " + invoices.get(id-1).totalAmount + ", Balance: " + invoices.get(id-1).balance);
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
        saveData();
    }
    public void setInvoiveHeader(int tel, int fax, String email, String website) {
        this.tel = tel;
        this.fax = fax;
        this.email = email;
        this.website = website;
        saveData();
    }
    public void loadData() {
        // TODO: Change loading the data so that it loads the information from a file
        Gson gson = new Gson();
        try(BufferedReader reader = new BufferedReader(new FileReader("shopInfo.json"))) {
            Shop decerializedShop = gson.fromJson(reader, new TypeToken<Shop>(){}.getType());
            this.shopName = decerializedShop.shopName;
            this.tel = decerializedShop.tel;
            this.fax = decerializedShop.fax;
            this.email = decerializedShop.email;
            this.website = decerializedShop.website;
            this.invoices = decerializedShop.invoices;
            this.products = decerializedShop.products;
            
            System.out.println("Shop name:" + this.shopName);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public void saveData() {
        Gson gson = new Gson();
        String output = gson.toJson(this);
        System.out.print(output);
        
        try(FileWriter writer = new FileWriter("shopInfo.json")) {
            writer.write(output);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double totalSales() {
        double sales = 0;
        for(Invoice singleInvoice: invoices) {
            sales = sales + singleInvoice.totalAmount;
        }
        return sales;
    }
}
