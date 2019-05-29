import javafx.scene.control.TextField;

public class PhoneField extends TextField {

    public PhoneField(){
        this.setPromptText(DataEntryGUI.P_PROMPT);

        this.setOnAction(e -> isPhone(this, this.getText()));

        this.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            // when focus lost
            if (!newValue) isPhone(this, this.getText());
        });
    }

    public boolean thisValid(){
        String text = this.getText();
        PhoneField input = this;
        if (text.matches("[(]\\d{3}[)] \\d{3}-\\d{4}")){
            input.setStyle(MyGUI_Statics.BLACK_TEXTSTYLE);
            return true;
        }
        else {
            input.setStyle(MyGUI_Statics.RED_TEXTSTYLE);
        }
        return false;
    }

    static boolean isPhone(TextField input, String text){
        if (text.matches("[(]\\d{3}[)] \\d{3}-\\d{4}")){
            input.setStyle(MyGUI_Statics.BLACK_TEXTSTYLE);
            return true;
        }
        else {
            input.setStyle(MyGUI_Statics.RED_TEXTSTYLE);
        }
        return false;
    }
}
