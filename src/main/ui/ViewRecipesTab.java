package ui;

import model.Cookbook;
import model.Recipe;

import ui.CookbookState;
import ui.CookieJarAppUI;
import ui.Tab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

//this class references SmartHome
public class ViewRecipesTab extends Tab implements ActionListener {
    private static final String INIT_GREETING = "Here are your recipes :)";
    private JLabel greeting;
    private CookbookState cookbookState;
    private JButton viewButton;
    private JPanel buttonPanel;
    private JPanel textPanel;
    private JLabel recipesText;
    private JLabel newRecipes;
    private JTable table;

    //EFFECTS: constructs a delete recipe tab for console with a greeting
    public ViewRecipesTab(CookieJarAppUI controller, CookbookState cookbookState) {
        super(controller);
        buttonPanel = new JPanel();
        textPanel = new JPanel();
        newRecipes = new JLabel();
        this.cookbookState = cookbookState;
        this.viewButton = new JButton("View Recipes");
        recipesText = new JLabel();

        setLayout(new GridLayout(0, 1));

        placeGreeting();
        placeRecipes();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setSize(1, 1);
        this.add(greeting);
    }

    //Effects: displays recipes
    private void placeRecipes() {
        buttonPanel = formatButton(viewButton);
        buttonPanel.setSize(WIDTH, HEIGHT / 4);
        recipesText.setSize(1000, 1000);
        viewButton.addActionListener(this);
        this.add(buttonPanel);
        this.add(textPanel);
        this.add(newRecipes);
    }

    //Effects: prints recipe specifics
    private void printRecipe(int i) {
        Recipe recipe = cookbookState.myCookbook.getListOfRecipe().get(i);
        String stringSoFar = recipesText.getText();
        if (!stringSoFar.contains(recipe.getRecipeName())) {
            recipesText.setText(stringSoFar + recipe.getRecipeName() + " "
                    + "Author:" + " " + recipe.getAuthor() + " "
                    + "Time Required: " + timeToString(recipe.getTimeRequired()) + " minutes "
                    + "Rating: " + ratingToString(recipe.getRating()) + "/5 "
                    + "Ingredients:" + ingredientsToString(recipe.getIngredients()) + " "
                    + "Equipment:" + equipmentToString(recipe.getEquipment()) + " "
                    + "Steps:"
                    + stepsToString(recipe.getSteps()));
            this.add(recipesText);
        }
    }


    //Effects: returns ingredients list as a string
    private String ingredientsToString(java.util.List<String> ingredients) {
        StringBuilder listSoFar = new StringBuilder();
        for (String next : ingredients) {
            listSoFar.append("\r\n").append(next);
        }
        return listSoFar.toString();
    }

    //Effects: returns equipment list as a string
    private String equipmentToString(java.util.List<String> equipment) {
        StringBuilder listSoFar = new StringBuilder();
        for (String next : equipment) {
            listSoFar.append("\r\n").append(next);
        }
        return listSoFar.toString();
    }

    //Effects: returns steps list as a string
    private String stepsToString(List<String> steps) {
        StringBuilder listSoFar = new StringBuilder();
        for (String next : steps) {
            listSoFar.append("\r\n").append(next);
        }
        return listSoFar.toString();
    }

    //Effects: returns time integer as a string
    private String timeToString(int time) {
        return Integer.toString(time);
    }

    //Requires: rating must be numerical integer in the form of a string
    //Effects: turns rating integer into a string
    private String ratingToString(int rating) {
        return Integer.toString(rating);
    }

    private String[][] addRecipeToList(Cookbook cookbook) {
        String[][] rowData = new String[cookbookState.myCookbook.getListOfRecipe().size()][7];
        List<Recipe> recipes = cookbookState.myCookbook.getListOfRecipe();
        for (int i = 0; i < cookbookState.myCookbook.getListOfRecipe().size(); i++) {
            rowData[i][0] = recipes.get(i).getRecipeName();
            rowData[i][1] = recipes.get(i).getAuthor();
            rowData[i][2] = Integer.toString(recipes.get(i).getRating());
            rowData[i][3] = Integer.toString(recipes.get(i).getTimeRequired());
            rowData[i][4] = ingredientsToString(recipes.get(i).getIngredients());
            rowData[i][5] = equipmentToString(recipes.get(i).getEquipment());
            rowData[i][6] = stepsToString(recipes.get(i).getSteps());
        }
        return rowData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton) {
            if (!cookbookState.myCookbook.getListOfRecipe().isEmpty()) {
                JFrame frame = new JFrame();
                frame.setSize(500, 500);
                frame.setVisible(true);
                String[] columns = {"Recipe name", "Author", "Time", "Rating", "Steps", "Equipment", "Ingredients"};
                String[][] rowData;
                rowData = addRecipeToList(cookbookState.myCookbook);
                table = new JTable(rowData, columns);
                JScrollPane tablePane = new JScrollPane(table);
                frame.add(tablePane);
            }
        }
    }
}
