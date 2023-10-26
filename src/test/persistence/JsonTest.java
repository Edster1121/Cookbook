package persistence;

import model.Recipe;

import static org.junit.Assert.assertEquals;

public class JsonTest {
    protected void checkRecipe(Recipe ogrecipe, Recipe jsonrecipe) {
        assertEquals(ogrecipe.getRecipeName(), jsonrecipe.getRecipeName());
        assertEquals(ogrecipe.getIngredients(), jsonrecipe.getIngredients());
        assertEquals(ogrecipe.getEquipment(), jsonrecipe.getEquipment());
        assertEquals(ogrecipe.getSteps(), jsonrecipe.getSteps());
        assertEquals(ogrecipe.getTimeRequired(), jsonrecipe.getTimeRequired());
        assertEquals(ogrecipe.getAuthor(), jsonrecipe.getAuthor());
        assertEquals(ogrecipe.getRating(), jsonrecipe.getRating());
    }
}
