package Day2_10022022;

import java.util.ArrayList;

public class T3_forLoop {
    //main method
    public static void main(String[] args) {
        //arrayList
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("37894");
        zipCode.add("11459");

        /*
        for loops iterate through a something that can be repeated
        */
        //making a for loop
        for(int i=0; i<zipCode.size(); i++){
            /*
            i iterates through something, and after each increment, it will increase by 1(i++)
            and checks if it's less than or equal to ayyarList.size() which is the size of the arrayList.
            */
            System.out.println(zipCode.get(i));
        }//end of for loop

    }//end of main method

}//end of class
