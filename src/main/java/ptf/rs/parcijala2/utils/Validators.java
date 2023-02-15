package ptf.rs.parcijala2.utils;

import java.util.regex.Pattern;

public class Validators {
    public static void checkRequiredField(String content, String fieldName) {
        if (content.isBlank()) throw new IllegalStateException(fieldName + " is required");
    }

    public static void checkMinLength(String content, int length, String fieldName) {
        if (content.length() < length) throw new IllegalStateException(fieldName + " must be at least " + length + " characters long");
    }

    public static void checkMaxLength(String content, int length, String fieldName) {
        if (content.length() > length) throw new IllegalStateException(fieldName + " cannot be longer than " + length + " characters");
    }

    public static void checkPositiveInteger(int content, String fieldName) {
        if(content < 0) throw new IllegalStateException(fieldName + " cannot be a negative value");
    }
    public static void checkPositiveDouble(double content, String fieldName) {
        if(content < 0) throw new IllegalStateException(fieldName + " cannot be a negative value");
    }
}
