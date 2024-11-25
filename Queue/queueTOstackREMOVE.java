import java.util.*;

public class queueTOstack {

    public static class queueStack {

        Queue<Integer> que;
        Queue<Integer> helpQue;

        public queueStack() {
            que = new ArrayDeque<>();
            helpQue = new ArrayDeque<>();
        }

        void add(int val) {

            while (que.size() > 0) {
                helpQue.add(que.remove());
            }

            que.add(val);

            while (helpQue.size() > 0) {
                que.add(helpQue.remove());
            }
        }

        int size() {
            return que.size();
        }

        int top() {
            if (que.size() == 0) {
                System.out.println("Stack is underflow");
                return -1;
            } else {
                return que.peek();
            }
        }

        int remove() {
            if (que.size() == 0) {
                System.out.println("Stack is underflow");
                return -1;
            } else {
                return que.remove();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        queueStack qst = new queueStack();

        qst.add(10);
        qst.add(20);
        qst.add(30);
        qst.add(40);
        qst.add(50);

        System.out.println(qst.size());
        System.out.println(qst.top());
        System.out.println(qst.remove());

        sc.close();
    }

}
