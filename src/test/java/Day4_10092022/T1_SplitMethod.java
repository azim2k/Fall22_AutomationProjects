package Day4_10092022;

public class T1_SplitMethod {
    public static void main(String[] args) {
        String message = "My name is John";
        //split message using string array
        String [] arrayMessage = message.split(" ");//we use " " because the words are separated by space
        System.out.println("result is "+arrayMessage[3]);


        //extracting each character
        String message2 = "abc";
        String [] arrayMessage2 = message2.split("");//we use empty string because
        System.out.println("result is "+arrayMessage2[2]);

    }

}
