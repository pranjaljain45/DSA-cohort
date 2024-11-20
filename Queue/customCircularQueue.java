import java.util.*;

public class customCircularQueue {

    public static class circularQueue {
        int[] data;
        int front; // start idx of queue
        int size;

        circularQueue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        void add(int val) {
            if (size == data.length) {
                System.out.println("Queue is overflow");
            } else {
                int rear = (front + size) % data.length; /*
                                                          * vo idx peeche se jis pr val add hogi isliye data.length se
                                                          * modulo liya hai
                                                          */
                data[rear] = val;
                size++;
            }
        }

        void display() {
            for (int i = 0; i < data.length; i++) {
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " ");
            }
        }

        int size() {
            return size;
        }

        int remove() {
            if (size == 0) {
                System.out.println("Queue is underflow");
                return -1;
            } else {
                int val = data[front];
                front = (front + 1) % data.length; /* start idx pr bhjne ke liye queue ke */
                size--;
                return val;
            }
        }

        int top() {
            if (size == 0) {
                System.out.println("Queue is underflow");
                return -1;
            } else {
                return data[front];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        circularQueue que1 = new circularQueue(n);

        que1.add(20);
        que1.add(30);
        que1.add(40);
        que1.add(50);
        que1.add(60);
        que1.add(70);

        que1.remove();
        que1.remove();
        que1.add(80);
        que1.add(90);

        que1.display();

        sc.close();
    }
}
