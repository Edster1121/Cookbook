package ui;

import model.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class references SmartHome
//represents the delete tab in the ui with a button and textfield
public class DeleteRecipeTab extends Tab implements ActionListener {

    private static final String INIT_GREETING = "Please choose a recipe to delete :)";
    private JLabel greeting;
    private CookbookState cookbookState;
    private JPanel panel;
    private JButton deleteButton;
    private JTextField deleteTextBox;


    //EFFECTS: constructs a delete recipe tab with a greeting
    public DeleteRecipeTab(CookieJarAppUI controller, CookbookState cookbookState) {
        super(controller);
        panel = new JPanel();

        deleteButton = new JButton();
        deleteTextBox = new JTextField("recipe name", 16);

        this.cookbookState = cookbookState;

        setLayout(new FlowLayout());

        placeGreeting();
        placeDeleteButtons();
    }

    //EFFECTS: creates greeting at top of page
    private void placeGreeting() {
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
    }

    //Modifies: this
    //EFFECTS: creates delete button that removes a recipe from the cookbook
    private void placeDeleteButtons() {
        JButton b1 = new JButton("Delete");
        this.add(deleteTextBox);

        JPanel buttonRow = formatButton(b1);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        deleteButton.addActionListener(this);
        this.add(panel);



        b1.addActionListener(e -> {
            this.cookbookState.myCookbook.removeRecipe(cookbookState.myCookbook.getRecipe(deleteTextBox.getText()));
        });

        this.add(buttonRow);
    }

    //Modifies: this, deleteTextbox
    //Effects: When button is pressed, removes recipe from cookbook if the string typed in text box is the equal to
    //the name of a recipe in the cookbook
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonPressed = e.getActionCommand();
        if (e.getSource() == deleteButton) {
            Recipe recipe = cookbookState.myCookbook.getRecipe(deleteTextBox.getText());
            cookbookState.myCookbook.removeRecipe(recipe);
            deleteTextBox.setText("recipe name");
        }

    }
}
