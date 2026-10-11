import java.util.Scanner;
public class retail {
    public static double calculateDiscount(double price){
        return (price*5)/100;
        }
    
    public static double calculateDiscount(double price, int categoryCode){
        switch (categoryCode) {
            case 1:
                return (price*10)/100;
                case 2:
                    return (price*15)/100;
                default:
                    return price;
        }
    }
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.println("Enter the number of items you want to purchase");
       double num=sc.nextDouble();
       double grand=0;
       for(int i=0;i<num;i++){
        System.out.println("Please enter the product Price");
        double price=sc.nextDouble();
        System.out.println("Please enter the product category");
        int code=sc.nextInt();
        if(price<0){
            System.out.println("Invalid price");
            continue;
        }
        if(code==0){
            break;
        }else{
            price=calculateDiscount(price, code);
            System.out.println("Price of product" + i + "=" + price);
            grand=grand+price;
            }
        }
        System.out.println("Grand Total: " + grand);
       }
    }

