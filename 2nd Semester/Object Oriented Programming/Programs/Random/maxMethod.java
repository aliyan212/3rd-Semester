package Random;
import java.util.Scanner;
public class maxMethod {
    public static int max(int arr[]){
        int max=arr[0];
        for(int num:arr){
            if(num>max){
                max=num;
            }
        }
        return max;
    }
    public static void main(String[] args){
        int arr[]= {5,10,2,23, 42};
        int max = max(arr);
        System.out.println("The maximum value in the array is: " + max);
    }
}
