package ui.tabs;

import ui.CookieJarAppUI;

import javax.swing.*;
import java.awt.*;

//This class references SmartHome
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

    //Effects: creates and returns an area for large text areas
    public JPanel formatLabel(JLabel jl) {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(0,1));
        p.add(jl);

        return p;
    }

    //EFFECTS: returns the SmartHomeUI controller for this tab
    public CookieJarAppUI getController() {
        return controller;
    }

}
