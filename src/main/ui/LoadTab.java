package ui;

import persistence.JsonReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//this class references SmartHome
//represents the load tab in the ui which allows the user to load a previously saved cookbook, has a button
public class LoadTab extends Tab implements ActionListener {
    private static final String JSON_STORE = "./data/cookbook.json";
    private JsonReader jsonReader;
    private CookbookState cookbookState;

    private static final String INIT_GREETING = "Please choose a recipe to load :)";
    private JLabel greeting;
    private JButton loadButton;



    //EFFECTS: constructs a load recipe tab for console with a greeting and load button
    public LoadTab(CookieJarAppUI controller, CookbookState cookbookState) {
        super(controller);
        jsonReader = new JsonReader(JSON_STORE);
        this.cookbookState = cookbookState;

        loadButton = new JButton("load");

        setLayout(new GridLayout(3, 1));

        placeGreeting();
        placeLoadButton();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
    }

    //EFFECTS: creates load button that reads cookbook from json
    private void placeLoadButton() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(loadButton);
        p.setSize(WIDTH, HEIGHT);

        loadButton.addActionListener(this);
        this.add(p);
    }

    //Effects: When button pressed, reads cookbook from Json and overwrites the currents cookbook with the cookbook
    //loaded from Json
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadButton) {
            try {
                cookbookState.myCookbook = jsonReader.read();
                System.out.println("Loaded cookbook from " + JSON_STORE);
            } catch (IOException ioe) {
                System.out.println("Unable to read from file: " + JSON_STORE);
            }
            System.out.println("loaded");
        }

    }
}
