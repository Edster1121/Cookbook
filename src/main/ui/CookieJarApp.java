package ui;

import model.Cookbook;
import model.Recipe;

import java.util.List;
import java.util.Scanner;

// This code references the TellerApp
// Cookbook Application
public class CookieJarApp {
    private Cookbook myCookbook;
    private Scanner input;
    private Recipe myRecipe;

    //Effects: runs the CookieJar Application
    public CookieJarApp() {
        input = new Scanner(System.in);
        myCookbook = new Cookbook();
        runCookieJar();
    }

    //Modifies: this
    //Effects: runs user input
    @SuppressWarnings("methodlength")
    private void runCookieJar() {
        boolean running = true;
        String userInput;

        while (running) {
            displayMenu();
            userInput = input.nextLine();
            switch (userInput) {
                case "add":
                    processAddInput();
                    break;
                case "edit":
                    processEditInput();
                    break;
                case "delete":
                    processDeleteInput();
                    break;
                case "quit":
                    running = false;
                    System.out.println("Have a good day!");
                    break;
                case "check":
                    processCheckInput();
                    break;
            }
        }
    }

    @SuppressWarnings("methodlength")
    private void processEditInput() {
        String userInput;
        if (myCookbook.getListOfRecipe().isEmpty()) {
            System.out.println("This cookbook is empty");
        } else {
            System.out.println("Here is a list of recipes:");
            for (Recipe next : myCookbook.getListOfRecipe()) {
                System.out.println("\u001B[32m\t" + next.getRecipeName() + "\u001B[0m");
                System.out.println("Please type the name of the recipe you would like to edit from the cookbook");
            }
            userInput = input.nextLine();
            for (Recipe next : myCookbook.getListOfRecipe()) {
                if (userInput.equals(next.getRecipeName())) {
                    showRecipeSpecifics(next);
                }
            }
            boolean keepGoing = true;
            Recipe userRecipe = myCookbook.getRecipe(userInput);
            while (keepGoing) {
                System.out.println("What would you like to edit?");
                System.out.println("type 'name' to change this recipe name");
                System.out.println("type 'ingredients' to change the ingredients in this recipe");
                System.out.println("type 'equipment' to change the equipment in this recipe");
                System.out.println("type 'steps' to change the steps in this recipe");
                System.out.println("type 'author' to change the author in this recipe");
                System.out.println("type 'time' to change the time required in this recipe");
                System.out.println("type 'rating' to change the rating of this recipe");
                System.out.println("type 'exit' to go back to the MAIN MENU");

                userInput = input.nextLine();
                if (userInput.equals("name")) {
                    System.out.println("Please enter a new recipe name");
                    userInput = input.nextLine();
                    userRecipe.changeRecipeName(userInput);
                    System.out.println("Successfully changed the recipe name :)");
                } else if (userInput.equals("author")) {
                    System.out.println("Please choose a new author name");
                    userInput = input.nextLine();
                    processAuthor(userInput);
                    System.out.println("Successfully changed the author name :)");
                } else if (userInput.equals("time")) {
                    System.out.println("Please type a new time (Type in numerical digits in minutes)");
                    userInput = input.nextLine();
                    processTime(userInput);
                    System.out.println("Successfully changed the time required for this recipe :)");
                } else if (userInput.equals("rating")) {
                    System.out.println("Please choose a new rating (use numerical digits 1-5)");
                    userInput = input.nextLine();
                    processRating(userInput);
                    System.out.println("Successfully changed the rating of this recipe :)");
                } else if (userInput.equals("ingredients")) {
                    System.out.println("Please add new ingredients (add a '/' between each ingredient)");
                    userInput = input.nextLine();
                    userRecipe.clearIngredients();
                    processIngredients(userInput);
                    System.out.println("Successfully changed the ingredients list :)");
                } else if (userInput.equals("equipment")) {
                    System.out.println("Please add new equipment (add a '/' between each ingredient)");
                    userInput = input.nextLine();
                    userRecipe.clearEquipment();
                    processIngredients(userInput);
                    System.out.println("Successfully changed the equipment list :)");
                } else if (userInput.equals("steps")) {
                    processSteps();
                    System.out.println("Successfully changed the steps list :)");
                } else if (userInput.equals("exit")) {
                    keepGoing = false;
                } else {
                    System.out.println("Sorry I don't understand that command :(");
                }
            }
        }
    }

