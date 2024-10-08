import java.util.Scanner;
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null; 
    }
}
class Stack {
    Node top;

    Stack() {
        this.top = null;
    }

    void push(int d) {
        Node newNode = new Node(d);
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        if(isEmpty()) {
            System.out.println("Stack is Empty!!");
            return -1;
        }
        int PopValue = top.data;
        top = top.next;
        return PopValue;
    }

    boolean isEmpty() {
        return top == null;
    }

    void display() {
        if (top == null) {
            System.out.println("Stack is Empty!!");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of the Stack: ");
        int size = sc.nextInt();
        
        Stack s = new Stack();

        System.out.println("Enter the Elements to Push: ");
        for(int i=0; i<size; i++) {
            int data = sc.nextInt();
            s.push(data);
        }

        System.out.println("Display the Stack: ");
        s.display();

        System.out.println("If You want to Pop -> Press 1 Else Press 0");
        int val = sc.nextInt();
        if(val==1) {
            System.out.println("Enter the Number of times Pop the Elements: ");
            int pops = sc.nextInt();
            for(int i=0; i<pops; i++) s.pop();
        }

        System.out.println("Display the Stack: ");
        s.display();
    }
}
