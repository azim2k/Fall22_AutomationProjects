package Day2_10022022;

public class T1_LinearArray {
    //main method
    public static void main(String[] args) {
        //declare a string array variable
        String[] zipCode, streetNumber; //we can have multiple variables of the same data types separated by commas.

        //defining zipcode values for the linear straight arrays
        zipCode = new String[]{"11218","11258","11239","12568"};

        //print a value from the array. Remember index starts at 0
        System.out.println("zip code: "+zipCode[2]+","+zipCode[3]);

    }//end of main method

}//end of class
