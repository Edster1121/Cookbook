package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
}