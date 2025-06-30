import java.util.*;
class Main {
    public static void sort(int arr[], int left, int right) {
        if(left < right) {
            int pivotIndex = partition(arr, left, right);
            
            sort(arr, left, pivotIndex - 1);
            sort(arr, pivotIndex + 1, right);
        }
    }
    
    public static int partition(int arr[], int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        
        for(int j = left; j < right; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        
        return i + 1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }
        sort(arr, 0, arr.length - 1);
        for(int i : arr) {
            System.out.print(i+" ");
        }
    }
}
