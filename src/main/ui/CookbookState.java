package ui;

import model.Cookbook;

//A concrete class with the state of the cookbook which is accessible to all classes in ui
public class CookbookState {
    protected Cookbook myCookbook;

    public CookbookState() {
        myCookbook = new Cookbook();
    }
}
