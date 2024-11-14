import java.util.*;

public class getMazepath {

    // sc = start col, sr = start row
    // dc = destination col, dr = destination row

    static ArrayList<String> findPath(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        // horizontal path
        ArrayList<String> hp = new ArrayList<>();

        // vertical path
        ArrayList<String> vp = new ArrayList<>();

        if (sc < dc) {
            hp = findPath(sr, sc + 1, dr, dc);
        }

        if (sr < dr) {
            vp = findPath(sr + 1, sc, dr, dc);
        }

        ArrayList<String> paths = new ArrayList<>();

        for (String hpath : hp) {
            paths.add("h" + hpath);
        }
        for (String vpath : vp) {
            paths.add("v" + vpath);
        }

        return paths;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        ArrayList<String> st = findPath(1, 1, m, n);

            System.out.println(st);
      
        sc.close();
    }
}
