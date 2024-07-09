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
    public void swapadjacent() {
        Node temp = head;
        Node temp1 = null;

        while(temp != null && temp.next != null) {
            Node newNode = temp.next;
            temp.next = newNode.next;
            newNode.next = temp;

            if(temp1 == null) head = newNode;
            else temp1.next = newNode;
            
            temp1 = temp;
            temp = temp.next;
        }
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedlist l = new Linkedlist();
        l.insert(sc);
        l.swapadjacent();
        l.display();
    }
}
