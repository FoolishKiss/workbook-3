package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SearchInventoryApp {
    public static void main(String[] args) {
        //stores the converted data from file to array list called inventory
        ArrayList<Product> inventory = getInventory("inventory.csv");

        //if the file wasn't found or empty
        if (inventory.isEmpty()) {
            System.out.println("No inventory loaded.");
        } else {
            System.out.println("Store Inventory:");
            //loop through each item in the list and prints  out the formated line
            for (Product product : inventory) {
                System.out.printf("ID: %d | %s | $%.2f\n",
                        product.getId(), product.getName(), product.getPrice());
            }
        }
    }

    // method to return a list of products
    public static ArrayList<Product> getInventory(String fileName) {
        ArrayList<Product> inventory = new ArrayList<>();

        // made variable inventoryList 
        String inventoryList = "src/main/resources/" + fileName;

        try (BufferedReader csvReader = new BufferedReader(new FileReader(inventoryList))) {
            String line;

            while ((line = csvReader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    float price = Float.parseFloat(parts[2]);

                    Product product = new Product(id, name, price);
                    inventory.add(product);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }

        return inventory;
    }
}
