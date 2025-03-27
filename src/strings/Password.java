package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    public static boolean validatePassword(String str) {
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@&#]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static void main(String[] args) {
        System.out.println(validatePassword("yellow5@"));
        System.out.println(validatePassword("pass1@")); // false
        System.out.println(validatePassword("pass1@#5"));
    }
}
