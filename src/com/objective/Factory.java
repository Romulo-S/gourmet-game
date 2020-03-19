package com.objective;

import java.util.*;

public class Factory {

    public static Map<Category, List<Food>> foodMap = new HashMap<>();
    static Category salad = new Category("salad");
    static Category dessert = new Category("dessert");

    static Food lettuce = new Food("Lettuce");
    static Food cress = new Food("Cress");

    static Food chocolateMousse = new Food("Chocolate mousse");
    static Food chocolatePie = new Food("Chocolate pie");

    public static Map<Category, List<Food>> createDefaultMapFood() {
        foodMap.put(salad, new ArrayList<>(Arrays.asList(lettuce, cress)));
        foodMap.put(dessert, new ArrayList<>(Arrays.asList(chocolateMousse, chocolatePie)));
        return foodMap;
    }

}
