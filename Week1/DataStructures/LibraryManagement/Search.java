
import java.util.Arrays;
import java.util.Comparator;

public class Search {

    public static Book linearSearch(Book[] books,
                                    String title) {

        for (Book book : books) {

            if (book.title.equalsIgnoreCase(title))
                return book;
        }

        return null;
    }

    public static Book binarySearch(Book[] books,
                                    String title) {

        int left = 0;
        int right = books.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int cmp =
                books[mid].title.compareToIgnoreCase(title);

            if (cmp == 0)
                return books[mid];

            if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "The Alchemist", "Paulo Coelho"),
                new Book(2, "Clean Code", "Robert C. Martin"),
                new Book(3, "Atomic Habits", "James Clear")
        };

        System.out.println("Linear search result:");
        System.out.println(linearSearch(books, "Clean Code"));

        Arrays.sort(books, Comparator.comparing(book -> book.title));

        System.out.println("\nBinary search result:");
        System.out.println(binarySearch(books, "The Alchemist"));
    }
}
