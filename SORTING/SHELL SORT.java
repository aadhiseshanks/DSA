import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int gap = n/2;
        
        while(gap > 0) {
            for(int i=gap; i<n; i++) {
                int temp = arr[i];
                int j = i;
                
                while(j >= gap && arr[j-gap] > temp) {
                    arr[j] = arr[j - gap];
                    j = j-gap;
                }
                arr[j] = temp;
            }
            gap /= 2;
        }
        
        for(int i=0; i<n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
