package com.example.demo;

import javax.persistence.*;
import java.util.Set;

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String tops;

    private String bottoms;

    private String shoes;

    private String accessories;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Item>items;

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
}
