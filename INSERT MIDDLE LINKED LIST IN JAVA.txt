import java.util.Scanner;

class Linkedlist {
    Node head = null;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void insert(Scanner sc, int size) {
        for (int i = 0; i < size; i++) {
            int data = sc.nextInt();
            if (data == -1) break;
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
    }

    public void insertAtMiddle(int d, int pos) {
        Node newNode = new Node(d);

        if (pos < 0 || head == null) {
            System.out.println("Invalid position or List is empty");
            return;
        }

        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            if (temp.next == null) {
                System.out.println("Position out of bounds");
                return;
            }
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedlist l = new Linkedlist();
        int size = sc.nextInt();
        l.insert(sc, size);
        int data = sc.nextInt();
        int pos = sc.nextInt();
        l.insertAtMiddle(data, pos);
        l.display();
    }
}
