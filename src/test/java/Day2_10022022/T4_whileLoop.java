
package Day2_10022022;

import java.util.ArrayList;

public class T4_whileLoop {
    //main method
    public static void main(String[] args) {
        //arrayList
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("37894");
        zipCode.add("11459");
        /*
        while loops are loops that will execute until the condition given is false
        */
        //making while loop
        int i =0;
        while(i<zipCode.size()){
            System.out.println("zipcode:"+zipCode.get(i));
            i +=1;

        }



    }//end of main method
}//end of class
