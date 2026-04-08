// Recursion
import java.util.Scanner;
public class Main {
    public static int houserob(int[] arr, int i) {
        if (i >= arr.length) return 0;
        int inc = arr[i] + houserob(arr, i+2);
        int exc = houserob(arr, i+1);
        return Math.max(inc, exc);
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int arr[] = new int[n];
	    for(int i=0; i<n; arr[i] = sc.nextInt(), i++);
		System.out.print(houserob(arr, 0));
	}
}

// Memoization
import java.util.Scanner;
public class Main {
    public static int houserob(int[] arr, int[] dp, int i) {
        if (i >= arr.length) return 0;
        if (dp[i] != 0) return 0;
        int inc = arr[i] + houserob(arr, dp, i+2);
        int exc = houserob(arr, dp, i+1);
        dp[i] = Math.max(inc, exc);
        return dp[i];
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int arr[] = new int[n];
	    for(int i=0; i<n; arr[i] = sc.nextInt(), i++);
	    int dp[] = new int[n+1];
		System.out.print(houserob(arr, dp, 0));
	}
}

// Tabulation
import java.util.Scanner;
public class Main {
    public static int houserob(int[] arr, int[] dp) {
        int n = arr.length;
        for(int i = n - 1; i >= 0; i--) {
            int inc = arr[i] + (i + 2 < n ? dp[i+2] : 0);
            int exc = (i + 1 < n ? dp[i+1] : 0);
            dp[i] = Math.max(inc, exc);
        }
        return dp[0];
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int arr[] = new int[n];
	    for(int i=0; i<n; arr[i] = sc.nextInt(), i++);
	    int dp[] = new int[n+1];
		System.out.print(houserob(arr, dp));
	}
}
