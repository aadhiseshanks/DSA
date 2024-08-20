import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Array Size: ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the Array Element: ");
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the Search Element: ");
        int search = sc.nextInt();
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length -1;
        boolean found = false;
        while(left <= right) {
            int mid = (left+right)/2;
            if(arr[mid] == search) {
                System.out.println("Element Found at Index "+mid);
                found = true;
                break;
            }
            else if(arr[mid] < search) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if(!found) {
            System.out.println("Element Not Found!!");
        }
    }
}
