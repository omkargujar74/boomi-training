import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ValidationTest {
    @Test
    public void testNameValidation() {
        List<String> names = new ArrayList<>();
        names.add("omkar");
        names.add("OMKAR");
        names.add("oMkar_Gujar");
        names.add("omkarpgujar");
        for (String name : names) {
            assertFalse(Day3Program.nameValidation(name));
        }
        assertTrue(Day3Program.nameValidation("Omkar"));
    }

    @Test
    public void testPasswordValidation() {
        List<String> passwords = new ArrayList<>();
        passwords.add("okmam123");
        passwords.add("123knsncinn");
        passwords.add("32653531668");
        passwords.add("gdcgg#@$gjgre");
        passwords.add("jhkhkAIGkdkjJ");
        passwords.add("i65jk6hjgjUHCFD42");
        passwords.add("tkcl@F0");
        passwords.add("dgcgG@*ju&$Y49u78h");

        for (String password : passwords) {
            assertFalse(Day3Program.passwordValidation(password));
        }
        assertTrue(Day3Program.passwordValidation("hdhG@fIB123"));
    }
}
