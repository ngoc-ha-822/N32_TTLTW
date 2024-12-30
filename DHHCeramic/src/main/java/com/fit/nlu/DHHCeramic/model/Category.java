package com.fit.nlu.DHHCeramic.model;

import java.io.Serializable;

public class Category extends BaseModel implements Serializable {
    private String name;
    private int status;

    public Category(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public Category() {
        super();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
