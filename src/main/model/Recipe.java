package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// This class references JsonSerializationDemo
// Represents a recipe with list of ingredients, list of equipment needed, list of steps in order of cooking process,
// time required to make dish, author of the recipe, and rating.
public class Recipe implements Writable {
    private String name;              //name of the dish
    private List<String> ingredients; //tracks list of ingredients in recipe
    private List<String> equipment;   //tracks list of equipment needed for recipe
    private List<String> steps;       //tracks list of steps required for recipe in the order of cooking
    private int timeRequired;         //tracks the time required for the recipe
    private String author;            //tracks the name of the author of recipe
    private int rating;               //tracks the rating of recipe from 1-5

    //Effects: creates a new recipe with name and intializes all components of the recipe
    public Recipe(String recipeName) {
        this.name = recipeName;
        this.ingredients = new ArrayList<>();
        this.equipment = new ArrayList<>();
        this.steps = new ArrayList<>();
        this.timeRequired = 0;
        this.author = "";
        this.rating = 1;
    }

    //Modifies: this
    //Effects: changes this.name to recipeName
    public void changeRecipeName(String recipeName) {
        this.name = recipeName;
    }

    //Modifies: this
    //Effects: clears ingredients list
    public void clearIngredients() {
        this.ingredients.clear();
    }

    //Modifies: this
    //Effects: clears steps list
    public void clearSteps() {
        this.steps.clear();
    }

    //Modifies: this
    //Effects: clears equipment list
    public void clearEquipment() {
        this.equipment.clear();
    }

    //Modifies: this
    //Effects: adds ingredient to ingredients list
    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    //Modifies: this
    //Effects: adds equipment to list of equipment
    public void addEquipment(String equipment) {
        this.equipment.add(equipment);
    }

    //Modifies: this
    //Effects: adds a step to the list of steps
    public void addStep(String step) {
        this.steps.add(step);
    }

    //Requires: time >=0, time is non-negative
    //Modifies: this
    //Effects: sets time in minutes, replaces previous time if exists
    public void setTime(int time) {
        this.timeRequired = time;
    }

    //Modifies: this
    //Effects: sets author, replaces previous author if exists
    public void setAuthor(String author) {
        this.author = author;
    }

    //Modifies: this
    //Effects: sets rating, replaces previous rating if exists, rating is 1-5 inclusive
    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRecipeName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public List<String> getSteps() {
        return steps;
    }

    public int getTimeRequired() {
        return timeRequired;
    }

    public String getAuthor() {
        return author;
    }

    public int getRating() {
        return rating;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    //Effects: returns ingredients list as a string
    public String ingredientsToString(List<String> ingredients) {
        StringBuilder listSoFar = new StringBuilder();
        for (String next : ingredients) {
            listSoFar.append(next).append("/");
        }
        return listSoFar.toString();
    }

    //Effects: returns equipment list as a string
    public String equipmentToString(List<String> equipment) {
        StringBuilder listSoFar = new StringBuilder();
        for (String next : equipment) {
            listSoFar.append(next).append("/");
        }
        return listSoFar.toString();
    }

    //Effects: returns steps list as a string
    public String stepsToString(List<String> steps) {
        StringBuilder listSoFar = new StringBuilder();
        for (String next : steps) {
            listSoFar.append(next).append("/");
        }
        return listSoFar.toString();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("recipe name", name);
        json.put("ingredients", ingredientsToString(ingredients));
        json.put("equipment", ingredientsToString(equipment));
        json.put("steps", ingredientsToString(steps));
        json.put("time required", timeRequired);
        json.put("author", author);
        json.put("rating", rating);
        return json;
    }

}
