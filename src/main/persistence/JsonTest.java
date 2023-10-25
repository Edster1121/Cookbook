package persistence;

import model.Recipe;

import static org.junit.Assert.assertEquals;

public class JsonTest {
    protected void checkRecipe(String name, Recipe recipe) {
        assertEquals(name, recipe.getRecipeName());
    }
}
