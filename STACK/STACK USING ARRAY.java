import java.util.Scanner;
class Stack {
    int s[];
    int top;

    Stack(int size) {
        s = new int[size];
        top = -1;
    }

    void push(int data) {
        if(top == s.length - 1) {
            System.out.println("Stack is Full!!");
        }
        else s[++top] = data;
    }

    int pop() {
        if(top==-1) System.out.println("Stack is Empty!!");
        else top--;
        return -1;
    }

    void display() {
        for(int i=top; i>=0; i--) {
            System.out.print(s[i]+" ");
        }
        System.out.println();
    }

}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of the Stack: ");
        int size = sc.nextInt();
        
        Stack s = new Stack(size);

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
