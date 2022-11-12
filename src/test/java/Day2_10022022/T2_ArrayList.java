package Day2_10022022;

import java.util.ArrayList;

public class T2_ArrayList {
    //main method
    public static void main(String[] args) {
/*
arrayList are more preferred over arrays because you can append data at any point
and don't need to define size, making it more dynamic
*/
    //declare and define an arrayList of countries
    ArrayList<String> countries = new ArrayList<>();
    // now you can add values
    countries.add("USA");
    countries.add("Canada");
    countries.add("Mexico");
    countries.add("Bangladesh");
    countries.add("Japan");
    countries.add("China");
    // print out a value form the arrayList using get method
        System.out.println("country at index 2: "+countries.get(2));
    //get the size of the arrayList
        System.out.println("size of ayyayList: "+countries.size());


    }//end of main method

}//end of class
