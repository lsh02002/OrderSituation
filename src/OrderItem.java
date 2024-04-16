public class OrderItem {
    private final int itemId;
    private final String itemName;
    private final double price;
    private final int quantity;

    public OrderItem(int itemId, String itemName, double price, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}
