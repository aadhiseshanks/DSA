import java.util.Scanner;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class Queue {
    Node front, rear;
    Queue() {
        this.front = this.rear = null;
    }

    void enqueue(int data) {
        Node newNode = new Node(data);

        if(rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    int dequeue() {
        if(front == null) {
            System.out.println("Queue is Empty!!");
            return -1;
        }

        int data = front.data;
        front = front.next;

        if(front == null) {
            rear = null;
        }
        return data;
    }

    void display() {
        if(front == null) {
            System.out.println("Queue is Empty!!");
            return;
        }
        Node temp = front;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Size of Queue: ");
        int size = sc.nextInt();

        Queue q = new Queue();

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
