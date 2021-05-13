package com.example.demo;

import java.io.Serializable;

    public class Order implements Serializable {
        private int id;
        private String itemName ;
        private int quantity;
        private float price ;
        private String customerName;

        public Order() {
            super();
        }

        public Order(int id, String itemName, int quantity, float price, String customerName) {
            this.id = id;
            this.itemName = itemName;
            this.quantity = quantity;
            this.price = price;
            this.customerName = customerName;
        }

        public String getCustomer_name() {
            return customerName;
        }

        public void setCustomer (String customer) {
            this.customerName = customer;
        }
        public Order(int id, String itemName) {
            this.id = id;
            this.itemName = itemName;

        }
        public String getName() {
            return itemName;
        }

        public void setName(String itemName) {
            this.itemName =itemName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public float getPrice () {
            return price;
        }

        public void setPrice (float price) {
            this.price= price;
        }

        public int getQuantity () {
            return quantity;
        }

        public void setQuantity (int quantity) {
            this.quantity= quantity;
        }

        @Override
        public String toString() {
            return "MyMessage [id=" + id + "itemName = " + itemName + "price= " + price + "quantity=" + quantity + "customerName = "
                    + customerName+"]";

        }
    }

