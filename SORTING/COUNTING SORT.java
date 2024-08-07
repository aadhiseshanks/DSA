import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = getMax(arr);
        int min = getMin(arr);
        int range = max - min + 1;
        int count[] = new int[range];
        int result[] = new int[arr.length];

        for(int i=0; i<arr.length; i++) {
            count[arr[i] - min]++;
        }

        for(int i=1; i<count.length; i++) {
            count[i] = count[i] + count[i-1];
        }

        for(int i=arr.length-1; i>=0; i--) {
            result[--count[arr[i] - min]] = arr[i];
        }

        for(int i=0; i<result.length; i++) {
            arr[i] = result[i];
        }

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
    public static int getMax(int arr[]) {
        int max = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int getMin(int arr[]) {
        int min = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
