import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    public static ECommerceProduct linearSearch(ECommerceProduct[] products, String name) {
        for (ECommerceProduct p : products) {
            if (p.productName.equalsIgnoreCase(name))
                return p;
        }
        return null;
    }

    public static ECommerceProduct binarySearch(ECommerceProduct[] products, String name) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int cmp = products[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {

        ECommerceProduct[] products = {
                new ECommerceProduct(1, "Laptop", "Electronics"),
                new ECommerceProduct(2, "Mouse", "Electronics"),
                new ECommerceProduct(3, "Phone", "Electronics")
        };

        System.out.println(linearSearch(products, "Mouse"));

        Arrays.sort(products,
                Comparator.comparing(p -> p.productName));

        System.out.println(binarySearch(products, "Phone"));
    }
}