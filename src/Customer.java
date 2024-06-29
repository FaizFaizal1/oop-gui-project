import java.sql.Date;
import java.sql.Timestamp;

public class Customer {
    private int customerId;
    private String customerName;
    private String trackingNumber;
    private Date date;

    public Customer() {
        customerId = 0;
        customerName = null;
        trackingNumber = null;
        date = null;
    }

    public Customer(int customerId, String customerName, String trackingNumber, Date date) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.trackingNumber = trackingNumber;
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

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
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
                ", trackingNumber='" + trackingNumber + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}


