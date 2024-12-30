package com.fit.nlu.DHHCeramic.model;

import java.util.Date;

public class ProductImport {
    private int id;
    private Product product;
    private int quantity;
    private Date createdAt;
    private long price;
    private int importBatch;

    public ProductImport(int id, Product product, int quantity, Date createdAt, long price, int importBatch) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.price = price;
        this.importBatch = importBatch;
    }

    public ProductImport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getImportBatch() {
        return importBatch;
    }

    public void setImportBatch(int importBatch) {
        this.importBatch = importBatch;
    }

    @Override
    public String toString() {
        return "ProductImport{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", createdAt=" + createdAt +
                ", price=" + price +
                ", importBatch=" + importBatch +
                '}';
    }
}
