public class Orders {
    String OrderId;
    String phoneNumber;
    int qty;
    String size;
    double amount;
    int status;

    public Orders(String orderId, String phoneNumber, int qty, String size, double amount, int status) {
        OrderId = orderId;
        this.phoneNumber = phoneNumber;
        this.qty = qty;
        this.size = size;
        this.amount = amount;
        this.status = status;
    }
}