    //Modifies: this
    //Effects: process if userInput is "delete"
    private void processDeleteInput() {
        String userInput;
        if (myCookbook.getListOfRecipe().isEmpty()) {
            System.out.println("This cookbook is empty");
        } else {
            System.out.println("Here is a list of recipes:");
            for (Recipe next : myCookbook.getListOfRecipe()) {
                System.out.println("\u001B[32m\t" + next.getRecipeName() + "\u001B[0m");
                System.out.println("Please type the name of the recipe you would like to delete from the cookbook");
            }
            userInput = input.nextLine();
            Recipe userRecipe = myCookbook.getRecipe(userInput);
            if (myCookbook.getListOfRecipe().contains(userRecipe)) {
                myCookbook.removeRecipe(userRecipe);
                System.out.println("Successfully deleted recipe from cookbook");
            } else {
                System.out.println("Sorry, I couldn't find that recipe in the cookbook");
            }

        }
    }


    //Modifies: this
    //Effects: process if userInput is "check"
    private void processCheckInput() {
        String userInput;
        if (myCookbook.getListOfRecipe().isEmpty()) {
            System.out.println("This cookbook is empty");
        } else {
            System.out.println("Here is a list of recipes:");
            for (Recipe next : myCookbook.getListOfRecipe()) {
                System.out.println("\u001B[32m\t" + next.getRecipeName() + "\u001B[0m");
            }
            System.out.println("Type the name of your recipe to view recipe specifics :)");
            userInput = input.nextLine();
            for (Recipe next : myCookbook.getListOfRecipe()) {
                if (userInput.equals(next.getRecipeName())) {
                    showRecipeSpecifics(next);
                }
            }

        }
    }

    //Effects: Prints the specifics of recipe
    private void showRecipeSpecifics(Recipe next) {
        System.out.print(
                "\u001B[32m\t"
                        + "Recipe: " + next.getRecipeName()
                        + "\r\n"
                        + "Author:" + " " + next.getAuthor()
                        + "\r\n"
                        + "Time Required: " + timeToString(next.getTimeRequired()) + " minutes"
                        + "\r\n"
                        + "Rating: " + ratingToString(next.getRating()) + "/5"
                        + "\r\n"
                        + "Ingredients:" + ingredientsToString(next.getIngredients())
                        + "\r\n"
                        + "Equipment:" + equipmentToString(next.getEquipment())
                        + "\r\n"
                        + "Steps:"
                        + stepsToString(next.getSteps()).substring(0, stepsToString(next.getSteps()).length() - 1)
                        + "\r\n"
                        + "\u001B[0m");
    }

    //Modifies: this
    //Effects: processes if userInput is "add"
    private void processAddInput() {
        String userInput;
        System.out.println("What is the name of your recipe?");

        userInput = input.nextLine();
        initRecipe(userInput);

        System.out.println("What are the ingredients of your recipe? (add a '/' between each ingredient)");
        userInput = input.nextLine();
        processIngredients(userInput);

        System.out.println("What is the equipment needed for your recipe? (add a '/' between each equipment)");
        userInput = input.nextLine();
        processEquipment(userInput);

        processSteps();

        System.out.println("Who is the author of this recipe?");
        userInput = input.nextLine();
        processAuthor(userInput);

        System.out.println("How long does this recipe take to make? Type in numerical digits in minutes.");
        userInput = input.nextLine();
        processTime(userInput);

        System.out.println("What is your rating of this recipe? (use numerical digits 1-5)");
        userInput = input.nextLine();
        processRating(userInput);

        System.out.println("Successfully added recipe to your cookbook!");
    }

