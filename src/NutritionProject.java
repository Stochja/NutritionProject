import Nutrition.Produit;
import xml.XmlOperations;

import java.util.List;

public class NutritionProject {

    public static void main(int args[]) {
        List<Produit> productList = XmlOperations.loadFromSaveFile("", "");

        while () {

        }

        try {
            XmlOperations.createSaveFile(productList, "productListEnd.xml", XmlOperations._PATH_TO_FILE_);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
