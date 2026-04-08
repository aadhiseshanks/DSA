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
