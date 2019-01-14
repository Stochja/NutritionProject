package com.mycompany.app;

import com.mycompany.app.Nutrition.Produit;
import com.mycompany.app.UI.ConsoleHandler;

import java.util.List;
import java.util.Scanner;

public class NutritionProject {
    public static List<Produit> productList = XmlOperations.loadFromSaveFile("", "");

    public static void main(String args[]) {
        System.out.println("Programme lancé, produits chargés : " + productList.size());
        Scanner reader = new Scanner(System.in);
        while (ConsoleHandler.handleInput(reader));
        reader.close();
        try {
            System.out.println("Saving the product list before closing");
            XmlOperations.deleteSaveFile("", "");
            XmlOperations.createSaveFile(productList, "", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Exiting...");
    }
}
