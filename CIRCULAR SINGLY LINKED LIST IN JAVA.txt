// Circular Singly Linked List
class Main {
  static Node head = null;
  static class Node {
    int data;
    Node next;
  }

  static void insertatend(int d) {
    Node newNode = new Node();
    newNode.data = d;
    newNode.next = null;

    if(head == null) {
      newNode.next = newNode;
      head = newNode;
    }
    else {
      Node temp = head;
      while(temp.next != head) {
        temp = temp.next;
      }
      temp.next = newNode;
      newNode.next = head;
    }
  }
  static void insertatbeg(int d) {
    Node newNode = new Node();
    newNode.data = d;
    newNode.next = null;

    Node temp = head;
    newNode.next = head;
    while(temp.next != head) {
      temp = temp.next;
    }
    temp.next = newNode;
    head = newNode;
  }
  
  static void display() {
    Node temp = head;
    do {
      System.out.println(temp.data);
      System.out.println(temp.next);
      temp = temp.next;
    } while(temp!=head);
  }
  
  public static void main(String[] args) {
    insertatend(10);
    insertatend(20);
    insertatend(30);
    insertatbeg(40);
    display();    
  }
}
