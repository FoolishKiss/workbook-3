package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SearchInventoryApp {
    public static void main(String[] args) {
        //stores the converted data from file to array list called inventory
        ArrayList<Product> inventory = getInventory("inventory.csv");

        //checks if the file wasn't found or empty
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

    // method to return a list of products that takes a file name
    public static ArrayList<Product> getInventory(String fileName) {
        //make a new array list to hold products
        ArrayList<Product> inventory = new ArrayList<>();

        // made variable inventoryList that has the file path
        String inventoryList = "src/main/resources/" + fileName;

        //uses try with resources (buffered reader), closes the file after
        try (BufferedReader csvReader = new BufferedReader(new FileReader(inventoryList))) {
            //stores each line from the file
            String line;

            //loop reads each line until the end
            while ((line = csvReader.readLine()) != null) {

                //splits line into parts by |
                String[] parts = line.split("\\|");

                // checks if we have all three parts
                if (parts.length == 3) {

                    //converts the string into parsed parts
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    float price = Float.parseFloat(parts[2]);

                    // creates a new product using the parsed parts
                    Product product = new Product(id, name, price);
                    //adds the product to the inventory list
                    inventory.add(product);
                }
            }
          // catches any file errors
        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }
        // returns the completed list of products to main method
        return inventory;
    }
}
