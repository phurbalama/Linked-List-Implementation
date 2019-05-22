package finalfinal;

import java.util.Scanner;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Final {

    node head;

    class node {

        String value;
        node next;

        public node() {
            value = "";
            next = null;
        }

        public node(String val) {
            value = val;
            next = null;
        }
    }

    public void printlist() {
        node tnode = head;

        while (tnode != null) {
            String[] name = tnode.value.split(" ");
            String firstlast = name[1] + " " + name[0];
            System.out.println(firstlast);

            tnode = tnode.next;

        }
    }

    public void saveList() throws IOException {
        node tnode = head;
        DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("share.dat"));

        while (tnode != null) {
            String[] name = tnode.value.split(" ");
            String firstlast = name[1] + " " + name[0];

            dataOut.writeBytes(firstlast + "\n");
            tnode = tnode.next;

        }
        dataOut.close();
    }

    public void insert(String name) {
try {
		
        node current = head;
        node prev = new node();
        prev.next = current;
        
        
        String[] names = name.split(" ");
        String lastfirst = names[1] + " " + names[0];
        //System.out.println(lastfirst);
        node newnode = new node(lastfirst);

        if (head == null) {
            head = new node(lastfirst);
            return;
        }

        //for the head 
        if (current.value.toLowerCase().compareTo(lastfirst.toLowerCase()) > 0) {

            newnode.next = current;
            this.head = newnode;
            return;
        }

        while (current != null && current.value.toLowerCase().compareTo(lastfirst.toLowerCase()) <= 0) {
        	

            prev = current;
            current = current.next;

        }

        newnode.next = current;
        prev.next = newnode;
//        if(getCount()>count) {
//        	System.out.println(name+ " has been added");
//        }
//      
}
catch(Exception ex) {
	System.out.println("Please Enter First and the Last Name correctly");
}

    }

    public void delete(String name) {
    	try {
        node current = head;
        node prev = new node();
        prev.next = current;

        String[] names = name.split(" ");
        String lastfirst = names[1] + " " + names[0];

        if (current.value.compareTo(lastfirst) == 0) {

            head = current.next;
            return;
        }

        while (current != null && current.value.compareTo(lastfirst) != 0) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        System.out.println(name + " has been deleted");
    	}
    	catch(Exception ex) {
    		System.out.println("Name doesnt exist");
    	}
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

    public void load() throws IOException {
        DataInputStream input = new DataInputStream(new FileInputStream("share.dat"));

        Final firstName = new Final();
        int count = 0;
        try {
            while (input.available() > 0) {
                String readName = input.readLine();

                insert(readName);

                count++;
            }
            System.out.println(count);
        } catch (IOException ex) {
            Logger.getLogger(Final.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {

        do {
            System.out.println("__________________Program Menu__________________________________________________By :Phurba Lama and Mohamed Ait iaza");
            System.out.println("L: Load \t A: ADD \t D: Delete \tS: Save\t E: Exit");
            
            

            String yesorno = "C";

            Scanner s = new Scanner(System.in);
            Final name = new Final();

            yesorno = s.next();

            switch (yesorno.toUpperCase()) {

                case "L": {
                    name.load();
                    name.printlist();
                    break;
                }
                case "A": {
                    System.out.println("Enter the name you want to add");
                    s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    String newName = s.nextLine();
                    name.load();
                    name.insert(newName);
                    name.saveList();
                    
                    break;
                }
                case "D": {
                    System.out.println("Enter the name you want to delete");
                    String delName = "";
                    s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    delName = s.nextLine();

                    name.load();
                    name.delete(delName);
                    name.saveList();
                   
                    break;
                }
                case "E": {
                    System.exit(0);
                }
                case "S": {
                    name.load();
                    name.saveList();
                    System.out.println("Your files have been saved");
                    break;
                }
            }//switch

        } while (true);

    }

}
