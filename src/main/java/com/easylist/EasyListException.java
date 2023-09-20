package com.easylist;

public class EasyListException extends Exception {

    public static String NEW_LENGTH_MUST_BE_NON_NEGATIVE = "New length must be non-negative";

    public static String INDEX_OUT_OF_BOUNDS = "Index out of bounds";

    public static String LIST_IS_EMPTY = "List is empty";

    public static String INVALID_START_OR_END = "Invalid start or end index";

    public static String EASY_EXCEPTION_LIST = "Error in Easy List";


    public EasyListException(String string) {
        super(string);
    }

    public EasyListException() {
        super(EASY_EXCEPTION_LIST);
    }
}
