import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateButton extends Button {
    NameField [] names;
    PhoneField [] phones;

    public CreateButton(NameField [] names, PhoneField [] phones) {
        this.names = names;
        this.phones = phones;
        this.setText("Create Profiles");

        for (int i = 0; i < names.length; i++) {
            int finalI = i;
            this.disableProperty().bind(Bindings.createBooleanBinding(
                    () -> names[finalI].getText().isEmpty(), names[finalI].textProperty()
            ));
        }
        for (int i = 0; i < phones.length; i++) {
            int finalI = i;
            this.disableProperty().bind(Bindings.createBooleanBinding(
                    () -> phones[finalI].getText().isEmpty(), phones[finalI].textProperty()
            ));
        }
    }

        public void setStage(Stage S){

            this.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    Label secondLabel = new Label();

                    String title;

                    if (!isValid()) {
                        secondLabel.setText("INVALID INPUT: you have attempted to provide one or more invalid " +
                                "input(s). Please correct the information displayed in red and retry.");
                        title = "Invalid input error";
                    } else {
                        secondLabel.setText("The profiles have been saved and added to the database");
                        title = "Data Saved";
                        for (int i=0; i<names.length; i++){
                            names[i].setEditable(false);
                        }
                        for(int i=0; i<phones.length; i++){
                            phones[i].setEditable(false);
                        }
                    }

                    secondLabel.setWrapText(true);

                    Button closeBtn = new Button();
                    closeBtn.setText("Close");

                    VBox secondaryLayout = new VBox();
                    secondaryLayout.getChildren().addAll(secondLabel, closeBtn);
                    secondaryLayout.setSpacing(10);
                    secondaryLayout.setAlignment(Pos.CENTER);

                    Scene secondScene = new Scene(secondaryLayout, 400, 100);

                    // New window (Stage)
                    Stage newWindow = new Stage();
                    newWindow.setTitle(title);
                    newWindow.setScene(secondScene);

                    // Set position of second window, related to primary window.
                    newWindow.setX(S.getX() + 200);
                    newWindow.setY(S.getY() + 100);

                    closeBtn.setOnAction(e -> newWindow.close());

                    newWindow.show();
                }
            });
        }

    public boolean isValid(){
        boolean b = true;
        for (int i=0; i<names.length; i++){
            b = b && names[i].thisValid();
        }
        for (int i=0; i<phones.length; i++){
            b = b && phones[i].thisValid();
        }
        return b;
    }

}
