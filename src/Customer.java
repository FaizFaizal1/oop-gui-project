public class Customer {
    private String customerId;
    private String customerName;
    private String trackingNumber;
    private String date;

    public Customer() {
        customerId = null;
        customerName = null;
        trackingNumber = null;
        date = null;
    }

    public Customer(String customerId, String customerName, String trackingNumber, String date) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.trackingNumber = trackingNumber;
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}


