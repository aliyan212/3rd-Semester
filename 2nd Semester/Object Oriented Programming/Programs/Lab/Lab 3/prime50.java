public class prime50 {
    public static void main(String[] args) {
		for (int i = 1; i < 50; i++) {
			int isPrime = 1;
			for (int j = 2; j <= 20; j++) {
				if(i!=j){
                    if (i % j == 0)  {
                        isPrime = 0;
                        break;
                    }
                }
			}
			if (isPrime == 1) {
				System.out.println(i);
			}
		}
    }
}
