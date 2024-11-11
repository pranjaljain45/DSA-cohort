import java.util.*;

public class getStairpath {

    static ArrayList<String> findPath(int n) {
        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        else if (n < 0) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }

        ArrayList<String> path1 = findPath(n - 1);
        ArrayList<String> path2 = findPath(n - 2);
        ArrayList<String> path3 = findPath(n - 3);

        ArrayList<String> paths = new ArrayList<>();

        for (String path : path1) {
            paths.add("1" + path);
        }
        for (String path : path2) {
            paths.add("2" + path);
        }
        for (String path : path3) {
            paths.add("3" + path);
        }

        return paths;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<String> path = findPath(n);

        for (String s : path) {
            System.out.println(s);
        }
        sc.close();
    }
}
