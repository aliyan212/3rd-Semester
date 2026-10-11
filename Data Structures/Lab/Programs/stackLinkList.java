import java.util.Scanner;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return -1;
        }
        return top.data;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class stackLinkList {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nSTACK MENU\n1. Push\n2. Pop\n3. Peek\n4. Check Empty\n5. Display\n6. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    stack.push(sc.nextInt());
                    break;
                case 2:
                    System.out.println(stack.pop());
                    break;
                case 3:
                    System.out.println(stack.peek());
                    break;
                case 4:
                    System.out.println(stack.isEmpty());
                    break;
                case 5:
                    stack.display();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
