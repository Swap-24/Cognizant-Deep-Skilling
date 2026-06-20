class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int id, String name, double price) {
        orderId = id;
        customerName = name;
        totalPrice = price;
    }

    @Override
    public String toString() {
        return orderId + " " + customerName + " " + totalPrice;
    }
}
