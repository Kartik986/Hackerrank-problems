import java.util.Scanner;

public class Amazon {

    static int minRoutes(int a[][], int n, int m) {
        int noOfroutes=0;

        a: for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 9) {
                   break a;
                }
                else if (a[i][j] == 1){
                    int findRoute = isRoute(a, i, j, n, m);
                    noOfroutes = Math.min(findRoute, noOfroutes);
                }
            }
        }
        return noOfroutes;
    }

    static int isRoute(int[][] a, int i, int j, int n, int m) {

        if (i<0 || j<0 || i>=n || j>=m || a[i][j]==0) return 0;

        a[i][j] = 0;

        int right = isRoute(a, i, j+1, n, m);
        int down = isRoute(a, i+1, j, n, m);
        int left = isRoute(a, i, j-1, n, m);
        int up = isRoute(a, i-1, j, n, m);

        return right+down+left+up+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] allRoutes = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                allRoutes[i][j] = sc.nextInt();
            }
        }

        System.out.println(minRoutes(allRoutes, n, m));

        sc.close();
    }
}
