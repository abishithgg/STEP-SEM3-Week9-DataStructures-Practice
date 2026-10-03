package P1_LibraryCatalogLookup;

import java.util.*;

public class LibraryCatalogLookup {

    static String findBook(List<String[]> catalog, String targetIsbn) {

        int left = 0;
        int right = catalog.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            String isbn = catalog.get(mid)[0];

            int comparison = isbn.compareTo(targetIsbn);

            if (comparison == 0) {
                return catalog.get(mid)[1];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {

        List<String[]> catalog = new ArrayList<>();

        catalog.add(new String[]{"0001112223", "Introduction to Algebra"});
        catalog.add(new String[]{"0002223334", "Beginning Python"});
        catalog.add(new String[]{"0003334445", "Classic Mythology"});
        catalog.add(new String[]{"0004445556", "Data and Society"});
        catalog.add(new String[]{"0005556667", "European History"});

        System.out.println(findBook(catalog, "0003334445"));
        System.out.println(findBook(catalog, "0009998887"));
    }
}
