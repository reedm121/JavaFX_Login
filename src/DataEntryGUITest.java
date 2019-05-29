import javafx.embed.swing.JFXPanel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataEntryGUITest {
    NameField n;
    PhoneField p;
    NameField [] names = new NameField[1];
    PhoneField [] phones = new PhoneField[1];
    CreateButton c;

    @Before
    public void initializeJFX(){
        JFXPanel panel = new JFXPanel();
        n = new NameField();
        p = new PhoneField();
        names[0] = n;
        phones[0] = p;
        c = new CreateButton(names, phones);
    }

    @Test
    public void checkGrayedName(){
        assertEquals("Name", n.getPromptText());
    }

    @Test
    public void checkGrayedPhone(){
        assertEquals("(###) ###-####", p.getPromptText());
    }

    @Test
    public void checkInvalidName(){
        n.setText("joe johnson");
        assertEquals(false, n.thisValid());
        n.setText("Ted");
        assertEquals(false, n.thisValid());
    }

    @Test
    public void checkValidName(){
        n.setText("Joe Johnson");
        assertEquals(true, n.thisValid());
        n.setText("Tom R");
        assertEquals(true, n.thisValid());
    }

    @Test
    public void checkInvalidPhone(){
        p.setText("111 222-3333");
        assertEquals(false, p.thisValid());
        p.setText("(111) 222 3333");
        assertEquals(false, p.thisValid());
    }

    @Test
    public void checkValidPhone(){
        p.setText("(111) 222-3333");
        assertEquals(true, p.thisValid());
        p.setText("(818) 612-6578");
        assertEquals(true, p.thisValid());
    }

    @Test
    public void checkNameColor(){
        n.setText("Mike Williams");
        n.thisValid();
        assertEquals("-fx-text-inner-color: black;", n.getStyle());
        n.setText("Mike");
        n.thisValid();
        assertEquals("-fx-text-inner-color: red;", n.getStyle());
    }

    @Test
    public void checkPhoneColor(){
        //invalid num
        p.setText("111 222-3333");
        p.thisValid();
        assertEquals("-fx-text-inner-color: red;", p.getStyle());

        //valid num
        p.setText("(818) 612-6578");
        p.thisValid();
        assertEquals("-fx-text-inner-color: black;", p.getStyle());
    }

    @Test
    public void checkButtonDisable(){
        n = new NameField();
        p = new PhoneField();
        names[0] = n;
        phones[0] = p;
        c = new CreateButton(names, phones);

        assertEquals(true, c.disabledProperty().getValue());

        n.setText("Nonempty string");
        p.setText("Another non empty");

        assertEquals(false, c.disabledProperty().getValue());
    }

    @Test
    public void checkErrorBox(){
        n = new NameField();
        p = new PhoneField();
        names[0] = n;
        phones[0] = p;
        n.setText("fkjjhsdflsdhfl");
        p.setText("fkjsdhfkjsdhfkj");
        c = new CreateButton(names, phones);

        //the isValid method is what determines which window appears
        assertEquals(false, c.isValid());
    }

    public void checkOnCorrectInputs(){
        n = new NameField();
        p = new PhoneField();
        names[0] = n;
        phones[0] = p;
        n.setText("Reed Gantz");
        p.setText("(111) 222-333");
        c = new CreateButton(names, phones);

        //the isValid method is what determines which window appears
        assertEquals(true, c.isValid());

        assertEquals(false, n.editableProperty());
        assertEquals(false, p.editableProperty());
    }

}