import java.util.Scanner;
class Main {
    // Memiosation
    public static int memo(int n, int dp[]) {
        if(n==0) return 0;
        if(n==1) return 1;
        // If answer is already calculated
        if(dp[n]!=0) return dp[n];
        int fnm1 = memo(n-1, dp);
        int fnm2 = memo(n-2, dp);
        dp[n] = fnm1 + fnm2;
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n+1];
        System.out.print(memo(n, dp));
    }
}
