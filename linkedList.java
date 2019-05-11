class Main {
  public static void main(String[] args) {
    
    //creating a Linked linkedlist obj with empty constructor
    LinkedList obj = new LinkedList();
    //the linkedlist head will be a new node
    obj.head = new node();
    node temp = new node();
    node a = new node(3.5);
    node b = new node(4.5);
    node d = new node(9.9);
    obj.head = a;
    //connecting nodes to the next node using .next 
    
    a.next = b;
    b.next = d;


    double sum = 0;  
    
    System.out.println("Print using for Loop ");
for(temp = obj.head;temp!=null;temp = temp.next){
  
  System.out.println(temp.value);
  sum= sum + temp.value;



}
System.out.println("Printing using while Loop");
 temp = obj.head;
 while(temp!=null){

   System.out.println(temp.value);
   temp = temp.next;
 }

 System.out.println("Total Sum : "+ sum);
  }
}


  class node {
  
  int value;
  node next;
  public node(){
    this.value = 0;
    next = null;
  }
  public node(int value){
    this.value = value;
    next = null;
  }
}
class LinkedList{
  node head;
  void insertBeginning(int x){
    node newNode = new Node(x);
    newNode.next = head;
    head = newNode;
  }
  //push to the last element in the linkedlist
  void push(int x){
    node temp = head;
    while(temp!= null){
      
      temp = temp.next;
    }
    node newNode = new node(x);
    temp.next = newNode;
  
}
