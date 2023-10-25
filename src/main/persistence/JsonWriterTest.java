package persistence;

import model.Cookbook;
import model.Recipe;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class JsonWriterTest extends JsonTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            Cookbook cb = new Cookbook();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterEmptyCookbook() {
        try {
            Cookbook cb = new Cookbook();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(cb);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            cb = reader.read();
            assertTrue(cb.getListOfRecipe().isEmpty());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testWriterGeneralCookbook() {
        try {
            Cookbook cb = new Cookbook();
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
            cb.addRecipe(recipe1);
            cb.addRecipe(recipe2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(cb);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            cb = reader.read();
            List<Recipe> recipes = cb.getListOfRecipe();
            checkRecipe(recipe1, recipes.get(0));
            checkRecipe(recipe2, recipes.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
