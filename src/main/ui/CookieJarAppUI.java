package ui;

import javax.swing.*;
import java.io.FileNotFoundException;

// This class references SmartHome
// Represents the gui of the application with tabs
public class CookieJarAppUI extends JFrame {
    private JTabbedPane sidebar;
    private CookbookState cookbookState;
    private static final int HOME_TAB_INDEX = 0;
    private static final int ADD_RECIPE_TAB_INDEX = 1;
    private static final int DELETE_TAB_INDEX = 2;
    private static final int VIEW_TAB_INDEX = 3;
    private static final int SAVE_TAB_INDEX = 4;
    private static final int LOAD_TAB_INDEX = 5;

    //Modifies: this
    //Effects: CookieJarAppUI, display sidebar and tabs
    public CookieJarAppUI() throws FileNotFoundException {
        cookbookState = new CookbookState();
        setTitle("CookieJar Application");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);


        loadTabs();
        add(sidebar);

        setVisible(true);
    }

    //Modifies: this
    //Effects: adds home tab, add tab, delete tab, and edit tab to this UI
    private void loadTabs() {
        JPanel homeTab = new HomeTab(this);
        JPanel addRecipeTab = new AddRecipeTab(this, cookbookState);
        JPanel deleteRecipeTab = new DeleteRecipeTab(this, cookbookState);
        JPanel viewRecipesTab = new ViewRecipesTab(this, cookbookState);
        JPanel saveTab = new SaveTab(this, cookbookState);
        JPanel loadTab = new LoadTab(this, cookbookState);
        ImageIcon icon = new ImageIcon("./data/Cookbook Image.jpg");

        sidebar.add(homeTab, HOME_TAB_INDEX);
        sidebar.setTitleAt(HOME_TAB_INDEX, "Home");

        sidebar.add(addRecipeTab, ADD_RECIPE_TAB_INDEX);
        sidebar.setTitleAt(ADD_RECIPE_TAB_INDEX, "Add Recipe");

        sidebar.add(deleteRecipeTab, DELETE_TAB_INDEX);
        sidebar.setTitleAt(DELETE_TAB_INDEX, "Delete Recipe");

        sidebar.add(viewRecipesTab, VIEW_TAB_INDEX);
        sidebar.setTitleAt(VIEW_TAB_INDEX, "View Recipes");

        sidebar.add(saveTab, SAVE_TAB_INDEX);
        sidebar.setTitleAt(SAVE_TAB_INDEX, "Save Recipes");

        sidebar.add(loadTab, LOAD_TAB_INDEX);
        sidebar.setTitleAt(LOAD_TAB_INDEX, "Load Recipes");
    }


}
