/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inclassex1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class InclassEX1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Example usage
        Item item1 = new Item(1, 10.0);
        Item item2 = new Item(2, 20.0);

        Order order = new Order(1, new Date());
        order.addItem(item1);
        order.addItem(item2);

        Payment payment = new CashMethod(30.0, "USD");
        order.setPayment(payment);

        Customer customer = new Customer(1, "John Doe", "john.doe@example.com");
        customer.addOrder(order);

        // Print customer details
        System.out.println(customer);
    }
    
}

class Item {
    private int itemID;
    private double price;

    public Item(int itemID, double price) {
        this.itemID = itemID;
        this.price = price;
    }

    public int getItemID() {
        return itemID;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" + "itemID=" + itemID + ", price=" + price + '}';
    }
}

class Order {
    private int orderID;
    private Date date;
    private List<Item> items;
    private Payment payment;

    public Order(int orderID, Date date) {
        this.orderID = orderID;
        this.date = date;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getOrderID() {
        return orderID;
    }

    public Date getDate() {
        return date;
    }

    public List<Item> getItems() {
        return items;
    }

    public Payment getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", date=" + date + ", items=" + items + ", payment=" + payment + '}';
    }
}

abstract class Payment {
    protected double amount;
    protected String currency;

    public Payment(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Payment{" + "amount=" + amount + ", currency=" + currency + '}';
    }
}

class CashMethod extends Payment {
    public CashMethod(double amount, String currency) {
        super(amount, currency);
    }
}

class CheckMethod extends Payment {
    public CheckMethod(double amount, String currency) {
        super(amount, currency);
    }
}

class CreditMethod extends Payment {
    public CreditMethod(double amount, String currency) {
        super(amount, currency);
    }
}

class Customer {
    private int customerID;
    private String name;
    private String email;
    private List<Order> orders;

    public Customer(int customerID, String name, String email) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", name=" + name + ", email=" + email + ", orders=" + orders + '}';
    }
}
