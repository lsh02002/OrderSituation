import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public final class Order {
    private final int id;
    private final Customer customer;
    private final LocalDate orderDate;
    private final OrderStatus orderStatus;
    private final List<OrderItem> orderItems;

    public Order(int id, Optional<Customer> customer, LocalDate orderDate, OrderStatus orderStatus, Optional<List<OrderItem>> orderItems) {
        this.id = id;
        this.customer = customer.orElse(null);
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderItems = orderItems.orElse(null);
    }

    public String getOrderStatus() {
        if (orderStatus.getStatus().equals("PAID")) {
            return "주문 완료";
        } else if (orderStatus.getStatus().equals("SHIPPED")) {
            return "배송 완료";
        } else if (orderStatus.getStatus().equals("DELIVERED")) {
            return "배송 완료";
        } else {
            return "주문 처리 중";
        }
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Customer getCustomer() {return customer;}
}
