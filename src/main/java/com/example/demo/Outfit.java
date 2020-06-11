package com.example.demo;

import javax.persistence.*;

@Entity
public class Outfit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String color;
    private String fabricMaterial;
    private String images;
    private double size;
    private String itemName;
    private String description;
//    private Category category;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Outfit() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFabricMaterial() {
        return fabricMaterial;
    }

    public void setFabricMaterial(String fabric_material) {
        this.fabricMaterial = fabric_material;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }


}
