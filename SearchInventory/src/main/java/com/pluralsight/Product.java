package com.pluralsight;

public class Product {
        private int id;
        private String name;
        private float price;

        public Product(int id, String name, float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

    public Product(String part, String part1, String part2) {
    }

    public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public float getPrice() {
            return this.price;
        }


}
