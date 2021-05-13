package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Iterator;
import java.util.ArrayList;

@RestController
    public class OrderController {
        private static OrderDAO orderDAO = new OrderDAO("jdbc:sqlite:C:\\Users\\yelena\\130521.db");


        @GetMapping("/order")
        public ArrayList<Order> getOrders(){
            ArrayList<Order> orders = orderDAO.getAllOrders();
            return orders;
        }

        @GetMapping("/order/{ID}")
        public Order getOrderById(@PathVariable("ID") int ID)
        {
            Order order = orderDAO.getOrderById(ID);
            return order;
        }

        @PostMapping("/order")
        public void addOrder(@RequestBody Order c)
        {
            orderDAO.insertOrder(c);
        }

        @PutMapping("/order/{ID}")
        public void updateOrder(@PathVariable("ID") int ID, @RequestBody Order update_c)
        {
            orderDAO.updateOrder(update_c, ID);
        }

        @DeleteMapping("/order/{ID}")
        public void delOrderById(@PathVariable("ID") int ID)
        {
            orderDAO.deleteOrder(ID);
        }

    }
