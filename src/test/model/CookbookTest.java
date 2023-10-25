package model;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CookbookTest {
    private Cookbook testCookbook;
    private Recipe testRecipe1;
    private Recipe testRecipe2;

    @BeforeEach
    void runBefore(){
        testCookbook = new Cookbook();
        testRecipe1 = new Recipe("Cookies");
        testRecipe2 = new Recipe("Cheesecake");
    }

    @Test //test for empty cookbook
    void testGetRecipeEmpty(){
        assertNull(testCookbook.getRecipe("Cookies"));
    }

    @Test //test for recipe in cookbook
    void testGetRecipeExists(){
        testCookbook.addRecipe(testRecipe1);

        assertEquals(testRecipe1, testCookbook.getRecipe("Cookies"));
    }

    @Test //test for recipe not in cookbook
    void testGetRecipeDoesNotExist(){
        testCookbook.addRecipe(testRecipe1);

        assertNull(testCookbook.getRecipe("Cakes"));
    }

    @Test //test for add one recipe
    void testAddRecipeOne(){
        testCookbook.addRecipe(testRecipe1);

        assertEquals(1, testCookbook.getListOfRecipe().size());
        assertEquals(testRecipe1, testCookbook.getListOfRecipe().get(0));
    }

    @Test //test for multiple recipes
    void testAddRecipeMultiple(){
        testCookbook.addRecipe(testRecipe1);
        testCookbook.addRecipe(testRecipe2);
        assertEquals(2, testCookbook.getListOfRecipe().size());
        assertEquals(testRecipe1, testCookbook.getListOfRecipe().get(0));
        assertEquals(testRecipe2, testCookbook.getListOfRecipe().get(1));
    }

    @Test //remove nothing
    void testRemoveRecipeNothing(){
        testCookbook.removeRecipe(testRecipe1);
        assertTrue(testCookbook.getListOfRecipe().isEmpty());
        assertEquals(0., testCookbook.getListOfRecipe().size());
    }

    @Test //test for remove one recipe
    void testRemoveRecipeOne(){
        testCookbook.addRecipe(testRecipe1);
        testCookbook.removeRecipe(testRecipe1);

        assertEquals(0, testCookbook.getListOfRecipe().size());
        assertTrue(testCookbook.getListOfRecipe().isEmpty());
    }

    @Test //test for remove recipe not in list
    void testRemoveRecipeNotInList(){
        testCookbook.addRecipe(testRecipe1);
        testCookbook.removeRecipe(testRecipe2);

        assertEquals(1, testCookbook.getListOfRecipe().size());
        assertEquals(testRecipe1, testCookbook.getListOfRecipe().get(0));
    }

    @Test //test for remove multiple recipes
    void testRemoveRecipeMultiple(){
        testCookbook.addRecipe(testRecipe1);
        testCookbook.addRecipe(testRecipe2);
        testCookbook.removeRecipe(testRecipe1);
        testCookbook.removeRecipe(testRecipe2);

        assertEquals(0, testCookbook.getListOfRecipe().size());
        assertTrue(testCookbook.getListOfRecipe().isEmpty());
    }

    @Test //test for remove one recipe in list with multiple recipes
    void testRemoveRecipeFromMultiple(){
        testCookbook.addRecipe(testRecipe1);
        testCookbook.addRecipe(testRecipe2);
        testCookbook.removeRecipe(testRecipe1);

        assertEquals(1, testCookbook.getListOfRecipe().size());
        assertEquals(testRecipe2, testCookbook.getListOfRecipe().get(0));
    }

    @Test
    void testToJson(){
        testCookbook.addRecipe(testRecipe1);
        JSONObject jsonObject = testCookbook.toJson();

        assertEquals(testCookbook.getRecipe("Cookies"), jsonObject.getJSONArray("recipes"));
    }
}