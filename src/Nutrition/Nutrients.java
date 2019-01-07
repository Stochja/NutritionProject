package Nutrition;

/*
    Product defines liquid and solid products that constitute our nutrients intake
    Those may be identified by a barcode when bought in a store
    They might not be a identified product but a dish that you can find in a restaurant and those require
    approximations during the input by the user
 */
public class Nutrients {
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

    public Nutrients(long calories, double totalFat, double saturatedFat, double totalCarbs, double polyunsaturated,
                     double dietaryFiber, double monounsaturated, double sugars, double trans, double protein,
                     double sodium, double potassium, double cholesterol, double vitaminA, double vitaminC,
                     double calcium, double iron) {
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


}
