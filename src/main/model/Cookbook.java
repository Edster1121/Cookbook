package model;

import java.util.ArrayList;
import java.util.List;

// Represents a cookbook containing a list of recipes
public class Cookbook {
    List<Recipe> cookbook; //cookbook contains recipes

    //Effects: creates an empty list of recipes
    public Cookbook() {
        this.cookbook = new ArrayList<>();
    }

    //Modifies: this
    //Effects: adds recipe to cookbook
    public void addRecipe(Recipe recipe) {
        this.cookbook.add(recipe);
    }

    //Modifies: this
    //Effects: returns recipe if the name of the recipe exists in the cookbook, otherwise null
    public Recipe getRecipe(String recipeName) {
        for (Recipe next : this.cookbook) {
            if (recipeName == next.getRecipeName()) {
                return next;
            }
        }
        return null;
    }

    public List<Recipe> getListOfRecipe() {
        return this.cookbook;
    }

}