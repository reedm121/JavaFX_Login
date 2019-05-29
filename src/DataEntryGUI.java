//Author: Reed Gantz

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DataEntryGUI extends Application {
    NameField[] names = new NameField[3];
    PhoneField[] phones = new PhoneField[3];
    CreateButton createBtn;

    //Static variables
    static String N_PROMPT = "Name";
    static String P_PROMPT = "(###) ###-####";

    @Override
    public void start(Stage primaryStage) throws Exception {
        for (int i = 0; i < 3; i++) {
            NameField n = new NameField();
            names[i] = n;
            PhoneField p = new PhoneField();
            phones[i] = p;
        }

        createBtn = new CreateButton(names, phones);
        createBtn.setStage(primaryStage);

        GridPane gridPane = new GridPane();
        //gridPane.setMinSize(400, 400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        VBox vertPane = new VBox();
        vertPane.setMinSize(400, 400);
        ObservableList list = vertPane.getChildren();
        vertPane.setAlignment(Pos.CENTER);

        for (int i = 0; i < names.length; i++) {
            gridPane.add(names[i], 0, i);
        }
        for (int i = 0; i < phones.length; i++) {
            gridPane.add(phones[i], 1, i);
        }

        list.addAll(gridPane, createBtn);

        Scene scene = new Scene(vertPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public NameField[] getNames() {
        return names;
    }

    public PhoneField[] getPhones() {
        return phones;
    }

    public CreateButton getCreateBtn() {
        return createBtn;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
