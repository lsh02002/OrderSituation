import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
// 1. 고객 생성합니다.
        Customer customer1 = new Customer("John Doe", 30, "male");
        Customer customer2 = new Customer("Jane Smith", 28, "female");
        Customer customer3 = new Customer("Jane ho", 23, "MALE");
        Customer customer4 = new Customer("Bob", 21, "FEMALE");

// 2. 주문 아이템을 만듭니다.
        OrderItem item1 = new OrderItem(1, "Keyboard", 35.99, 2);
        OrderItem item2 = new OrderItem(2, "Mouse", 19.99, 3);
        OrderItem item3 = new OrderItem(3, "Monitor", 149.99, 1);

        // 3. 주문 ItemList 제작합니다.
        List<OrderItem> orderItems1 = new ArrayList<>();
        orderItems1.add(item1);
        orderItems1.add(item2);
        orderItems1.add(item3);

        List<OrderItem> orderItems2 = new ArrayList<>();
        orderItems2.add(item1);
        orderItems2.add(item3);

        // 4. 주문 List를 만듭니다.
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1001, Optional.ofNullable(customer1), LocalDate.parse("2023-11-09", DateTimeFormatter.ISO_DATE), OrderStatus.valueOf("PAID"), Optional.ofNullable(orderItems1)));
        orders.add(new Order(1002, Optional.ofNullable(null), LocalDate.parse("2023-11-09", DateTimeFormatter.ISO_DATE), OrderStatus.valueOf("SHIPPED"), Optional.ofNullable(orderItems2)));
        orders.add(new Order(1003, Optional.ofNullable(customer3), LocalDate.parse("2023-11-09", DateTimeFormatter.ISO_DATE), OrderStatus.valueOf("SHIPPED"), Optional.ofNullable(orderItems2)));
        orders.add(new Order(1004, Optional.ofNullable(customer2), LocalDate.parse("2023-11-09", DateTimeFormatter.ISO_DATE), OrderStatus.valueOf("ON_ORDER"), Optional.ofNullable(null)));
        orders.add(new Order(1005, Optional.ofNullable(customer4), LocalDate.parse("2023-11-09", DateTimeFormatter.ISO_DATE), OrderStatus.valueOf("NOT_PAID"), Optional.ofNullable(null)));
        orders.add(new Order(1006, Optional.ofNullable(customer1), LocalDate.parse("2023-11-09", DateTimeFormatter.ISO_DATE), OrderStatus.valueOf("SHIPPED"), Optional.ofNullable(orderItems2)));

        // 5. 오늘 주문 수 및 정산 진행합니다.
        double totalRevenue = 0;
        int totalOrderCount = 0;

        for (Order order : orders) {
            try {
                if (order.getCustomer() == null) throw new RuntimeException("고객이 누락 되었습니다.");
                if (order.getOrderStatus().equals("주문 처리 중"))
                    throw new RuntimeException(order.getCustomer() + "님의 주문이 아직 주문 처리 중입니다.");
                if (order.getOrderItems() == null)
                    throw new RuntimeException(order.getCustomer() + "님의 주문 아이템들이 누락 되었습니다.");

                totalOrderCount++;

                for (OrderItem orderItem : order.getOrderItems()) {
                    totalRevenue += orderItem.getTotalPrice();
                }

            } catch (RuntimeException e) {
                System.out.println(e.getMessage() + " 문제로 해당 주문은 SKIP 합니다.");
            }
        }
        System.out.println("오늘 총 " + totalOrderCount + " 주문을 처리 하여 " + totalRevenue + " 수익을 올렸습니다.");
    }
}
