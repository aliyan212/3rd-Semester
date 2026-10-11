import java.util.Scanner;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front, rear;
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }
        int dequeued = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return dequeued;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }
        return front.data;
    }
    public boolean isEmpty() {
        return front == null;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class queueLinkList {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nQUEUE MENU\n1. Enqueue\n2. Dequeue\n3. Peek\n4. Check Empty\n5. Display\n6. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    queue.enqueue(sc.nextInt());
                    break;
                case 2:
                    System.out.println(queue.dequeue());
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
                case 4:
                    System.out.println(queue.isEmpty());
                    break;
                case 5:
                    queue.display();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
