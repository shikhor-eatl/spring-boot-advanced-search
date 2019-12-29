package com.example.springbootadvancedsearch.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String color;

    private String model;

    @Column(name = "creationyear")
    private Integer creationyear;

    private String brand;

    private Integer price;

    @JoinColumn(name = "options_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Options options;

    private Boolean isDeleted;

    private Instant createdAt = Instant.now();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCreationyear() {
        return creationyear;
    }

    public void setCreationyear(Integer creationYear) {
        this.creationyear = creationYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Object getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}