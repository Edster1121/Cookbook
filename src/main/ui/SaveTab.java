package ui;

import persistence.JsonWriter;
import ui.CookbookState;
import ui.CookieJarAppUI;
import ui.Tab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

//this class references SmartHome
//represents the save tab in the ui which allows the user to save their current cookbook to Json, has a button
public class SaveTab extends Tab implements ActionListener {
    private static final String JSON_STORE = "./data/cookbook.json";
    private JsonWriter jsonWriter;

    private static final String INIT_GREETING = "Please choose a recipe to save :)";
    private JLabel greeting;
    private CookbookState cookbookState;
    private JPanel panel;
    private JButton saveButton;


    //EFFECTS: constructs a save recipe tab for console with a greeting
    public SaveTab(CookieJarAppUI controller, CookbookState cookbookState) {
        super(controller);
        panel = new JPanel();
        jsonWriter = new JsonWriter(JSON_STORE);

        saveButton = new JButton("save");

        this.cookbookState = cookbookState;

        setLayout(new GridLayout(3, 1));

        placeGreeting();
        placeSaveButton();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
    }

    //Modifies: this
    //EFFECTS: creates save button to save from json
    private void placeSaveButton() {
        JPanel buttonRow = formatButton(saveButton);
        buttonRow.setSize(WIDTH, HEIGHT);

        saveButton.addActionListener(this);
        this.add(panel);

        this.add(buttonRow);
    }

    //Effects: When button pressed, writes the current cookbook to Json.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            try {
                jsonWriter.open();
                jsonWriter.write(cookbookState.myCookbook);
                jsonWriter.close();
                System.out.println("Saved cookbook to " + JSON_STORE);
            } catch (FileNotFoundException fnfe) {
                System.out.println("Unable to write to file: " + JSON_STORE);
            }
            System.out.println("saved");
        }

    }
}
