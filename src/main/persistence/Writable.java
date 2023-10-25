package persistence;

import org.json.JSONObject;

// This interface references JsonSerializationDemo
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}