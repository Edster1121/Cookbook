package model;

import java.util.ArrayList;
import java.util.List;

// Represents a recipe with list of ingredients, list of equipment needed, list of steps in order of cooking process,
// time required to make dish, author of the recipe, and rating.
public class Recipe {
    private String name;              //name of the dish
    private List<String> ingredients; //tracks list of ingredients in recipe
    private List<String> equipment;   //tracks list of equipment needed for recipe
    private List<String> steps;       //tracks list of steps required for recipe in the order of cooking
    private int timeRequired;         //tracks the time required for the recipe
    private String author;            //tracks the name of the author of recipe
    private int rating;               //tracks the rating of recipe from 1-5

    //Effects: sets name to recipeName, set ingredients, equipment, steps to empty
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
    //Effects: adds ingredient to list of ingredients in list
    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    //Modifies: this
    //Effects: adds a piece of equipment to list of equipment
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

    //Requires: 1<= rating <= 5, rating is 1-5 inclusive
    //Modifies: this
    //Effects: sets rating, replaces previous rating if exists
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


}
