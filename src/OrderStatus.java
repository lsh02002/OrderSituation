public enum OrderStatus {
    PAID("PAID"), NOT_PAID("NOT_PAID"), SHIPPED("SHIPPED"), ON_ORDER("ON_ORDER"), DELIVERED("DELIVERED");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
