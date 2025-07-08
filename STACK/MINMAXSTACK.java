import java.util.*;
class Stack {
    private class Node {
    int data;
    int min;
    int max;
    Node next;
    
        Node(int data, int min, int max, Node next) {
            this.data = data;
            this.min = min;
            this.max = max;
            this.next = next;
        }
    }
    Node top;
    Stack() {
        this.top = null;
    }
    void push(int x) {
        if(top == null) {
            top = new Node(x, x, x, null);
        }
        else {
            int newMin = Math.min(x, top.min);
            int newMax = Math.max(x, top.max);
            top = new Node(x, newMin, newMax, top);
        }
    }
    void pop() {
        if(top != null) {
            top = top.next;
        }
    }
    int peek() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
        }
        return top.data;
    }
    boolean isEmpty() {
        return (top == null);
    }
    int getMin() {
        return top.min;
    }
    int getMax() {
        return top.max;
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        while(sc.hasNext()) {
            String input[] = sc.nextLine().split(" ");
            String command = input[0];
            switch(command) {
                case "push":
                    int x = Integer.parseInt(input[1]);
                    s.push(x);
                    break;
                case "pop":
                    s.pop();
                    break;
                case "peek":
                    System.out.println(s.peek());
                    break;
                case "getMin":
                    System.out.println(s.getMin());
                    break;
                case "getMax":
                    System.out.println(s.getMax());
                    break;
                case "exit":
                    return;
            }
        }
    }
}
