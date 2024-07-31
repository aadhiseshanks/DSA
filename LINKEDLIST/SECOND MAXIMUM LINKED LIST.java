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
        for(int i=0; i<size; i++) {
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

    public void findSecondMax() {
        if (head == null || head.next == null) {
            System.out.println("List is Empty!!");
            return;
        }

        Node temp = head;
        int max = 0, secondMax = 0;

        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }
        
        temp = head;
        while (temp != null) {
            if (temp.data != max && temp.data > secondMax) {
                secondMax = temp.data;
            }
            temp = temp.next;
        }
        System.out.println(secondMax);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedlist l = new Linkedlist();
        int size = sc.nextInt();
        l.insert(sc, size);
        l.findSecondMax();
    }
}
