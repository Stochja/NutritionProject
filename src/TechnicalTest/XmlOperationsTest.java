package TechnicalTest;

import Nutrition.Produit;
import org.junit.Test;
import xml.XmlOperations;

public class XmlOperationsTest {
    String _PATH_TO_TEST_FILE_ = "C:/Users/Nico/IdeaProjects/NutritionProject/src/xml/test/";
    String fileName = "TestSaveFile";

    Produit[] productList = {
            new Produit("Chocolat", "Ethiquable", "", 619L,
                    51d, 31d, 24d, 0d, 11d,
                    0d, 14d, 0d, 11d, 0d, 0d,
                    0d, 0d, 0d, 0d, 0d),
            new Produit("Carottes Râpées Au Citron De Sicile", "Bonduelle", "", 77L,
                    5d, 0d, 6d, 0d, 3d,
                    0d, 4d, 0d, 1d, 273d, 0d,
                    0d, 330d, 8d, 2d, 1d)
    };

    @Test
    public void loadingTest() {

    }

    @Test
    public void savingTest() {
        try {
            assert(XmlOperations.checkForSavedFile(fileName + ".xml", _PATH_TO_TEST_FILE_).equals(false));
            XmlOperations.createSaveFile(productList, fileName + ".xml", _PATH_TO_TEST_FILE_);
            assert(XmlOperations.checkForSavedFile(fileName + ".xml", _PATH_TO_TEST_FILE_).equals(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
