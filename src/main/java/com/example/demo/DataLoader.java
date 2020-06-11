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
/**
 * Here is where the items start for Outfit 1
 * */
        Item topOne = new Item();
        topOne.setCategory(tops);
        topOne.setColor("Black");
        topOne.setFabricMaterial("cotton");
        topOne.setSize(7);
        topOne.setItemName("Shirt");
        topOne.setImages("image/women.png");
        itemRepository.save(topOne);

        Item bottomOne = new Item();
        bottomOne.setCategory(bottoms);
        bottomOne.setColor("Light Blue");
        bottomOne.setFabricMaterial("Denim");
        bottomOne.setSize(31);
        bottomOne.setItemName("Bleached Light Blue Jeans");
        itemRepository.save(bottomOne);

        Item shoeOne = new Item();
        shoeOne.setCategory(shoes);
        shoeOne.setColor("Black");
        shoeOne.setFabricMaterial("Mesh");
        shoeOne.setSize(7);
        shoeOne.setItemName("Shoe");
        itemRepository.save(shoeOne);

        Item accessoryOne = new Item();
        accessoryOne.setCategory(accessories);
        accessoryOne.setColor("Gold");
        accessoryOne.setFabricMaterial("Gold");
        accessoryOne.setSize(1);
        accessoryOne.setItemName("Gold Watch");
        itemRepository.save(accessoryOne);


        Item jacketOne = new Item();
        jacketOne.setCategory(jackets);
        jacketOne.setColor("Black");
        jacketOne.setFabricMaterial("Leather");
        jacketOne.setSize(30);
        jacketOne.setItemName(jacketOne.getColor() + " Jacket");
        itemRepository.save(jacketOne);


        /**
         * Here is where the items start for Outfit 2
         * */
        Item topTwo = new Item();
        topTwo.setCategory(tops);
        topTwo.setColor("White");
        topTwo.setFabricMaterial("Blend");
        topTwo.setSize(7);
        topTwo.setItemName("Crew Neck Tee Shirt");
        itemRepository.save(topTwo);

        Item bottomTwo = new Item();
        bottomTwo.setCategory(bottoms);
        bottomTwo.setColor("Grey");
        bottomTwo.setFabricMaterial("Denim");
        bottomTwo.setSize(34);
        bottomTwo.setItemName("Skinny Jeans");
        itemRepository.save(bottomTwo);

        Item shoeTwo = new Item();
        shoeTwo.setCategory(shoes);
        shoeTwo.setColor("White, Black, Red");
        shoeTwo.setFabricMaterial("Mesh");
        shoeTwo.setSize(7);
        shoeTwo.setItemName("Tennis Shoes");
        itemRepository.save(shoeTwo);

        Item accessoryTwo = new Item();
        accessoryTwo.setCategory(accessories);
        accessoryTwo.setColor("Green");
        accessoryTwo.setFabricMaterial("");
        accessoryTwo.setSize(7);
        accessoryTwo.setItemName("Shirt");
        itemRepository.save(accessoryTwo);

        Item jacketTwo = new Item();
        jacketTwo.setCategory(jackets);
        jacketTwo.setColor("Tan");
        jacketTwo.setFabricMaterial("Leather");
        jacketTwo.setSize(30);
        jacketTwo.setItemName(jacketTwo.getColor() + " Jacket");
        itemRepository.save(jacketTwo);


        /**
         * Here is where the items start for Outfit 3
         * */
        Item topThree = new Item();
        topThree.setCategory(tops);
        topThree.setColor("red");
        topThree.setFabricMaterial("cotton");
        topThree.setSize(7);
        topThree.setItemName("Shirt");
        itemRepository.save(topThree);

        Item bottomThree = new Item();
        bottomThree.setCategory(bottoms);
        bottomThree.setColor("green");
        bottomThree.setFabricMaterial("cotton");
        bottomThree.setSize(31);
        bottomThree.setItemName("Jeans");
        itemRepository.save(bottomThree);

        Item shoeThree = new Item();
        shoeThree.setCategory(shoes);
        shoeThree.setColor("green");
        shoeThree.setFabricMaterial("");
        shoeThree.setSize(7);
        shoeThree.setItemName("Shoe");
        itemRepository.save(shoeThree);

        Item accessoryThree = new Item();
        accessoryThree.setCategory(accessories);
        accessoryThree.setColor("green");
        accessoryThree.setFabricMaterial("");
        accessoryThree.setSize(7);
        accessoryThree.setItemName("Shirt");
        itemRepository.save(accessoryThree);





        /**
         * Here is where the items start for Outfit 4
         * */
        Item topFour = new Item();
        topFour.setCategory(tops);
        topFour.setColor("red");
        topFour.setFabricMaterial("cotton");
        topFour.setSize(7);
        topFour.setItemName("Shirt");
        itemRepository.save(topFour);

        Item bottomFour = new Item();
        bottomFour.setCategory(bottoms);
        bottomFour.setColor("green");
        bottomFour.setFabricMaterial("cotton");
        bottomFour.setSize(31);
        bottomFour.setItemName("Jeans");
        itemRepository.save(bottomFour);

        Item shoeFour = new Item();
        shoeFour.setCategory(shoes);
        shoeFour.setColor("green");
        shoeFour.setFabricMaterial("");
        shoeFour.setSize(7);
        shoeFour.setItemName("Shoe");
        itemRepository.save(shoeFour);

        Item accessoryFour = new Item();
        accessoryFour.setCategory(accessories);
        accessoryFour.setColor("green");
        accessoryFour.setFabricMaterial("");
        accessoryFour.setSize(7);
        accessoryFour.setItemName("Shirt");
        itemRepository.save(accessoryFour);





        /**
         * Here is where the items start for Outfit 5
         * */
        Item topFive = new Item();
        topFive.setCategory(tops);
        topFive.setColor("red");
        topFive.setFabricMaterial("cotton");
        topFive.setSize(7);
        topFive.setItemName("Shirt");
        itemRepository.save(topFive);

        Item bottomFive = new Item();
        bottomFive.setCategory(bottoms);
        bottomFive.setColor("green");
        bottomFive.setFabricMaterial("cotton");
        bottomFive.setSize(31);
        bottomFive.setItemName("Jeans");
        itemRepository.save(bottomFive);

        Item shoeFive = new Item();
        shoeFive.setCategory(shoes);
        shoeFive.setColor("green");
        shoeFive.setFabricMaterial("");
        shoeFive.setSize(7);
        shoeFive.setItemName("Shoe");
        itemRepository.save(shoeFive);

        Item accessoriesFive = new Item();
        accessoriesFive.setCategory(accessories);
        accessoriesFive.setColor("green");
        accessoriesFive.setFabricMaterial("");
        accessoriesFive.setSize(7);
        accessoriesFive.setItemName("Shirt");
        itemRepository.save(accessoriesFive);
    }
}