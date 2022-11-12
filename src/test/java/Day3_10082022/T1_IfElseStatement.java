package Day3_10082022;
public class T1_IfElseStatement {
    public static void main(String[] args) {
        //declaring
        int a, b,c;
        //defining
        a = 2;
        b = 2;
        c= 4;
        //verify if a less than b or not
        if(a+b < c){
            System.out.println("a plus b is less than c");
        }
        else if (a+b>c) {
            System.out.println("a plus b is greater than c");
        }
        else{
            System.out.println("a plus b is equal to c");
        }//end of if else


    }//end of main
}//end of class
