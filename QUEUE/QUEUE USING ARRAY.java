import java.util.Scanner;
class Queue {
    int s[];
    int front, rear;

    Queue(int size) {
        s = new int[size];
        front = rear = -1;
    }

    void enqueue(int data) {
        if(rear == s.length-1) {
            System.out.println("Queue is Full!!");
        }
        else {
            if(front == -1) {
                front++;
            }
            s[++rear] = data;
        }
    }

    int dequeue() {
        if(front <= rear) return s[front++];
        else System.out.println("Queue is Empty!!");
        return -1;
    }

    void display() {
        if(front <= rear) {
            for(int i=front; i<=rear; i++) {
                System.out.print(s[i]+" ");
            }
            System.out.println();
        }
        else {
            System.out.println("Queue is Empty");
        }
    }

}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Size of Queue: ");
        int size = sc.nextInt();

        Queue q = new Queue(size);

        System.out.println("Enter the Elements to Queue: ");
        for(int i=0; i<size; i++) {
            int data = sc.nextInt();
            q.enqueue(data);
        }

        System.out.println("Display the Queue: ");
        q.display();

        System.out.println("If You Want to Dequeue Press 1 Else Press 0");
        int x = sc.nextInt();
        if(x == 1) {
            System.out.println("Enter the Times of Dequeue: ");
            int times = sc.nextInt();
            for(int i=0; i<times; i++) q.dequeue();
        }

        System.out.println("Display the Queue: ");
        q.display();
    }
}
