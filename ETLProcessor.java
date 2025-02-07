package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

public class ETLProcessor {
    private static final String INPUT_FILE = "data/products.csv";
    private static final String OUTPUT_FILE = "data/transformed_products.csv";

    public static void main(String[] args) {
        List<Product> products = extractData();
        transformData(products);
        loadData(products);
    }

    // Extract: Read data from CSV file
    private static List<Product> extractData() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String name = values[1];
                double price = Double.parseDouble(values[2]);
                String category = values[3];

                products.add(new Product(id, name, price, category));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return products;
    }

    // Transform: Apply transformations
    private static void transformData(List<Product> products) {
        for (Product product : products) {
            product.transform();
        }
    }

    // Load: Write transformed data to new CSV file
    private static void loadData(List<Product> products) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            bw.write("ProductID,Name,Price,Category,PriceRange\n");
            for (Product product : products) {
                bw.write(product.toString() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}

