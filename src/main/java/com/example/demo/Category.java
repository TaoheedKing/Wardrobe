package com.example.demo;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;
//<<<<<<< HEAD
//=======
//
//>>>>>>> 9fb21b6be695f82c188866088bf5910432068091
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String tops;

    private String bottoms;

    private String shoes;

    private String accessories;

    private String jackets;

    @NotNull
    private String categoryType;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Item>items;

    public Category() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJackets() {
        return jackets;
    }

    public void setJackets(String jackets) {
        this.jackets = jackets;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public String getTops() {
        return tops;
    }

    public void setTops(String tops) {
        this.tops = tops;
    }

    public String getBottoms() {
        return bottoms;
    }

    public void setBottoms(String bottoms) {
        this.bottoms = bottoms;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }
}
