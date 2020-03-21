package com.objective;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        Map<Category, List<Food>> entry;

        entry = Factory.createDefaultMapFood();
        JOptionPane.showMessageDialog(null, "Think in a food you like", "", JOptionPane.INFORMATION_MESSAGE);

        boolean play = true;
        boolean lose = false;
        do {
            lose = false;
            // using for-each loop for iteration over Map.entrySet()
            for (Map.Entry<Category, List<Food>> map : entry.entrySet()) {
                Category key = map.getKey();
                List<Food> value = map.getValue();
                int option = JOptionPane.showConfirmDialog(null, "Is it a " + key.getName() + " type of food?", "Gourmet Game", JOptionPane.YES_NO_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    for (Food food : value) {
                        option = JOptionPane.showConfirmDialog(null, "Is  " + food.getName() + " your food?", "Gourmet Game", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (option == JOptionPane.OK_OPTION) {
                            JOptionPane.showMessageDialog(null, "I got it!", "", JOptionPane.INFORMATION_MESSAGE);
                            option = JOptionPane.showConfirmDialog(null, "Continue?", "Gourmet Game", JOptionPane.YES_NO_OPTION);
                            if (option == JOptionPane.OK_OPTION) {
                                lose = true;
                            } else if (option == JOptionPane.NO_OPTION || option == JOptionPane.DEFAULT_OPTION) {
                                return;
                            }
                        } else if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.DEFAULT_OPTION) {
                            return;
                        }
                    }
                    if (lose != true) {
                        String answer = JOptionPane.showInputDialog("Ok you win, what is your food?");

                        Food newFood = new Food(answer);
                        value.add(newFood);
                        entry.put(key, value);
                        option = JOptionPane.showConfirmDialog(null, "Continue?", "Gourmet Game", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.OK_OPTION) {
                            continue;
                        } else if (option == JOptionPane.NO_OPTION || option == JOptionPane.DEFAULT_OPTION) {
                            return;
                        }
                    }
                } else if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.DEFAULT_OPTION) {
                    return;
                }

            }
            if (lose != true) {

                /**Add new category**/
                String answer = JOptionPane.showInputDialog("Ok you win, how do you describe the category of your food??");
                Category newCategory = new Category(answer);
                /**Add new food**/
                answer = JOptionPane.showInputDialog(" what is the name of your food?");
                Food newFood = new Food(answer);

                List<Food> foods = new ArrayList<>();
                foods.add(newFood);
                entry.put(newCategory, foods);

                int option = JOptionPane.showConfirmDialog(null, "Continue?", "Gourmet Game", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    continue;
                } else if (option == JOptionPane.NO_OPTION || option == JOptionPane.DEFAULT_OPTION) {
                    return;
                }
            }


        } while (play);


    }
}


