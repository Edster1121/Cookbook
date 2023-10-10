package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class CookbookTest {
    private Cookbook testCookbook;
    private Recipe testRecipe;

    @BeforeEach
    void runBefore(){
        testCookbook = new Cookbook();
        testRecipe = new Recipe("Cookies");
    }

    @Test //test for empty cookbook
    void testGetRecipeEmpty(){
        assertNull(testCookbook.getRecipe("Cookies"));
    }

    @Test //test for recipe in cookbook
    void testGetRecipeExists(){
        testCookbook.addRecipe(testRecipe);
        testCookbook.getRecipe("Cookies");
    }
}