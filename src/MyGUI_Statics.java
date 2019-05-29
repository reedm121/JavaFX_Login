public class MyGUI_Statics {
    //Static variables
    static String N_PROMPT = "Name";
    static String P_PROMPT = "(###) ###-####";
    static String BLACK_TEXTSTYLE = "-fx-text-inner-color: black;";
    static String RED_TEXTSTYLE = "-fx-text-inner-color: red;";

    public static boolean nameCheck(String text) {
        if(text.contains(" ")&&text.split(" ").length ==2&&text.length()<=20)
        {
            String[] names = text.split(" ");
            if (Character.isUpperCase(names[0].charAt(0)) && Character.isUpperCase(names[1].charAt(0))) {
                //input.setStyle("-fx-text-inner-color: black;");
                return true;
            }
        }
        //input.setStyle("-fx-text-inner-color: red;");
        return false;
    }

    public static boolean phoneCheck(String text){
        if (text.matches("[(]\\d{3}[)] \\d{3}-\\d{4}")){
            return true;
        }
        return false;
    }


}
