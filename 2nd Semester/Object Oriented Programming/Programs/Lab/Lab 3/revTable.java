public class revTable {
    public static void main(String[] args) {
        int num = 5;
        System.out.println("Reverse Table of " + num + ":");
        for (int i = 10; i >= 1; i--) {
            System.out.println(num + "x" + i + "=" + (num * i));
        }
    }
}
