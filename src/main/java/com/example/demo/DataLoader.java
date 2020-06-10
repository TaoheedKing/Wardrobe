package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepository;
    //Tops (shirts, tank tops, sweaters)
    //            Bottoms (pants, skirts, shorts)
//            Jackets (light jackets, rain jackets or heavy coats)
//            Shoes (rain boots, sneakers, dress shoes, sandals)

    @Override
    public void run(String... args) throws Exception {

        Category category = new Category();

        category.setTops("Tops");
        category.setBottoms("Bottoms");
        category.setShoes("sneakers");
        category.setShoes("");
        categoryRepository.save(category);
    }
}