public class Order {
    private String customer;
    private int[] orderedItems;
    private final int capacity = 20;
    private double fee = 9.99;

    public Order(String customer, int[] orderedItems) {
        this.customer = customer;
        this.orderedItems = orderedItems;
    }

    public void charge(double fee) {
        this.fee = fee;
    }

    // Other methods can be added here

    public String getCustomer() {
        return customer;
    }

    public int[] getOrderedItems() {
        return orderedItems;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getFee() {
        return fee;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setOrderedItems(int[] orderedItems) {
        this.orderedItems = orderedItems;
    }
}
