import java.util.HashMap;

public class InventoryManagement {

    private HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
    }

    public void updateProduct(int id, int quantity, double price) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = quantity;
            p.price = price;
        }
    }

    public void deleteProduct(int id) {
        inventory.remove(id);
    }

    public void displayProducts() {
        inventory.values().forEach(System.out::println);
    }

    public static void main(String[] args) {
        InventoryManagement ims = new InventoryManagement();

        ims.addProduct(new Product(1, "Laptop", 10, 50000));
        ims.addProduct(new Product(2, "Mouse", 20, 500));

        ims.updateProduct(1, 15, 52000);
        ims.deleteProduct(2);

        ims.displayProducts();
    }
}