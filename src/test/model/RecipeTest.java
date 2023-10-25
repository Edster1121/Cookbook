package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    private Recipe testRecipe;
    private Recipe testRecipe1;

    @BeforeEach
    void runBefore(){
        testRecipe = new Recipe("Cookies");
        testRecipe1 = new Recipe("");
    }

    @Test
    void testConstructor(){
        assertEquals("Cookies", testRecipe.getRecipeName());
    }

    @Test
    void testAddIngredient(){
        testRecipe.addIngredient("butter");

        List<String> ingredients = testRecipe.getIngredients();

        assertEquals("butter", ingredients.get(0));
        assertEquals(1, ingredients.size());
    }

    @Test
    void testAddIngredientMultiple(){
        testRecipe.addIngredient("butter");
        testRecipe.addIngredient("sugar");

        List<String> ingredients = testRecipe.getIngredients();

        assertEquals("butter", ingredients.get(0));
        assertEquals("sugar", ingredients.get(1));
        assertEquals(2, ingredients.size());
    }

    @Test
    void testAddEquipment(){
        testRecipe.addEquipment("whisk");

        List<String> equipment = testRecipe.getEquipment();

        assertEquals("whisk", equipment.get(0));
        assertEquals(1, equipment.size());
    }

    @Test
    void testAddEquipmentMultiple(){
        testRecipe.addEquipment("whisk");
        testRecipe.addEquipment("bowl");

        List<String> equipment = testRecipe.getEquipment();

        assertEquals("whisk", equipment.get(0));
        assertEquals("bowl", equipment.get(1));
        assertEquals(2, equipment.size());
    }

    @Test
    void testAddStep(){
        testRecipe.addStep("Gather all ingredients!");

        List<String> steps = testRecipe.getSteps();

        assertEquals("Gather all ingredients!", steps.get(0));
        assertEquals(1, steps.size());
    }

    @Test
    void testAddStepMultiple(){
        testRecipe.addStep("Gather all ingredients!");
        testRecipe.addStep("Bake Cookies!");

        List<String> steps = testRecipe.getSteps();

        assertEquals("Gather all ingredients!", steps.get(0));
        assertEquals("Bake Cookies!", steps.get(1));
        assertEquals(2, steps.size());
    }

    @Test
    void testSetTime(){
        testRecipe.setTime(100);
        assertEquals(100, testRecipe.getTimeRequired());
    }

    @Test
    void testSetTimeReplacePrevTime(){
        testRecipe.setTime(100);
        testRecipe.setTime(150);
        assertEquals(150, testRecipe.getTimeRequired());
    }

    @Test
    void testSetAuthor(){
        testRecipe.setAuthor("Amanda");
        assertEquals("Amanda", testRecipe.getAuthor());
    }

    @Test
    void testSetAuthorReplacePrevAuthor(){
        testRecipe.setAuthor("Amanda");
        testRecipe.setAuthor("Brandon");
        assertEquals("Brandon", testRecipe.getAuthor());
    }

    @Test
    void testSetRating(){
        testRecipe.setRating(3);
        assertEquals(3, testRecipe.getRating());
    }

    @Test
    void testSetRatingReplacePrevRating(){
        testRecipe.setRating(3);
        testRecipe.setRating(5);
        assertEquals(5, testRecipe.getRating());
    }

    @Test
    void testClearIngredientsEmpty(){
        testRecipe.clearIngredients();
        assertTrue(testRecipe.getIngredients().isEmpty());
    }

    @Test
    void testClearIngredients(){
        testRecipe.addIngredient("sugar");
        testRecipe.addIngredient("flour");
        testRecipe.clearIngredients();

        assertTrue(testRecipe.getIngredients().isEmpty());
    }

    @Test
    void testClearStepsEmpty(){
        testRecipe.clearSteps();
        assertTrue(testRecipe.getSteps().isEmpty());
    }

    @Test
    void testClearSteps(){
        testRecipe.addStep("mix in bowl");
        testRecipe.addStep("bake in oven");
        testRecipe.clearSteps();
        assertTrue(testRecipe.getSteps().isEmpty());
    }

    @Test
    void testClearEquipmentEmpty(){
        testRecipe.clearEquipment();
        assertTrue(testRecipe.getEquipment().isEmpty());
    }

    @Test
    void testClearEquipment(){
        testRecipe.addEquipment("bowl");
        testRecipe.addEquipment("oven");
        testRecipe.clearEquipment();
        assertTrue(testRecipe.getEquipment().isEmpty());
    }

    @Test
    void testChangeRecipeNameEmptyString(){
        testRecipe1.changeRecipeName("Cheesecake");
        assertEquals("Cheesecake", testRecipe1.getRecipeName());
    }

    @Test
    void testChangeRecipeNameReplacePrev(){
        testRecipe.changeRecipeName("Fruit cake");
        assertEquals("Fruit cake", testRecipe.getRecipeName());
    }

}