package Day3_10082022;
public class T3_methods {
    //create a void method that will add two numbers and execute the print statement
    public static void addTwoNumbers(int a, int b){
        /*
        we use void to say it doesn't return anything
        public is to make it visible to other classes
        static to say that other classes can use the method
         */
        System.out.println((a+b)); //we use parentheses
    }//end of addTwo method

    /*
    we use a variable type in the place of void to return a data type
    example: public static int subtract(int a, int b){
    int c = a+b;
    return c
    }//end of subtract method
    we use have to write return at the end and return the same data type you stated in the method sp in our example it was int
     */
    //create a method that will subtract 2 numbers and return the result
    public static int subtractTwoNumbers(int a, int b){
        System.out.println("hello this is my name");
        int c = a-b;
        return (c);
    }
}//end of class
