package com.fit.nlu.DHHCeramic.model;


public class OrderDetails {
    private String id;
    private int quantity;
    private long unitPrice;
    private Product product;
    private Order order;
    private String size;

    public OrderDetails() {
        super();
    }

    public OrderDetails(String id, int quantity, long unitPrice, Product product, Order order, String size) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.product = product;
        this.order = order;
        this.size = size;
    }

    public OrderDetails(int quantity, String size, Product product) {
        this.quantity = quantity;
        this.product = product;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id='" + id + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", product=" + product +
                ", order=" + order +
                ", size='" + size + '\'' +
                '}';
    }
}
