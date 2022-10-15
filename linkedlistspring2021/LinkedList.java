/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistspring2021;

/**
 *
 * @author Hunter
 */
public class LinkedList {
    private Node first;
    private Node tail;
    
    LinkedList()
    {
        first = null;
    }
  
    public void deleteList()
    {
        first = null;
    }
    public void add(int x){
       
        Node temp  = new Node(x);
        
            if(first == null)
            {
                first = temp;
                tail = temp;
                temp.next = first;
            } 
            else
            {
                tail.next = temp;
                tail = temp;
                tail.next = first;
            }
       
    }
    public void print()
    {
        Node temp = first.getNext();
        while(temp !=  first)    
        {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
            
     }
    
    public void search(int index)
    {
        Node temp = first;
        
        while(temp !=  null)    
        {
            if (temp.getData() == index)
            {
                System.out.println("Found " + index);
                return;
             }
            temp = temp.getNext();
        }
        
        System.out.println("Didn't find " + index);
            
     }
    public void deleteNode(int x){
        Node temp = first;
        
        if (temp.getData() == x)
        {
            first = temp.getNext();
            return;
        }
        else{
           //lagptr = first;
            if(temp!=null)
                temp = temp.getNext();
            else if(temp == null)
                temp = first;
        }
        while(temp !=  null)    
        {
            temp = temp.getNext();
        }
        
        System.out.println("Didn't find " + x);
    }
}
