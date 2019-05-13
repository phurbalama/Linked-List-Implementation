import java.util.Scanner;

public class linkedlist {
	
	node head;

	 class node{
		String value;
		node next;
		
		public node() {
			value = "";
			next = null;
		}
	 
		public node(String val)
		{
			value = val;
			next = null;
		}
	 }
	
		public void printlist() {
			node tnode = head;
			
			while(tnode!= null)
			{
				System.out.println(tnode.value);
				tnode = tnode.next;
				
			}
		}
		public void push(String val) {
			node newNode = new node(val);
			newNode.next = head;
			head = newNode;
			}
		 public static int getCountRec(node node) 
		    { 
		         
		        if (node == null) 
		            return 0; 
		   
		        return 1 + getCountRec(node.next); 
		    } 
		  
		   
		 public  int getCount() 
		    { 
		        return getCountRec(head); 
		    }  
		public void append(String new_data) 
	    { 
	       
	        node new_node = new node(new_data); 
	  
	       
	        if (head == null) 
	        { 
	            head = new node(new_data); 
	            return; 
	        } 
	  
	      
	        new_node.next = null; 
	  
	    
	        node last = head;  
	        while (last.next != null) 
	            last = last.next; 
	  
	       
	        last.next = new_node; 
	        return; 
	    } 
		
		
		void merge(linkedlist list2) 
	    { 
	        node current = head, list2_current = list2.head; 
	        node p_next, q_next; 
	  
	        // While there are available positions in p; 
	        while (current != null && list2_current != null) { 
	  
	            // Save next pointers 
	            p_next = current.next; 
	            q_next = list2_current.next; 
	  
	             
	            list2_current.next = p_next; // change next pointer of q_curr 
	            current.next = list2_current; // change next pointer of p_curr 
	  
	             
	            current = p_next; 
	            list2_current = q_next; 
	        } 
	        list2.head = list2_current; 
	    } 
		void printmergeList(linkedlist list2) {
		printlist();
		list2.printlist();
		}
	

	public static void main(String[] args) {
		
		linkedlist list = new linkedlist();
		linkedlist list2 = new linkedlist();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Merging Two List of String");
		
		
		
		
			System.out.println("Enter a word for list1 and press enter");
			String word = input.nextLine();
			String [] a = word.split(" ");
			for(int i = 0;i<a.length;i++) {
				list.append(a[i]);
			}
						
	
			System.out.println("Now, Enter a word for list Two and press enter");
			String word2 = input.nextLine();
			String [] b = word2.split(" ");
			for(int i = 0;i<b.length;i++) {
				list2.append(b[i]);
			}
			
		
		
		
		list.merge(list2);
		list.printmergeList(list2);
		
		
		

	}

}



