 class Main {
    static Node head = null;
    static class Node {
      int data;
      Node next;
    }

    static void insertatend(int d) { // d = 30
      Node newNode = new Node();
      newNode.data = d;
      newNode.next = null;

      if(head == null) {
          head = newNode;
      }
      else {
        Node temp = head;
        while(temp.next!=null) {
          temp = temp.next;
        }
        temp.next = newNode;
      }
    } 

    static void insertatbeg(int d) { // d = 50
      Node newNode = new Node();
      newNode.data = d;
      newNode.next = head;
      head = newNode;
    }

    static void insertafter(int d, int x) {
        Node newNode = new Node();
        newNode.data = d;
        newNode.next = null;

        Node temp = head;
        while(temp.data != x) {
          temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode; 
    }

    static void insertbefore(int d, int x) {
        Node newNode = new Node();
        newNode.data = d;
        newNode.next = null;

        Node prev = null, temp = head;
        while(temp.data!=x) {
          prev = temp;
          temp = temp.next;
        }
        newNode.next = temp;
        prev.next = newNode;
    }

    static void deleteatbeg() {
      Node temp = head;
      head = head.next;
      temp = null;
    }

    static void deleteatend() {
      Node temp = head, prev = head;
      while(temp.next != null) {
        prev = temp;
        temp = temp.next;
      }
      prev.next = null;
    }

    static void deleteatmid(int x) {
      Node temp = head;
      for(int i=1; i<x-1; i++) {
        temp = temp.next;
      }
      temp.next = temp.next.next;
    }

    static int search(int d) {
      Node temp = head;
      while(temp!=null) {
        if(temp.data == d) return 1;
        temp = temp.next;
      }
      return 0;
    }

    static void display() {
      Node temp = head;
      while(temp!=null) {
        System.out.println(temp.data);
        System.out.println(temp.next);
        temp = temp.next;
      }
    }
    public static void main(String[] args) {
      insertatend(10);
      insertatend(20);
      insertatend(30);
      insertatbeg(40);
      insertatbeg(50);
      insertafter(60, 10);
      insertbefore(70, 60);
      deleteatbeg();
      deleteatend(); 
      deleteatmid(3);
      display();
      System.out.println((search(60)==1)?"Node is Present":"Node is not Present");
    }
}
