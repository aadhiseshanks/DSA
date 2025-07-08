import java.util.*;
class Main {
    public static List<Integer> getSunSet(int height[], String direction) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        
        if(direction.equals("WEST")) {
            for(int i=0; i<height.length; i++) {
                if(height[i] > max) {
                    stack.push(i);
                    max = height[i];
                }
            }
        }
        else if(direction.equals("EAST")) {
            for(int i=height.length - 1; i>=0; i--) {
                if(height[i] > max) {
                    stack.push(i);
                    max = height[i];
                }
            }
        }
        List<Integer> result = new ArrayList<>(stack);
        Collections.sort(result);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int height[] = new int[size];
        for(int i=0; i<size; i++) {
            height[i] = sc.nextInt();
        }
        String direction = sc.next();
        
        List<Integer> result = getSunSet(height, direction);
        
        System.out.print("Buildings with sunset views: ");
        for(int num : result) {
            System.out.print(num+" ");
        }
    }
}
