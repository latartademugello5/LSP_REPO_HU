package org.howard.edu.lsp.assignment2;

public class Product {
    private int productId;
    private String name;
    private double price;
    private String category;
    private String priceRange;

    public Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.priceRange = determinePriceRange(price);
    }

    // Method to determine price range
    private String determinePriceRange(double price) {
        if (price <= 10) return "Low";
        else if (price <= 100) return "Medium";
        else if (price <= 500) return "High";
        else return "Premium";
    }

    // Apply transformation rules
    public void transform() {
        name = capitalizeWords(name);
        if (category.equals("Electronics")) {
            price *= 0.9; // Apply 10% discount
            price = Math.round(price * 100.0) / 100.0; // Round to 2 decimals
        }
        if (price > 500) {
            category = "Premium Electronics";
        }
    }

    // Capitalize first letter of each word
    private String capitalizeWords(String str) {
        String[] words = str.toLowerCase().split(" ");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            capitalized.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        return capitalized.toString().trim();
    }

    @Override
    public String toString() {
        return productId + "," + name + "," + price + "," + category + "," + priceRange;
    }
}

