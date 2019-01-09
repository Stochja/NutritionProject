package xml;

import Nutrition.Produit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XmlOperations {
    private final static String _PATH_TO_FILE_ = "C:/Users/Nico/IdeaProjects/NutritionProject/";
    private final static String saveFile = "productList";

    public static Boolean checkForSavedFile(String filename, String path) {
        File tmpDir = getRightFile(filename, path);

        return tmpDir.exists() && tmpDir.isFile() && tmpDir.length() > 0;
    }

    private static File getRightFile(String filename, String path) {
        String fileToTest, pathToTest;

        if (filename == null || path == null || filename.isEmpty() || path.isEmpty()) {
            fileToTest = saveFile;
            pathToTest = _PATH_TO_FILE_;
        } else {
            fileToTest = filename;
            pathToTest = path;
        }

        return new File(pathToTest + fileToTest);
    }

    public static void createSaveFile(Produit[] prdList, String filename, String path) throws Exception {
        File tmpDir = getRightFile(filename, path);

        try {
            if (!tmpDir.createNewFile()) {
                throw new Exception("Save file already exists");
            } else {
                DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder icBuilder;
                icBuilder = icFactory.newDocumentBuilder();
                Document doc = icBuilder.newDocument();
                Element mainRootElement = doc.createElementNS("", "Products");
                doc.appendChild(mainRootElement);

                for (Produit prd : prdList) {
                    mainRootElement.appendChild(getProduct(doc, prd));
                }

                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);
                StreamResult console = new StreamResult(tmpDir);
                transformer.transform(source, console);

                System.out.println("Done creating XML File");
            }
        } catch (IOException e) {
            System.out.println("There was an error while creating the save file:" + e.getMessage());
            throw new Exception("Save file could not be created, modifications won't be saved");
        }
    }

    private static Node getProduct(Document doc, Produit prd) {
        Element product = doc.createElement("Product");
        product.setAttribute("barcode", prd.getBarcode());
        product.appendChild(getProductElements(doc, "ProductName", prd.getProductName()));
        product.appendChild(getProductElements(doc, "BrandName", prd.getBrandName()));
        product.appendChild(getProductElements(doc, "Calories", prd.getCalories().toString()));
        product.appendChild(getProductElements(doc, "TotalFat", prd.getTotalFat().toString()));
        product.appendChild(getProductElements(doc, "SaturatedFat", prd.getSaturatedFat().toString()));
        product.appendChild(getProductElements(doc, "TotalCarbs", prd.getTotalCarbs().toString()));
        product.appendChild(getProductElements(doc, "PolyUnsaturated", prd.getPolyunsaturated().toString()));
        product.appendChild(getProductElements(doc, "DietaryFiber", prd.getDietaryFiber().toString()));
        product.appendChild(getProductElements(doc, "MonoUnsaturated", prd.getMonounsaturated().toString()));
        product.appendChild(getProductElements(doc, "Sugars", prd.getSugars().toString()));
        product.appendChild(getProductElements(doc, "TransFat", prd.getTrans().toString()));
        product.appendChild(getProductElements(doc, "Protein", prd.getProtein().toString()));
        product.appendChild(getProductElements(doc, "Sodium", prd.getSodium().toString()));
        product.appendChild(getProductElements(doc, "Potassium", prd.getPotassium().toString()));
        product.appendChild(getProductElements(doc, "Cholesterol", prd.getCholesterol().toString()));
        product.appendChild(getProductElements(doc, "VitaminA", prd.getVitaminA().toString()));
        product.appendChild(getProductElements(doc, "VitaminC", prd.getVitaminC().toString()));
        product.appendChild(getProductElements(doc, "Calcium", prd.getCalcium().toString()));
        product.appendChild(getProductElements(doc, "Iron", prd.getIron().toString()));

        return product;
    }

    private static Node getProductElements(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
