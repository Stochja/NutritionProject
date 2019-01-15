package com.mycompany.app.Optimisation;

import com.mycompany.app.Nutrition.Produit;
import com.mycompany.app.NutritionProject;

import java.util.ArrayList;
import java.util.List;

public class InequalitiesGenerator {

    private static char[] variables = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j',
            'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
    private static String[] nutrients = {"Calories", "Protein", "Carbs", "Fiber", "Sugars", "Total Fat", "SaturatedFat", "Products"};

    public static void generateInequalities(Integer calories, Integer protein, Integer carbs, Integer fiber,
                                            Integer sugars, Integer fat, Integer saturatedFat, Integer sodium) {
        List<String> nutrientLines = new ArrayList<>();

        String caloriesInequality = "";
        String proteinInequality = "";
        String carbsInequality = "";
        String fiberInequality = "";
        String sugarsInequality = "";
        String fatInequality = "";
        String saturatedFatInequality = "";
        String sodiumInequality = "";
        List<String> limitsInequalities = new ArrayList<>();
        String prdNames = "";

        int i = 0;
        for (Produit prd : NutritionProject.productList) {
            if (i == 0) {
                caloriesInequality = caloriesInequality.concat(getPerGram(prd.getCalories() * prd.getPortionSize()) + variables[i]);
                proteinInequality = proteinInequality.concat(getPerGram(prd.getProtein() * prd.getPortionSize()) + variables[i]);
                carbsInequality = carbsInequality.concat(getPerGram(prd.getTotalCarbs() * prd.getPortionSize()) + variables[i]);
                fiberInequality = fiberInequality.concat(getPerGram(prd.getDietaryFiber() * prd.getPortionSize()) + variables[i]);
                sugarsInequality = sugarsInequality.concat(getPerGram(prd.getSugars() * prd.getPortionSize()) + variables[i]);
                fatInequality = fatInequality.concat(getPerGram(prd.getTotalFat() * prd.getPortionSize()) + variables[i]);
                saturatedFatInequality = saturatedFatInequality.concat(getPerGram(prd.getTotalFat() * prd.getPortionSize()) + variables[i]);
                sodiumInequality = sodiumInequality.concat(getPerGram(prd.getSodium() * prd.getPortionSize()) + variables[i]);
            } else {
                caloriesInequality = caloriesInequality.concat(" + " + getPerGram(prd.getCalories() * prd.getPortionSize()) + variables[i]);
                proteinInequality = proteinInequality.concat(" + " + getPerGram(prd.getProtein() * prd.getPortionSize()) + variables[i]);
                carbsInequality = carbsInequality.concat(" + " + getPerGram(prd.getTotalCarbs() * prd.getPortionSize()) + variables[i]);
                fiberInequality = fiberInequality.concat(" + " + getPerGram(prd.getDietaryFiber() * prd.getPortionSize()) + variables[i]);
                sugarsInequality = sugarsInequality.concat(" + " + getPerGram(prd.getSugars() * prd.getPortionSize()) + variables[i]);
                fatInequality = fatInequality.concat(" + " + getPerGram(prd.getTotalFat() * prd.getPortionSize()) + variables[i]);
                saturatedFatInequality = saturatedFatInequality.concat(" + " + getPerGram(prd.getSaturatedFat() * prd.getPortionSize()) + variables[i]);
                sodiumInequality = sodiumInequality.concat(" + " + getPerGram(prd.getSodium() * prd.getPortionSize()) + variables[i]);
            }
            prdNames = prdNames.concat(prd.getProductName() + "=" + variables[i] + "| ");
            if (prd.getLimits() > 0) {
                limitsInequalities.add(variables[i] + " <= " + prd.getLimits());
            }
            i++;
        }
        String maximize = "Maximize p = ".concat(caloriesInequality).concat(" subject to");
        caloriesInequality = caloriesInequality.concat(" <= " + calories.toString());
        proteinInequality = proteinInequality.concat(" <= " + protein.toString());
        carbsInequality = carbsInequality.concat(" <= " + carbs.toString());
        fiberInequality = fiberInequality.concat(" <= " + fiber.toString());
        sugarsInequality = sugarsInequality.concat(" <= " + sugars.toString());
        fatInequality = fatInequality.concat(" <= " + fat.toString());
        saturatedFatInequality = saturatedFatInequality.concat(" <= " + saturatedFat.toString());
        sodiumInequality = sodiumInequality.concat(" <= " + sodium.toString());

        nutrientLines.add(caloriesInequality);
        nutrientLines.add(proteinInequality);
        nutrientLines.add(carbsInequality);
        nutrientLines.add(fiberInequality);
        nutrientLines.add(sugarsInequality);
        nutrientLines.add(fatInequality);
        nutrientLines.add(saturatedFatInequality);
        nutrientLines.add(sodiumInequality);
        nutrientLines.add(prdNames);

        System.out.println(maximize);

        for (int j = 0; j < nutrientLines.size() - 1; j++) {
            //System.out.println(nutrients[j]);
            System.out.println(nutrientLines.get(j));
        }

        for (int j = 0; j < limitsInequalities.size(); j++) {
            System.out.println(limitsInequalities.get(j));
        }

        /* Add daily recommended amounts inequalities */
        System.out.println(nutrientLines.get(nutrientLines.size() - 1));
    }


    private static String getPerGram(double val) {
        return Double.toString(val / 100.0);
    }
}
