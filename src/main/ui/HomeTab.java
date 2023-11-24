package ui;

import javax.swing.*;
import java.awt.*;

//this class references SmartHome
//represents the home tab in the ui with an image and a greeting
public class HomeTab extends Tab {

    private static final String INIT_GREETING = "Welcome!";
    private JLabel greeting;
    private JLabel image;

    //EFFECTS: constructs a home tab for console with a greeting
    public HomeTab(CookieJarAppUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));

        placeGreeting();
    }

    //Modifies: this
    //EFFECTS: creates and places greeting at top of console
    private void placeGreeting() {
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        image = new JLabel();
        image.setIcon(new ImageIcon("./data/Cookbook Image.jpg"));

        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
        this.add(image);
    }
}
