package Random;
import java.util.Scanner;
public class methodSum {
    public static int sum(int arr[]){
        int sum=0;
        for(int num:arr){
            sum=sum+num;
        }
        return sum;
    }
    public static void main(String[] args){
        int arr[]={1,2,3,4,5};
        int result=sum(arr);
        System.out.println("The sum of the array is: "+result);
    }
}
