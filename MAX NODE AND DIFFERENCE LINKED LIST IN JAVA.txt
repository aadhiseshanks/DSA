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

    public int sum() {
        Node temp = head;
        int sum = 0;
        while (temp != null) {
            sum += temp.data;
            temp = temp.next;
        }
        return sum;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Linkedlist l1 = new Linkedlist();
        l1.insert(sc);
        int sum1 = l1.sum();

        Linkedlist l2 = new Linkedlist();
        l2.insert(sc);
        int sum2 = l2.sum();

        Linkedlist l3 = new Linkedlist();
        l3.insert(sc);
        int sum3 = l3.sum();

        int maxSum;
        Linkedlist maxList;

        if (sum1 >= sum2 && sum1 >= sum3) {
            maxSum = sum1;
            maxList = l1;
        } else if (sum2 >= sum1 && sum2 >= sum3) {
            maxSum = sum2;
            maxList = l2;
        } else {
            maxSum = sum3;
            maxList = l3;
        }

        int minSum = Math.min(sum3, Math.min(sum1, sum2));

        int difference = maxSum - minSum;

        maxList.display();
        System.out.println(maxSum);
        System.out.println(difference);
    }
}
