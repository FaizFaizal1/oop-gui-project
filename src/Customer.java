import java.sql.Date;

public class Customer {
    private int customerId;
    private String customerName;
    private String parcelID;
    private Date date;

    public Customer() {
        customerId = 0;
        customerName = null;
        parcelID = null;
        date = null;
    }

    public Customer(int customerId, String customerName, String parcelID, Date date) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.parcelID = parcelID;
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getParcelID() {
        return parcelID;
    }

    public void setParcelID(String parcelID) {
        this.parcelID = parcelID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", parcelID='" + parcelID + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}


