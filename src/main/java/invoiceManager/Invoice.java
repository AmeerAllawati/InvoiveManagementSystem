package invoiceManager;

public class Invoice {
    public String customerName;
    public int customerPhone;
    public String invoiceDate;
    public int numberOfItems;
    public double totalAmount;
    public double paidAmount;
    public double balance;
    public static int numOfInvoices = 0;
    
    public Invoice(String customerName, int customerPhone, String invoiveDate, int numberOfItems, double totalAmount, double paidAmount, 
            double balance) {

        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.invoiceDate = invoiveDate;
        this.numberOfItems = numberOfItems;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.balance = balance;
        numOfInvoices++;
    }
}
