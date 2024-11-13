import java.util.*;

public class printMazepathwithJump {

    // sc = start col, sr = start row
    // dc = destination col, dr = destination row

    static void findPath(int sr, int sc, int dr, int dc, String ans) {
        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }

        // horizontal path
        for (int hp = 1; hp <= dc - sc; hp++) {
            findPath(sr, sc + hp, dr, dc, ans + "h" + hp);
        }

        // vertical path
        for (int vp = 1; vp <= dr - sr; vp++) {
            findPath(sr + vp, sc, dr, dc, ans + "v" + vp);
        }

        // diagonal path
        for (int dp = 1; dp <= dr - sr && dp <= dc - sc; dp++) {
            findPath(sr + dp, sc + dp, dr, dc, ans + "d" + dp);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        findPath(1, 1, m, n, "");

        sc.close();
    }
}
