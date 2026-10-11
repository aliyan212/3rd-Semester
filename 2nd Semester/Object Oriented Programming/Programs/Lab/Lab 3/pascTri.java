public class pascTri {
    public static void main(String[] args){
        int n = 5;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(fact(i)/(fact(j)*fact(i-j))+" ");
            }
            System.out.println();
        }
    }
    public static int fact(int n){
        if(n==0 || n==1){
            return 1;
        }
        else{
            return n*fact(n-1);
        }
    }
}
