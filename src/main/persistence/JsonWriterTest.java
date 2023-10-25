package persistence;

import model.Cookbook;
import model.Recipe;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
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
    void testWriterEmptyWorkroom() {
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
    void testWriterGeneralWorkroom() {
        try {
            Cookbook cb = new Cookbook();
            cb.addRecipe(new Recipe("Cookies"));
            cb.addRecipe(new Recipe("Cake"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(cb);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            cb = reader.read();
            List<Recipe> recipes = cb.getListOfRecipe();
            assertEquals(2, recipes.size());
            checkRecipe("Cookies", recipes.get(0));
            checkRecipe("Cake", recipes.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
