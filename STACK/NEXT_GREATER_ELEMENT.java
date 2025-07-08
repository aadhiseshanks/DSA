import java.util.*;
class Main {
    public static int[] nextGreaterElement(int arr[]) {
        int n = arr.length;
        int result[] = new int[n];
        Arrays.fill(result, -1);
        
        Stack<Integer> stack = new Stack<>();
        for(int i=2*n-1; i>=0; i--) {
            int curIndex = i % n;
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[curIndex]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                result[curIndex] = arr[stack.peek()];
            }
            stack.push(curIndex);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }
        int res[] = nextGreaterElement(arr);
        for(int num : res) {
            System.out.print(num+" ");
        }
    }
}
