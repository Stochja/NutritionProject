package main.java.com.mycompany.app;

import main.java.com.mycompany.app.Nutrition.Produit;
import main.java.com.mycompany.app.UI.ConsoleHandler;

import java.util.List;

public class NutritionProject {

    public static void main(int args[]) {
        List<Produit> productList = XmlOperations.loadFromSaveFile("", "");

        System.out.println("Programme lancé, produits chargés : " + productList.size());

        while (ConsoleHandler.handleInput()) {
        }

        try {
            System.out.println("Saving the product list before closing");
            XmlOperations.createSaveFile(productList, "productListEnd.xml", XmlOperations._PATH_TO_FILE_);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Exiting...");
    }
}
