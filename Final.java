import java.util.Scanner;



import java.io.*;


public class Final {
	
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
		public node bubbleSortList()
	    {
	        boolean isSwapped = true;
	       

	        for(node current = this.head, tail = null; isSwapped && head != tail; tail = current, current = head)
	        {
	            for(isSwapped = false; current.next != tail; current = current.next) 
	            { 
	                if (current.value.compareTo(current.next.value) >0) 
	                {  
	                    swap(current, current.next); 
	                   
	                    isSwapped = true; 
	                }
	            }
	        }
	        return head;
	    }

	    public static void swap(node x, node y)
	    {
	        if(x != y)
	        {
	            String temp = x.value;
	            x.value = y.value;
	            y.value = temp;    
	        }
	    }
	    public void insert(String name)
	    {
	    	node current = head;
	    	node prev = head;
	    	
	    	
	    	while(current!=null && current.value.compareTo(name)<=0) {
	    		prev = current;
	    		current = current.next;
	    		
	    	}
	    	node newnode = new node(name);
	    	newnode.next = current;
	    	prev.next = newnode;
	    }
	    public void delete(String name)
	    {
	    	node current = head;
	    	node prev = head;
	    	while(current!=null && current.value.compareTo(name)!=0)
	    	{
	    		prev = current;
	    		current = current.next;
	    	}
	    	prev.next = current.next;
	    	
	    }
	    
	    
		
	

	public static void main(String[] args) throws IOException{
		
		
		DataInputStream input = new DataInputStream(new FileInputStream("share.dat"));
		Final name = new Final();
		Final firstName = new Final();
		int count = 0;
		while(input.available()>0) {
			String readName = input.readLine();
			
			String [] fullName = readName.split(" ");
			
				
				String lastandfirst = fullName[1]+" "+fullName[0]; //switches the last to first
			//	System.out.println(lastandfirst);
				
				name.append(lastandfirst);
				count++;
			}
//		System.out.println(count);
//		System.out.println(firstName.getCount());
//		System.out.println(name.getCount());
		//name.printlist(); // prints the list
			name.bubbleSortList(); //sorts the name linkedlist
			
			System.out.println("------------------");
			System.out.println("After Sorting \n"+"------------------");
			name.printlist();
			name.insert("Apple John");
			System.out.println("------------------");
			System.out.println("After inserting \n"+"------------------");
			name.printlist();
			name.delete("Apple John");
			System.out.println("------------------");
			System.out.println("After deleting \n"+"------------------");
			name.printlist();
			
			
		}
		
	}





