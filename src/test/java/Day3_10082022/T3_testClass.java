package Day3_10082022;

public class T3_testClass {
    public static void main(String[] args) {
        //we're going to use the methods from methods class into this class
        T3_methods.addTwoNumbers(4,5);//T3_methods.addTwoNumbers(7,6);//this is how we call methods from other classes.
        //notice that we didn't use a sout here because you cant use that for a void method
        System.out.println(T3_methods.subtractTwoNumbers(9,5)); //here we can use sout
        //we can also use return methods and store it in a variable of the same data type of the return method
        int result = T3_methods.subtractTwoNumbers(8,3);
        System.out.println(result);
        T3_methods.subtractTwoNumbers(4,5);
        T3_methods name = new T3_methods();
        name.addTwoNumbers(2,4);

    }
}
