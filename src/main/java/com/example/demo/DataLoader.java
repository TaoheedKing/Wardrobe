package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;
    //Tops (shirts, tank tops, sweaters)
    //            Bottoms (pants, skirts, shorts)
//            Jackets (light jackets, rain jackets or heavy coats)
//            Shoes (rain boots, sneakers, dress shoes, sandals)

    @Override
    public void run(String... args) throws Exception {

//        Category category = new Category();
//
//        category.setTops("Tops");
//        category.setBottoms("Bottoms");
//        category.setShoes("sneakers");
//        category.setAccessories("");
//        category.setJackets("");
//        categoryRepository.save(category);
        Category tops = new Category();
        tops.setCategoryType("Tops");
        categoryRepository.save(tops);

        Category bottoms = new Category();
        bottoms.setCategoryType("Bottoms");
        categoryRepository.save(bottoms);

        Category accessories = new Category();
        accessories.setCategoryType("Accessories");
        categoryRepository.save(accessories);

        Category shoes = new Category();
        shoes.setCategoryType("Shoes");
        categoryRepository.save(shoes);

        Category jackets = new Category();
        jackets.setCategoryType("Jacket");
        categoryRepository.save(jackets);

        Item topOne = new Item();
        topOne.setCategory(tops);
        topOne.setColor("green");
        topOne.setFabricMaterial("cotton");
        topOne.setSize(7);
        topOne.setItemName("Shirt");
        topOne.setImages("image/women.png");
        itemRepository.save(topOne);

        Item bottomOne = new Item();
        bottomOne.setCategory(bottoms);
        bottomOne.setColor("green");
        bottomOne.setFabricMaterial("cotton");
        bottomOne.setSize(31);
        bottomOne.setItemName("Jeans");
        itemRepository.save(bottomOne);
    }






}