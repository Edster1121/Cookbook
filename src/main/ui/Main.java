package ui;

import java.io.FileNotFoundException;

//Runs the GUI and whole application
public class Main {
    public static void main(String[] args) {
        try {
            new CookieJarAppUI();
        } catch (FileNotFoundException fnfe) {
            System.out.println("did not expect exception");
        }
    }
}
