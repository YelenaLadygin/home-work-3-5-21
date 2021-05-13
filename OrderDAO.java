package com.example.demo;
import java.sql.*;
import java.util.ArrayList;

public class OrderDAO {

        private String m_conn;

        public OrderDAO(String m_conn) {
            this.m_conn = m_conn;
        }

        public void insertOrder(Order c) {
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                if (conn != null) {

                    String sql = String.format("INSERT INTO orders (itemName,quantity,price,customerName) " +
                            "VALUES ( '%s', %d,%f, %s )", c.getName(), c.getQuantity(),c.getPrice(), c.getCustomer_name());
                    Statement stmt = conn.createStatement();

                    stmt.executeUpdate(sql);
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void updateOrder(Order c, int ID) {
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                if (conn != null) {
                    String sql = String.format(
                            "UPDATE orders set itemName = '%s', quantity = %d, customerName= %s " +
                                    " WHERE id = %d"
                            , c.getName(), c.getQuantity(), c.getCustomer_name(),ID);
                    Statement stmt = conn.createStatement();

                    stmt.executeUpdate(sql);
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void deleteOrder(int id) {
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                if (conn != null) {
                    String sql = String.format("DELETE from orders where id = " + id);
                    Statement stmt = conn.createStatement();

                    stmt.executeUpdate(sql);
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }



        public ArrayList<Order> getAllOrders(){

            ArrayList<Order> orders = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(m_conn)) {

                if (conn != null) {

                    String sql = "SELECT * FROM orders";

                    Statement stmt = conn.createStatement();

                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        Order e = new Order(
                                rs.getInt("id"),
                                rs.getString("itemName"),
                                rs.getInt("quantity"),
                                rs.getFloat("price"),
                                rs.getString("customerName"));
                        orders.add(e);
                    }
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return  orders;
        }

        public Order getOrderById(int id){
            // try to connect to db
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                // check if connection succeed
                if (conn != null) {

                    // prepare query string
                    String sql = String.format("Select * from orders where id= %d", id );

                    // prepare statement
                    Statement stmt = conn.createStatement();

                    // fire query
                    ResultSet rs = stmt.executeQuery(sql);

                    // read results
                    while (rs.next()) {
                       Order e = new Order(
                                rs.getInt("id"),
                                rs.getString("itemName"),
                                rs.getInt("quantity"),
                                rs.getFloat("price"),
                                rs.getString("customerName"));
                        return e;
                    }
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return null;

        }
}

