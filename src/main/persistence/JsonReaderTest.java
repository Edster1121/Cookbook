package persistence;

import model.Cookbook;
import model.Recipe;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class JsonReaderTest extends JsonTest {

    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Cookbook cb = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testReaderEmptyCookbook() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCookbook.json");
        try {
            Cookbook cb = reader.read();
            assertTrue(cb.getListOfRecipe().isEmpty());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderGeneralCookbook() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCookbook.json");
        try {
            Cookbook cb = reader.read();
            List<Recipe> recipes = cb.getListOfRecipe();
            Recipe recipe1 = new Recipe("Cookies");
            recipe1.addIngredient("Butter");
            recipe1.addStep("Bake in Oven");
            recipe1.addEquipment("Oven");
            recipe1.setTime(45);
            recipe1.setRating(5);
            recipe1.setAuthor("Eddie");
            Recipe recipe2 = new Recipe("Cake");
            recipe2.addIngredient("Flour");
            recipe2.addStep("Bake in cool oven");
            recipe2.addEquipment("Tray");
            recipe2.setTime(100);
            recipe2.setRating(2);
            recipe2.setAuthor("Michael");

            assertEquals(2, recipes.size());
            checkRecipe(recipe1, recipes.get(0));
            checkRecipe(recipe2, recipes.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
