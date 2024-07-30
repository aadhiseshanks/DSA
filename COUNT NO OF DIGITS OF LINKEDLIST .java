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

    public void insert(Scanner sc) {
        while (true) {
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

    public void display() {
        Node temp = head;
        while (temp != null) {
            int count = 0;
            int data = temp.data;
            for(;data != 0; data/=10, count++);
            System.out.print(count+"=>");
            temp = temp.next;
        }
        System.out.println("Null");
        
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedlist l = new Linkedlist();
        l.insert(sc);
        l.display();
        sc.close();
    }
}
