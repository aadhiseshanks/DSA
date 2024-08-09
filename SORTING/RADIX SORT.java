import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }
        int max = getMax(arr);
        
        for(int exp = 1; max/exp > 0; exp*=10) {
            countSort(arr, exp);
        }
        
        for(int i=0; i<size; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    
    public static void countSort(int arr[], int exp) {
        int count[] = new int[10];
        int result[] = new int[arr.length];
        
        for(int i=0; i<arr.length; i++) {
            count[(arr[i]/exp)%10]++;
        }
        
        for(int i=1; i<count.length; i++) {
            count[i] += count[i-1];
        }
        
        for(int i=arr.length-1; i>=0; i--) {
            result[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }
        
        for(int i=0; i<arr.length; i++) {
            arr[i] = result[i];
        }
    }
    
    public static int getMax(int arr[]) {
        int max = arr[0];
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
