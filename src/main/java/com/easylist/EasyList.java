package com.easylist;

import java.util.List;

public class EasyList<E> extends EasyListImplementation<E>{
    public EasyList() {}

    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        EasyList<String> easyList = new EasyList<>();

        easyList.add("Food");
        easyList.add("Book");
        easyList.add("Phone");
        easyList.add("Bag");

        boolean hasFood = easyList.any(str -> str.equals("Food"));
        String book = easyList.firstOrNull(str -> str.equals("Book"));
        List<String> newList = easyList.reversed();

        try {
            var easyListRange = easyList.getRange(10, 15);
            System.out.println(easyListRange);
        } catch (EasyListException e) {
            System.out.println(e.toString());
        }

        System.out.println(hasFood);
        System.out.println(book);
        System.out.println(newList.toString());
    }
}