package com.csc;

import java.util.ArrayList;

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
}
