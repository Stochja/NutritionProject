package test.java.com.mycompany.app.NutritionTest;

import main.java.com.mycompany.app.Nutrition.Produit;
import org.junit.Test;

public class NutrientsTest {

    @Test
    public void CreationNutrientsTest() {
        Produit ref = new Produit("test",67,3.2,0.5,6.3,0,4.7,
                0,6.3,0,0.6,610,0,0,0,0,
                0,0);
        assert(ref.getCalories() == 67);
        assert(ref.getSugars() == 6.3);
    }
}
