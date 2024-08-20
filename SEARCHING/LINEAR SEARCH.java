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
        boolean found = false;
        for(int i=0; i<size; i++) {
            if(arr[i] == search) {
                System.out.println("Element Found the Index at "+i);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Element Not Found!");
        }
    }
}
