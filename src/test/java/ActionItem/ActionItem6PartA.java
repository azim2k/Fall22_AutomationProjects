package ActionItem;
import java.util.ArrayList;
public class ActionItem6PartA {
    public static void main(String[] args) {
        //declare and define String ArrayList of countries
        ArrayList<String> countries= new ArrayList<>();
        countries.add("USA");
        countries.add("Bangladesh");
        countries.add("Australia");
        countries.add("Spain");

        //declare and define integer Array list for country code
        ArrayList<Integer> countryCode= new ArrayList<>();
        countryCode.add(1);
        countryCode.add(880);
        countryCode.add(61);
        countryCode.add(34);
        //for loop to iterate through the Arraylist
        for (int i = 0; i <countryCode.size() ; i++) {
            System.out.println("My country is "+countries.get(i)+ " and my country code is +"+countryCode.get(i));
        }//end of for loop
    }//end of main method
}//end of class

