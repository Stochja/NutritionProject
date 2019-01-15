package com.mycompany.app.UI;

import com.mycompany.app.Nutrition.Produit;
import com.mycompany.app.NutritionProject;
import com.mycompany.app.Optimisation.InequalitiesGenerator;

import java.util.Scanner;

public class ConsoleHandler {
    public static boolean handleInput(Scanner sca) {
        System.out.println("*** Menu ***");
        System.out.println("1. Add a product");
        System.out.println("2. Product list");
        System.out.println("3. Generate menu");

        System.out.println("0. End program");
        System.out.println("Enter a number :");
        int n = Integer.parseInt(sca.nextLine());

        switch (n) {
            case 0:
                return false;
            case 1:
                handleProductAddition(sca);
                break;
            case 2:
                while (handleProductDisplay(sca)) ;
                break;
            case 3:
                handleMenuGeneration(sca);
                break;
        }
        return true;
    }

    private static void handleProductAddition(Scanner sca) {
        System.out.println("*** Addition of a product ***");
        System.out.println("Nutritional values for which weight (in g) :");
        double factor = 1 / (Double.parseDouble(sca.nextLine()) / 100.0);
        System.out.println("Product name :");
        String productName = sca.nextLine();
        System.out.println("Brand name :");
        String brandName = sca.nextLine();
        System.out.println("Barcode :");
        String barcode = sca.nextLine();
        System.out.println("Calories :");
        double calories = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Total fat :");
        double totalFat = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Saturated fat :");
        double saturatedFat = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Total Carbohydrates :");
        double totalCarbs = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Polyunsaturated fat :");
        double polyunsaturated = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Dietary Fiber :");
        double dietaryFiber = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Monounsaturated fat :");
        double monounsaturated = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Sugars :");
        double sugars = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Transfat :");
        double trans = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Protein :");
        double protein = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Sodium :");
        double sodium = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Potassium :");
        double potassium = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Cholesterol :");
        double cholesterol = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Vitamin A :");
        double vitaminA = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Vitamin C :");
        double vitaminC = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Calcium :");
        double calcium = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Iron :");
        double iron = Double.parseDouble(sca.nextLine()) * factor;
        System.out.println("Portion size ? (1g default) :");
        int portionSize = Integer.parseInt(sca.nextLine());
        System.out.println("Limit per day :");
        int limits = Integer.parseInt(sca.nextLine());

        NutritionProject.productList.add(new Produit(productName, brandName, barcode, calories, totalFat, saturatedFat,
                totalCarbs, polyunsaturated, dietaryFiber, monounsaturated, sugars, trans, protein, sodium, potassium,
                cholesterol, vitaminA, vitaminC, calcium, iron, portionSize, limits));
        System.out.println("Product added to list");
    }

    private static boolean handleProductDisplay(Scanner sca) {
        System.out.println("*** Product list  actions ***");
        System.out.println("1. Display product list");
        System.out.println("2. Display info on a product");

        System.out.println("0. Return");
        System.out.println("Enter a number :");
        int n = Integer.parseInt(sca.nextLine());

        switch (n) {
            case 0:
                return false;
            case 1:
                handleProductList(sca);
                break;
            case 2:
                //while (handleProductInfo(sca)) ;
                break;
        }
        return true;
    }

    private static void handleProductList(Scanner sca) {
        clearConsole();
        System.out.println("*** Displaying product list (3 products at a time) ***");
        int i = 0;
        for (Produit prd : NutritionProject.productList) {
            if (i / 3 > 0 && i % 3 == 0) {
                System.out.println("*** *** *** ***");
                System.out.println("1. Continue in list of products");
                System.out.println("0. Return to menu");
                System.out.println("Enter a number :");
                int n = Integer.parseInt(sca.nextLine());

                switch (n) {
                    case 0:
                        return;
                    case 1:
                        clearConsole();
                        break;
                    default:
                        clearConsole();
                        break;
                }
            }
            System.out.println(++i + ". " + prd.getProductName() + " by " + prd.getBrandName() + " (" + prd.getBarcode() + ")");
            System.out.println("Calories (per 100g): " + prd.getCalories());
            System.out.println("Total fat: " + prd.getTotalFat() + "g, Saturated: " + prd.getSaturatedFat() + "g");
            System.out.println("Polyunsaturated: " + prd.getPolyunsaturated() + "g, MonoUnsaturated: " + prd.getMonounsaturated() + "g");
            System.out.println("Transfat: " + prd.getTrans() + "g");
            System.out.println("Total carbs: " + prd.getTotalCarbs() + "g, Sugars: " + prd.getSugars() + "g");
            System.out.println("Protein: " + prd.getProtein() + "g, Sodium: " + prd.getSodium() + "mg");
            System.out.println("Potassium: " + prd.getPotassium() + "mg, Cholesterol: " + prd.getCholesterol() + "mg");
            System.out.println("Vitamin A: " + prd.getVitaminA() + "%, Vitamin C: " + prd.getVitaminC() + "%");
            System.out.println("Calclum: " + prd.getCalcium() + "%, Iron: " + prd.getIron() + "%");
            System.out.println("****************************************************************************");
        }

        System.out.println("*** End of product list ***");
    }

    private static void handleMenuGeneration(Scanner sca) {
        clearConsole();
        System.out.println("*** Menu generation ***");
        System.out.println("First step is inputting your macros for the day");
        System.out.println("Calories: ");
        int calories = Integer.parseInt(sca.nextLine());
        System.out.println("Protein : ");
        int protein = Integer.parseInt(sca.nextLine());
        System.out.println("Carbs : ");
        int carbs = Integer.parseInt(sca.nextLine());
        System.out.println("Fiber : ");
        int fiber = Integer.parseInt(sca.nextLine());
        System.out.println("Sugars : ");
        int sugars = Integer.parseInt(sca.nextLine());
        System.out.println("Fat : ");
        int fat = Integer.parseInt(sca.nextLine());
        System.out.println("Saturated Fat : ");
        int saturatedFat = Integer.parseInt(sca.nextLine());
        System.out.println("Sodium : ");
        int sodium = Integer.parseInt(sca.nextLine());
        InequalitiesGenerator.generateInequalities(calories, protein, carbs, fiber, sugars, fat, saturatedFat, sodium);
    }

    private static void clearConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}
