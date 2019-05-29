import javafx.scene.control.TextField;

public class NameField extends TextField {

    public NameField(){
        this.setPromptText(DataEntryGUI.N_PROMPT);

        this.setOnAction(e -> isName(this, this.getText()));

        this.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            // when focus lost
            if (!newValue) isName(this, this.getText());
        });
    }

    public boolean thisValid(){
        String text = this.getText();
        NameField input = this;
        if (text.contains(" ") && text.split(" ").length == 2 && text.length()<=20){
            String [] names = text.split(" ");
            if (Character.isUpperCase(names[0].charAt(0)) && Character.isUpperCase(names[1].charAt(0))){
                input.setStyle(MyGUI_Statics.BLACK_TEXTSTYLE);
                return true;
            }
        }
        input.setStyle(MyGUI_Statics.RED_TEXTSTYLE);
        return false;
    }

    static boolean isName(TextField input, String text){
        if (text.contains(" ") && text.split(" ").length == 2 && text.length()<=20){
            String [] names = text.split(" ");
            if (Character.isUpperCase(names[0].charAt(0)) && Character.isUpperCase(names[1].charAt(0))){
                input.setStyle(MyGUI_Statics.BLACK_TEXTSTYLE);
                return true;
            }
        }
        input.setStyle(MyGUI_Statics.RED_TEXTSTYLE);
        return false;
    }

}
