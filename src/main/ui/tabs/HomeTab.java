package ui.tabs;

import com.sun.jdi.request.MonitorContendedEnteredRequest;
import ui.CookieJarAppUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class references SmartHome
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

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        image = new JLabel();
        image.setIcon(new ImageIcon("./data/Cookbook Image.jpg"));

        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
        this.add(image);
    }
}
