// Recursion
import java.util.Scanner;
public class Main
{
    public static int climbstairs(int n) {
        if ( n == 0 || n == 1 ) {
            return 1;
        }
        return climbstairs(n-1) + climbstairs(n-2);
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
		System.out.print(climbstairs(n));
	}
}

// Memoization
import java.util.Scanner;
public class Main {
    public static int climbstairs(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != 0) return dp[n];
        dp[n] = climbstairs(n-1, dp) + climbstairs(n-2, dp);
        return dp[n];
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int dp[] = new int[n+1];
		System.out.print(climbstairs(n, dp));
	}
}
