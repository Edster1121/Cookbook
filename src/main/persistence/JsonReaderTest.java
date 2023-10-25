package persistence;

import model.Cookbook;
import model.Recipe;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Cookbook cb = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyCookbook() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
        try {
            Cookbook cb = reader.read();
            assertTrue(cb.getListOfRecipe().isEmpty());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralCookbook() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            Cookbook cb = reader.read();
            List<Recipe> recipes = cb.getListOfRecipe();
            assertEquals(2, recipes.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
