package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// This class references JsonSerializationDemo
// Represents a cookbook containing a list of recipes
public class Cookbook implements Writable {
    List<Recipe> cookbook; //cookbook contains recipes

    //Effects: creates an empty list of recipes
    public Cookbook() {
        this.cookbook = new ArrayList<>();
    }

    //Modifies: this
    //Effects: adds recipe to cookbook
    public void addRecipe(Recipe recipe) {
        this.cookbook.add(recipe);
        EventLog.getInstance().logEvent(new Event("added recipe " + "'" + recipe.getRecipeName() + "'"));
    }

    //Modifies: this
    //Effects: removes recipe from cookbook, does nothing if no recipes in cookbook;
    public void removeRecipe(Recipe recipe) {
        this.cookbook.remove(recipe);
        EventLog.getInstance().logEvent(new Event("removed recipe " + "'" + recipe.getRecipeName() + "'"));
    }

    //Modifies: this
    //Effects: returns recipe if the name of the recipe exists in the cookbook, otherwise null
    public Recipe getRecipe(String recipeName) {
        if (!(this.cookbook.isEmpty())) {
            for (Recipe next : this.cookbook) {
                if (next.getRecipeName().equals(recipeName)) {
                    return next;
                }
            }
        }
        return null;
    }

    public void makeRecord() {
        EventLog.getInstance().logEvent(new Event("viewed recipes"));
    }

    public List<Recipe> getListOfRecipe() {
        return this.cookbook;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("recipes", recipesToJson());
        return json;
    }

    // EFFECTS: returns recipes in this cookbook as a JSON array
    private JSONArray recipesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Recipe r : cookbook) {
            jsonArray.put(r.toJson());
        }

        return jsonArray;
    }

}