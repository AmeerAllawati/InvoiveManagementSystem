package invoiceManager;

public class Product {

    private int id;
    private String name;
    private double unitPrice;
    private int quantity;
    private double qtyAmountPP;
    
    public Product(int id, String name, double unitPrice, int quantity) {
        // TODO Auto-generated constructor stub
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void setQtyAmountPP(double qtyAmountPP) {
        this.qtyAmountPP = qtyAmountPP;
    }
    
    public int getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getUnitPrice() {
        return this.unitPrice;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public double getQtyAmountPP() {
        return this.qtyAmountPP;
    }
}
