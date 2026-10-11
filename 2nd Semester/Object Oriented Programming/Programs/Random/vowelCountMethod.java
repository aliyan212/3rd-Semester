package Random;
import java.util.Scanner;
public class vowelCountMethod {
    public static int countVowel(String str){
        int count=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                count++;
        }
    }
    return count;
}
public static void main(String[] args) {
    String str="Hello World!";
    int count=countVowel(str);
    System.out.println("The number of vowels in the string is: " + count);
}
}
