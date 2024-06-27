package lk.ijse.util;

import javafx.scene.control.TextField;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class Validation {

    public static void validate(LinkedHashMap<TextField, Pattern> map2) {
        for (TextField key : map2.keySet()) {
            Pattern pattern = map2.get(key);
            if (pattern.matcher(key.getText()).matches()) {
                removeError(key);
            }else {
                addError(key);
            }
        }
    }
    private static void removeError(TextField key) {
        key.setStyle("-fx-border-color: green;");
    }
    private static void addError(TextField key) {
        key.setStyle("-fx-border-color: red;");
    }
}
