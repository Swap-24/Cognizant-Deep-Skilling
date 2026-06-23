class ECommerceProduct {
    int productId;
    String productName;
    String category;

    public ECommerceProduct(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}
