package co.edu.uniquindio.poo.proyectosameday.viewController;

import javafx.application.Platform;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.List;
import java.util.stream.Collectors;

public class MethodsRecycle {

    public static void showAlert(String title, String message, Alert.AlertType type) {
        Alert alerta = new Alert(type);
        alerta.setTitle(title);
        alerta.setHeaderText(null);
        alerta.setContentText(message);
        alerta.showAndWait();
    }

    public static boolean checkEmail(String email){
        int count=0;

        for (char i: email.toCharArray()) {
            if(i == '@'){
                count++;
            }
        }

        return count == 1;
    }

    public static void setUpAutoComplete(TextField textField, List<String> data) {
        ContextMenu suggestions = new ContextMenu();
        suggestions.setAutoHide(true);

        textField.textProperty().addListener((obs, oldVal, newVal) -> {
            Platform.runLater(() -> {
                if (newVal == null || newVal.isBlank()) {
                    suggestions.hide();
                    return;
                }

                String lower = newVal.toLowerCase();
                List<String> matches = data.stream()
                        .filter(s -> s.toLowerCase().contains(lower))
                        .toList();

                if (matches.isEmpty()) {
                    suggestions.hide();
                } else {

                    List<CustomMenuItem> menuItems = matches.stream().map(match -> {
                        Label entry = new Label(match);
                        entry.setMinWidth(200);
                        CustomMenuItem item = new CustomMenuItem(entry, true);
                        item.setOnAction(e -> {
                            textField.setText(match);
                            textField.positionCaret(match.length());
                            suggestions.hide();
                        });
                        return item;
                    }).toList();

                    suggestions.getItems().clear();
                    suggestions.getItems().addAll(menuItems);

                    if (!suggestions.isShowing()) {
                        suggestions.show(textField, Side.BOTTOM, 0, 0);
                    }
                }
            });
        });

        textField.addEventFilter(KeyEvent.KEY_PRESSED, ke -> {
            if (ke.getCode() == KeyCode.DOWN) {
                // abrir el menú si hay items
                if (!suggestions.isShowing() && !suggestions.getItems().isEmpty()) {
                    suggestions.show(textField, Side.BOTTOM, 0, 0);
                }
            } else if (ke.getCode() == KeyCode.ENTER) {

                String typed = textField.getText();
                if (typed != null && !typed.isBlank()) {

                    data.stream()
                            .filter(s -> s.equalsIgnoreCase(typed))
                            .findFirst()
                            .ifPresent(m -> {
                                textField.setText(m);
                                textField.positionCaret(m.length());
                            });
                }
                suggestions.hide();
            } else if (ke.getCode() == KeyCode.ESCAPE) {
                suggestions.hide();
            }
        });

        textField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                suggestions.hide();
            }
        });
    }
}
