import java.util.*;

public class printMazepath {

    // sc = start col, sr = start row
    // dc = destination col, dr = destination row

    static void findPath(int sr, int sc, int dr, int dc, String ans) {
        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }

        if (sr > dr && sc > dc) {
            return;
        }

        findPath(sr, sc + 1, dr, dc, ans + "h");
        findPath(sr + 1, sc, dr, dc, ans + "v");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        findPath(1, 1, m, n, "");

        sc.close();
    }
}