    //Effects: Turns ingredients list into a string
    private String ingredientsToString(List<String> ingredients) {
        StringBuilder listSoFar = new StringBuilder();
        for (String next : ingredients) {
            listSoFar.append("\r\n").append(next);
        }
        return listSoFar.toString();
    }

    //Effects: Turns equipment list into a string
    private String equipmentToString(List<String> equipment) {
        StringBuilder listSoFar = new StringBuilder();
        for (String next : equipment) {
            listSoFar.append("\r\n").append(next);
        }
        return listSoFar.toString();
    }

    //Effects: Turns steps list into a string
    private String stepsToString(List<String> steps) {
        StringBuilder listSoFar = new StringBuilder();
        for (String next : steps) {
            listSoFar.append("\r\n").append(next);
        }
        return listSoFar.toString();
    }

    //Effects: turns time integer into a string
    private String timeToString(int time) {
        return Integer.toString(time);
    }

    //Requires: rating must be numerical integer in the form of a string
    //Effects: turns rating integer into a string
    private String ratingToString(int rating) {
        return Integer.toString(rating);
    }

    //Modifies: this
    //Effects: initializes new recipe and adds this recipe to the cookbook
    private void initRecipe(String userInput) {
        myRecipe = new Recipe(userInput);
        myCookbook.addRecipe(myRecipe);
    }

    //Effects:displays menu to user
    private void displayMenu() {
        System.out.println("\u001B[34m\t" + "MAIN MENU" + "\u001B[0m");
        System.out.println("type 'add' to add a recipe!");
        System.out.println("type 'delete' to add a recipe!");
        System.out.println("type 'edit' to edit a recipe!");
        System.out.println("type 'check' to check recipes in your cookbook so far!");
        System.out.println("type 'quit' to quit!");
    }

    //Modifies: this
    //Effects: splits string containing ingredients and adds each ingredient to listOfIngredients,
    // "/" between each ingredient in userInput
    private void processIngredients(String userInput) {
        String[] listOfIngredients = userInput.split("/", 0);

        for (String next : listOfIngredients) {
            myRecipe.addIngredient(next);
        }
    }

    //Modifies: this
    //Effects: splits string containing equipment and adds each equipment to listOfEquipment,
    // "/" between each equipment, returns listOfEquipment
    private void processEquipment(String userInput) {
        String[] listOfEquipment = userInput.split("/", 0);

        for (String next : listOfEquipment) {
            myRecipe.addEquipment(next);
        }
    }

    //Modifies: this
    //Effects: adds string steps to the recipe, finishes once userInput
    private void processSteps() {
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("Write a step and hit the 'enter' key once finished writing the step, type 'done'"
                    + " when finished writing out all of the steps.");
            String userInput = input.nextLine();
            if (userInput.equals("done")) {
                keepGoing = false;
            } else {
                myRecipe.addStep(userInput);
            }
        }
    }


    //Requires: time is string with numerical digits and no letters and is a positive number
    //Modifies: this
    //Effects: sets userInput as an integer and sets recipe's time as userInput
    private void processTime(String userInput) {
        myRecipe.setTime(Integer.parseInt(userInput));
    }

    //Modifies: this
    //Effects: turns userInput into an integer and sets recipe's time as userInput
    private void processAuthor(String userInput) {
        myRecipe.setAuthor(userInput);
    }

    //Requires: rating is a string which can be converted into an integer e.g. "4" "5"
    //Modifies: this
    //Effects: turns userInput into integer and sets recipe rating as userInput, rating is 1-5 inclusive
    private void processRating(String userInput) {
        int ratingInt = Integer.parseInt(userInput);
        myRecipe.setRating(Integer.parseInt(userInput));
    }
}

