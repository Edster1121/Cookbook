package persistence;

import model.Recipe;
import model.Cookbook;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.json.*;

// This class references JsonSerializationDemo
// Represents a reader that reads cookbook from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads cookbook from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Cookbook read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCookbook(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private Cookbook parseCookbook(JSONObject jsonObject) {
        Cookbook cb = new Cookbook();
        addRecipes(cb, jsonObject);
        return cb;
    }

    // MODIFIES: cb
    // EFFECTS: parses recipes from JSON object and adds them to cookbook
    private void addRecipes(Cookbook cb, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("recipes");
        for (Object json : jsonArray) {
            JSONObject nextRecipe = (JSONObject) json;
            addRecipe(cb, nextRecipe);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addRecipe(Cookbook cb, JSONObject jsonObject) {
        String name = jsonObject.getString("recipe name");
        Recipe recipe = new Recipe(name);
        recipe.setIngredients(stringToList(jsonObject.getString("ingredients")));
        recipe.setEquipment(stringToList(jsonObject.getString("equipment")));
        recipe.setSteps(stringToList(jsonObject.getString("steps")));
        recipe.setRating(jsonObject.getInt("rating"));
        recipe.setAuthor(jsonObject.getString("author"));
        recipe.setTime(jsonObject.getInt("time required"));
        cb.addRecipe(recipe);
    }

    //EFFECTS: turns any string into a list by splitting at "/", returns list of string
    public List<String> stringToList(String items) {
        String[] listOfItems = items.split("/", 0);
        List<String> myItems = new ArrayList<>();

        for (String next : listOfItems) {
            myItems.add(next);
        }
        return myItems;
    }

}
