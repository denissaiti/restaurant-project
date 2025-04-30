import java.util.ArrayList;
import java.util.List;
public class meny {
    public List<String> items;
    public List<String> categories;
    public List<Double> prices;

    public meny() {
        items = new ArrayList<>();
        categories = new ArrayList<>();
        prices = new ArrayList<>();
    }

    public void addItem(String item, String category, double price) {
        items.add(item);
        categories.add(category);
        prices.add(price);
    }

    public String getItem(int index) {
        return items.get(index);
    }

    public String getCategory(int index) {
        return categories.get(index);
    }

    public double getPrice(int index) {
        return prices.get(index);
    }

    public double getPriceByItemName(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equalsIgnoreCase(itemName)) {
                return prices.get(i);
            }
        }
        return -1;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (double price : prices) {
            totalPrice += price;
        }
        return totalPrice;
    }

    public void printItemsByCategory(String categoryName) {
        boolean categoryExists = false;
        int categoryIndex = 1;
        System.out.println("Category: " + categoryName);
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).equalsIgnoreCase(categoryName)) {
                if (categoryExists == false) {
                    categoryExists = true;
                }
                String item = items.get(i);
                double price = prices.get(i);
                System.out.println("Item " + categoryIndex + ": " + item + " - Price: $" + price);
                categoryIndex++;
            }
        }
        if (!categoryExists) {
            System.out.println("No items found in the category: " + categoryName);
        }
    }
}