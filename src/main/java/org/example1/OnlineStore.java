package org.example1;

import java.lang.Exception;
import java.util.ArrayList;

class OnlineStore {
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;

    public OnlineStore() {
        customers = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Order makePurchase(Customer customer, Product product, int quantity) throws NonExistentCustomerException, NonExistentProductException, NegativeQuantityException {
        if (!customers.contains(customer)) {
            throw new NonExistentCustomerException();
        }

        if (!products.contains(product)) {
            throw new NonExistentProductException();
        }

        if (quantity < 0) {
            throw new NegativeQuantityException();
        }

        Order order = new Order(customer, product, quantity);
        orders.add(order);

        return order;
    }

    public int getTotalPurchases() {
        return orders.size();
    }

    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();

        // Create customers
        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");

        // Create products
        Product product1 = new Product("Product 1", 100.0);
        Product product2 = new Product("Product 2", 50.0);

        // Add customers and products to the store
        store.addCustomer(customer1);
        store.addCustomer(customer2);
        store.addProduct(product1);
        store.addProduct(product2);

        try {
            // Make purchases
            store.makePurchase(customer1, product1, 3);
            store.makePurchase(customer2, product2, 2);

            // Attempt to make a purchase with an error (negative quantity)
            store.makePurchase(customer1, product1, 2);
        } catch (NonExistentCustomerException | NonExistentProductException | NegativeQuantityException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Print the total number of completed purchases
        System.out.println("Total number of completed purchases: " + store.getTotalPurchases());
    }
}

