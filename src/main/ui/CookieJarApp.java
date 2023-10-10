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
            if (userInput.equals("add")) {
                System.out.println("What is the name of your recipe?");

                userInput = input.nextLine();
                initRecipe(userInput);

                System.out.println("What are the ingredients of your recipe? (add a '/' between each ingredient)");
                userInput = input.nextLine();
                processIngredients(userInput);

                System.out.println("What is the equipment needed for your recipe? (add a '/' between each equipment)");
                userInput = input.nextLine();
                processEquipment(userInput);

                System.out.println("What are the steps for your recipe? (add a '/' between each step)");
                userInput = input.nextLine();
                processSteps(userInput);

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
            } else if (userInput.equals("quit")) {
                running = false;
                System.out.println("Have a good day!");
            } else if (userInput.equals("check")) {
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
                            System.out.print(
                                    "\u001B[32m\t"
                                            + "Recipe:" + next.getRecipeName()
                                            + "\r\n"
                                            + "Ingredients:" + ingredientsToString(next.getIngredients())
                                            + "\r\n"
                                            + "Equipment:" + equipmentToString(next.getEquipment())
                                            + "\r\n"
                                            + "Steps:" + stepsToString(next.getSteps())
                                            + "\r\n"
                                            + "Author:" + " " + next.getAuthor()
                                            + "\r\n"
                                            + "Time Required:" + " " + timeToString(next.getTimeRequired())
                                            + "\r\n"
                                            + "Rating:" + ratingToString(next.getRating()) + "/5"
                                            + "\r\n"
                                            + "\u001B[0m");
                        }
                    }
                }
            }
        }
    }

    //Modifies: this
    //Effects: Turns ingredients list into a string
    private String ingredientsToString(List<String> ingredients) {
        String listSoFar = "";
        for (String next : ingredients) {
            listSoFar = listSoFar + " " + next;
        }
        return listSoFar;
    }

    //Modifies: this
    //Effects: Turns equipment list into a string
    private String equipmentToString(List<String> equipment) {
        String listSoFar = "";
        for (String next : equipment) {
            listSoFar = listSoFar + " " + next;
        }
        return listSoFar;
    }

    //Modifies: this
    //Effects: Turns steps list into a string
    private String stepsToString(List<String> steps) {
        String listSoFar = "";
        for (String next : steps) {
            listSoFar = listSoFar + " " + next;
        }
        return listSoFar;
    }

    //Modifies: this
    //Effects: turns time integer into a string
    private String timeToString(int time) {
        return Integer.toString(time);
    }

    //Modifies: this
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
        System.out.println("type 'add' to add a recipe!");
        System.out.println("type 'check' to check recipes in your cookbook so far!");
        System.out.println("type 'quit' to quit!");
    }

    //Requires: "/" between each ingredient in userInput
    //Modifies: this
    //Effects: splits string containing ingredients and adds each ingredient to listOfIngredients,
    //returns listOfIngredients
    private void processIngredients(String userInput) {
        String[] listOfIngredients = userInput.split("/", 0);

        for (String next : listOfIngredients) {
            myRecipe.addIngredient(next);
        }
    }

    //Requires: "/" between each equipment
    //Modifies: this
    //Effects: splits string containing equipment and adds each equipment to listOfEquipment, returns listOfEquipment
    private void processEquipment(String userInput) {
        String[] listOfEquipment = userInput.split("/", 0);

        for (String next : listOfEquipment) {
            myRecipe.addEquipment(next);
        }
    }

    //Requires: "/" between each step
    //Modifies: this
    //Effects: splits string containing steps and adds each step to listOfSteps, returns listOfSteps
    private void processSteps(String userInput) {
        String[] listOfSteps = userInput.split("/", 0);

        for (String next : listOfSteps) {
            myRecipe.addStep(next);
        }
    }

    //Requires: time is string with numerical digits and no letters and is a positive number
    //Modifies: this
    //Effects: sets userInput as an integer and sets recipe's time as userInput
    private void processTime(String userInput) {
        myRecipe.setTime(Integer.valueOf(userInput));
    }

    //Modifies: this
    //Effects: turns userInput into an integer and sets recipe's time as userInput
    private void processAuthor(String userInput) {
        myRecipe.setAuthor((userInput));
    }

    //Requires: rating is a string with numerical digits between 1-5 inclusive
    //Modifies: this
    //Effects: turns userInput into integer and sets recipe rating as userInput
    private void processRating(String userInput) {
        myRecipe.setRating(Integer.valueOf(userInput));
    }
}

