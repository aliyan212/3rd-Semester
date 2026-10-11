public class CircularQueue {
    private int[] Array;
    private int F, R, size;

    public CircularQueue(int Qsize) {
        this.size = Qsize;
        this.F = -1;
        this.R = -1;
        this.Array = new int[size];
    }

    public void enqueue(int item) {
        if (isEmpty()) {
            F = R = 0;
            Array[R] = item;
        } else {
            R = (R + 1) % size;
            if (R == F) {
                System.out.println("Queue is full");
                R = (R - 1 + size) % size;
            } else {
                Array[R] = item;
            }
        }
    }

    public int dequeue() {
        int item = -1;
        if (!isEmpty()) {
            item = Array[F];
            if (F == R) {
                F = R = -1;
            } else {
                F = (F + 1) % size;
            }
        } else {
            System.out.println("Empty Queue");
        }

        return item;
    }

    public boolean isEmpty() {
        return F == -1;
    }
}
