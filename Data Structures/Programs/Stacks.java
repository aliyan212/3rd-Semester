public class Stacks {
    private int top;
    private int maxSize;
    private int[] StackArray;

    public Stacks(int size) {
        this.top = -1;
        this.maxSize = size;
        this.StackArray = new int[maxSize];
    }

    public void push(int el) {
        if (isFull()) {
            System.out.println("The stack is overflowed");
            return;
        }
        StackArray[++top] = el;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("The stack is underflowed");
            return -1;
        }
        return StackArray[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty. push some elements");
            return -1;
        }
        return StackArray[top];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void insertAt(int index, int value) {
        if (isFull()) {
            System.out.println("Stack is already full");
            return;
        }
        if (index < 0 || index > top) {
            System.out.println("index is out of bound");
            return;
        }
        for (int i = top; i >= index; i--) {
            StackArray[i + 1] = StackArray[i];
        }
        StackArray[index] = value;
        top++;
    }

    public void deleteAt(int index) {
        if (isEmpty()) {
            System.out.println("Stack is already empty");
            return;
        }
        if (index < 0 || index > top) {
            System.out.println("index is out of bound");
            return;
        }
        for (int i = index; i < top; i++) {
            StackArray[i] = StackArray[i + 1];
        }
        top--;
    }

    public static String reverseUsingStack(String input) {
        Stacks stack = new Stacks(input.length());

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String reversedString = "";
        while (!stack.isEmpty()) {
            reversedString += (char) stack.pop();
        }

        return reversedString;
    }

    public static void main(String[] args) {
        String original = "ABC";
        String reversed = reverseUsingStack(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}
