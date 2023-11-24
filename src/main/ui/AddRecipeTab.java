package ui;

import model.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class references SmartHome
//represents the add tab in the ui which allows the user to add a recipe to their cookbook
public class AddRecipeTab extends Tab implements ActionListener {
    private static final String INIT_GREETING = "Please add a recipe below :)";
    private JLabel greeting;
    private JTextField name;
    private JTextField author;
    private JTextField time;
    private JTextField rating;
    private JTextField ingredients;
    private JTextField steps;
    private JTextField equipment;
    private CookbookState cookbookState;
    private Recipe recipe;
    private JButton addButton;
    private JPanel panel;

    //EFFECTS: constructs an add recipe tab with new button and textfields
    public AddRecipeTab(CookieJarAppUI controller, CookbookState cookbookState) {
        super(controller);
        panel = new JPanel();

        addButton = new JButton("Add Recipe!");

        this.cookbookState = cookbookState;
        setLayout(new GridLayout(3, 1));

        placeGreeting();
        placeNewRecipe();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
    }

    //Modifies: this
    //Effects: creates text-box for adding recipe
    private void placeNewRecipe() {
        panel = formatButton(addButton);
        panel.setSize(WIDTH, HEIGHT / 4);
        setFields();

        addButton.addActionListener(this);
        this.add(panel);
    }

    //Modifies: this
    //Effects: creates new text fields for each field of recipe: name, author, time, rating, ingredients, equipment,
    //steps and adds each to panel
    private void setFields() {
        name = new JTextField("recipe name", 16);
        panel.add(name);
        author = new JTextField("author", 16);
        panel.add(author);
        time = new JTextField("time required", 16);
        panel.add(time);
        rating = new JTextField("rating 1-5", 16);
        panel.add(rating);
        ingredients = new JTextField("ingredients", 16);
        panel.add(ingredients);
        steps = new JTextField("steps", 16);
        panel.add(steps);
        equipment = new JTextField("equipment", 16);
        panel.add(equipment);
    }

    //Modifies: this
    //Effects: splits string containing ingredients and adds each ingredient to listOfIngredients,
    // "/" between each ingredient in userInput
    private void processIngredients(String userInput) {
        String[] listOfIngredients = userInput.split("/", 0);

        for (String next : listOfIngredients) {
            recipe.addIngredient(next);
        }
    }

    //Modifies: this
    //Effects: splits string containing equipment and adds each equipment to listOfEquipment,
    // "/" between each equipment
    private void processEquipment(String userInput) {
        String[] listOfEquipment = userInput.split("/", 0);

        for (String next : listOfEquipment) {
            recipe.addEquipment(next);
        }
    }

    //Modifies: this
    //Effects: splits string containing steps and adds each step to listOfStep,
    // "/" between each equipment
    private void processSteps(String userInput) {
        String[] listOfSteps = userInput.split("/", 0);

        for (String next : listOfSteps) {
            recipe.addStep(next);
        }
    }

    //Modifies: this
    //Effects: When button is pressed, add each of the corresponding strings in each text box as item in recipe and
    //adds the recipe to the cookbook.
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonPressed = e.getActionCommand();
        if (e.getSource() == addButton) {
            recipe = new Recipe(name.getText());
            recipe.setAuthor(author.getText());
            try {
                recipe.setTime(Integer.parseInt(time.getText()));
                recipe.setRating(Integer.parseInt(rating.getText()));
            } catch (NumberFormatException nfe) {
                //do nothing
            }
            processIngredients(ingredients.getText());
            processEquipment(equipment.getText());
            processSteps(steps.getText());
            cookbookState.myCookbook.addRecipe(recipe);

            name.setText("recipe name");
            author.setText("author");
            time.setText("time required");
            rating.setText("rating 1-5");
            ingredients.setText("ingredients");
            steps.setText("steps");
            equipment.setText("equipment");
        }
    }

}
