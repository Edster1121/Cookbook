package ui;

import ui.CookieJarAppUI;

import javax.swing.*;
import java.awt.*;

//This class references SmartHome
//Represents a parent class which formats buttons into rows
public abstract class Tab extends JPanel {

    private final CookieJarAppUI controller;

    //REQUIRES: CookieJarAppUI controller that holds this tab
    public Tab(CookieJarAppUI controller) {
        this.controller = controller;
    }

    //EFFECTS: creates and returns row with button included
    public JPanel formatButton(JButton b) {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);

        return p;
    }

}
