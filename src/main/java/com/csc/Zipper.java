package com.csc;

import java.util.ArrayList;
import java.util.HashMap;

public class Zipper <T> {
    private ArrayList<T> list;

    public Zipper() {
        list = new ArrayList<>(); // Initializing list
    }

    public void zip(ArrayList<T> listOne,  ArrayList<T> listTwo) {
        ArrayList<T> largerList = (listOne.size() > listTwo.size()) ? listOne : listTwo;
        ArrayList<T> smallerList = (listOne.size() > listTwo.size()) ? listTwo : listOne;

        list.clear();

        for(int i = 0; i < largerList.size(); i++) {
            if(i < smallerList.size()) {
                list.add(largerList.get(i));
                list.add(smallerList.get(i));
            }
            else {
                list.add(largerList.get(i));
            }
        }
    }

    public void displayList() {
        for (T element : list) {
            System.out.println(element);
        }
    }

    public ArrayList<T> getList() {
        return list;
    }

    /** Resources
     * Java HashMap
     * Link: https://www.w3schools.com/java/java_hashmap.asp 
     * Author: W3Schools
     */
    public static <K, V> HashMap<K, V> hashmapify(ArrayList<K> keys, ArrayList<V> values) {
        HashMap<K, V> map = new HashMap<>(); // Create a new HashMap
    
        // Check if both lists are the same size
        if (keys.size() == values.size()) {
            for (int i = 0; i < keys.size(); i++) {
                map.put(keys.get(i), values.get(i)); // Bind keys and values together
            }
        } else {
            System.out.println("Error - lists not the same size!"); 
        }
    
        return map;
    }
    
    
}
