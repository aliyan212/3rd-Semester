public class CustomQueue {
    private int[] array;
    private int F, R;
    private int size;

    public CustomQueue(int Qsize) {
        this.size = Qsize;
        this.F = -1;
        this.R = -1;
        this.array = new int[size];
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Overflow.");
            return;
        } else if (F == -1 && R == -1) {
            F = R = 0;
            array[R] = item;
        } else {
            R++;
            array[R] = item;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow.");
            return -1;
        } else if (F == R) {
            int data = array[F];
            F = R = -1;
            return data;
        } else {
            int data = array[F];
            F++;
            return data;
        }
    }

    public boolean isFull() {
        return R == size - 1;
    }

    public boolean isEmpty() {
        return F == -1;
    }
}
