package Nutrition;

import java.util.Objects;

/*
    Product defines liquid and solid products that constitute our nutrients intake
    Those may be identified by a barcode when bought in a store
    They might not be a identified product but a dish that you can find in a restaurant and those require
    approximations during the input by the user
 */
public class Produit {
    private String barcode;
    private String productName;
    private String brandName;

    //
    private long calories;

    // In grams
    private double totalFat;
    private double saturatedFat;
    private double totalCarbs;
    private double polyunsaturated;
    private double dietaryFiber;
    private double monounsaturated;
    private double sugars;
    private double trans;
    private double protein;


    // In milligrams
    private double sodium;
    private double potassium;
    private double cholesterol;

    // In percent
    private double vitaminA;
    private double vitaminC;
    private double calcium;
    private double iron;

    // Constructor with all parameters
    public Produit(String productName, String brandName, String barcode, long calories, double totalFat,
                   double saturatedFat, double totalCarbs, double polyunsaturated,
                   double dietaryFiber, double monounsaturated, double sugars, double trans, double protein,
                   double sodium, double potassium, double cholesterol, double vitaminA, double vitaminC,
                   double calcium, double iron) {
        this.productName = productName;
        this.brandName = brandName;
        this.barcode = barcode;
        this.calories = calories;
        this.totalFat = totalFat;
        this.saturatedFat = saturatedFat;
        this.totalCarbs = totalCarbs;
        this.polyunsaturated = polyunsaturated;
        this.dietaryFiber = dietaryFiber;
        this.monounsaturated = monounsaturated;
        this.sugars = sugars;
        this.trans = trans;
        this.protein = protein;
        this.sodium = sodium;
        this.potassium = potassium;
        this.cholesterol = cholesterol;
        this.vitaminA = vitaminA;
        this.vitaminC = vitaminC;
        this.calcium = calcium;
        this.iron = iron;
    }

    // Constructor with all parameters except barcode and brandName
    public Produit(String productName, long calories, double totalFat, double saturatedFat,
                   double totalCarbs, double polyunsaturated,
                   double dietaryFiber, double monounsaturated, double sugars, double trans, double protein,
                   double sodium, double potassium, double cholesterol, double vitaminA, double vitaminC,
                   double calcium, double iron) {
        this.productName = productName;
        this.calories = calories;
        this.totalFat = totalFat;
        this.saturatedFat = saturatedFat;
        this.totalCarbs = totalCarbs;
        this.polyunsaturated = polyunsaturated;
        this.dietaryFiber = dietaryFiber;
        this.monounsaturated = monounsaturated;
        this.sugars = sugars;
        this.trans = trans;
        this.protein = protein;
        this.sodium = sodium;
        this.potassium = potassium;
        this.cholesterol = cholesterol;
        this.vitaminA = vitaminA;
        this.vitaminC = vitaminC;
        this.calcium = calcium;
        this.iron = iron;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produit)) return false;
        Produit produit = (Produit) o;
        return getCalories() == produit.getCalories() &&
                Double.compare(produit.getTotalFat(), getTotalFat()) == 0 &&
                Double.compare(produit.getSaturatedFat(), getSaturatedFat()) == 0 &&
                Double.compare(produit.getTotalCarbs(), getTotalCarbs()) == 0 &&
                Double.compare(produit.getPolyunsaturated(), getPolyunsaturated()) == 0 &&
                Double.compare(produit.getDietaryFiber(), getDietaryFiber()) == 0 &&
                Double.compare(produit.getMonounsaturated(), getMonounsaturated()) == 0 &&
                Double.compare(produit.getSugars(), getSugars()) == 0 &&
                Double.compare(produit.getTrans(), getTrans()) == 0 &&
                Double.compare(produit.getProtein(), getProtein()) == 0 &&
                Double.compare(produit.getSodium(), getSodium()) == 0 &&
                Double.compare(produit.getPotassium(), getPotassium()) == 0 &&
                Double.compare(produit.getCholesterol(), getCholesterol()) == 0 &&
                Double.compare(produit.getVitaminA(), getVitaminA()) == 0 &&
                Double.compare(produit.getVitaminC(), getVitaminC()) == 0 &&
                Double.compare(produit.getCalcium(), getCalcium()) == 0 &&
                Double.compare(produit.getIron(), getIron()) == 0 &&
                Objects.equals(barcode, produit.barcode) &&
                productName.equals(produit.productName) &&
                Objects.equals(brandName, produit.brandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode, productName, brandName, getCalories(), getTotalFat(), getSaturatedFat(), getTotalCarbs(), getPolyunsaturated(), getDietaryFiber(), getMonounsaturated(), getSugars(), getTrans(), getProtein(), getSodium(), getPotassium(), getCholesterol(), getVitaminA(), getVitaminC(), getCalcium(), getIron());
    }

    public String getBarcode() {
        return barcode;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public long getCalories() {
        return calories;
    }

    public double getTotalFat() {
        return totalFat;
    }

    public double getSaturatedFat() {
        return saturatedFat;
    }

    public double getTotalCarbs() {
        return totalCarbs;
    }

    public double getPolyunsaturated() {
        return polyunsaturated;
    }

    public double getDietaryFiber() {
        return dietaryFiber;
    }

    public double getMonounsaturated() {
        return monounsaturated;
    }

    public double getSugars() {
        return sugars;
    }

    public double getTrans() {
        return trans;
    }

    public double getProtein() {
        return protein;
    }

    public double getSodium() {
        return sodium;
    }

    public double getPotassium() {
        return potassium;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public double getVitaminA() {
        return vitaminA;
    }

    public double getVitaminC() {
        return vitaminC;
    }

    public double getCalcium() {
        return calcium;
    }

    public double getIron() {
        return iron;
    }
}