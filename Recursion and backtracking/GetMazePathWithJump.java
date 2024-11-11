import java.util.*;

public class getMazePathWithJump {

    // sc = start col, sr = start row
    // dc = destination col, dr = destination row
    static ArrayList<String> findPath(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> paths = new ArrayList<>();

        // horizontal path

        for (int hp = 1; hp <= dc - sc; hp++) {
            ArrayList<String> hpaths = findPath(sr, sc + hp, dr, dc);
            for (String hpath : hpaths) {
                paths.add("h" + hp + hpath);
            }
        }

        // vertical path

        for (int vp = 1; vp <= dr - sr; vp++) {
            ArrayList<String> vpaths = findPath(sr + vp, sc, dr, dc);
            for (String vpath : vpaths) {
                paths.add("v" + vp + vpath);
            }
        }

        // digonal path

        for (int dp = 1; dp <= dr - sr && dp <= dc - sc; dp++) {
            ArrayList<String> dpaths = findPath(sr + dp, sc + dp, dr, dc);
            for (String dpath : dpaths) {
                paths.add("d" + dp + dpath);
            }
        }

        return paths;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        ArrayList<String> st = findPath(1, 1, m, n);

        for (String s : st) {
            System.out.println(s);
        }
        sc.close();
    }
}
