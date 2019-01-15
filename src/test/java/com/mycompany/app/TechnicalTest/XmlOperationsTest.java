package com.mycompany.app.TechnicalTest;

import com.mycompany.app.Nutrition.Produit;
import com.mycompany.app.XmlOperations;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class XmlOperationsTest {
    private static String _PATH_TO_TEST_FILE_ = "C:/Users/Nico/IdeaProjects/NutritionProject/src/xml/test/";
    private static String fileName = "TestSaveFile.xml";

    private static List<Produit> productList = new ArrayList<>();

    static {
        productList.add(new Produit("Chocolat", "Ethiquable", "", 619d,
                51d, 31d, 24d, 0d, 11d,
                0d, 14d, 0d, 11d, 0d, 0d,
                0d, 0d, 0d, 0d, 0d, 1, 0));
        productList.add(new Produit("Carottes Râpées Au Citron De Sicile", "Bonduelle", "", 77d,
                5d, 0d, 6d, 0d, 3d,
                0d, 4d, 0d, 1d, 273d, 0d,
                0d, 330d, 8d, 2d, 1d,1, 0));
        XmlOperations.deleteSaveFile(fileName, _PATH_TO_TEST_FILE_);
    }

    @Test
    public void loadingTest() {
        String fileNameToLoad = "TestSaveFileToLoad.xml";
        assert (XmlOperations.checkForSavedFile(fileNameToLoad, _PATH_TO_TEST_FILE_).equals(true));
        List<Produit> prdListToLoad = XmlOperations.loadFromSaveFile(fileNameToLoad, _PATH_TO_TEST_FILE_);
        assert (productList.equals(prdListToLoad));
    }

    @Test
    public void savingTest() {
        try {
            assert (XmlOperations.checkForSavedFile(fileName, _PATH_TO_TEST_FILE_).equals(false));
            XmlOperations.createSaveFile(productList, fileName, _PATH_TO_TEST_FILE_);
            assert (XmlOperations.checkForSavedFile(fileName, _PATH_TO_TEST_FILE_).equals(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
