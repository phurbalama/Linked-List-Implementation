class Main {
  public static void main(String[] args) {
    
    LinkedList obj = new LinkedList();
    obj.head = new node();
    node temp = new node();
    node a = new node(3.5);
    node b = new node(4.5);
    node d = new node(9.9);
    obj.head = a;
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
  
  double value;
  node next;
  public node(){
    this.value = 0;
    next = null;
  }
  public node(double value){
    this.value = value;
    next = null;
  }
}
class LinkedList{
  node head;
}
