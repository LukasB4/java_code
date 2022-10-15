/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;
/**
 *
 * @author lukasbernard
 */

//all code written by myself

public class LinkedList 
{
    private Node head;
    private String[] stringarr;
    
    LinkedList()
    {
        head = null;
    }
    /**
     Method of insertion is stack
     */
    public void split(String given)
    {
        stringarr = given.split(" ");
    }
    
    // inserting from the back, using a singularly linked list
    
    public void insert()
    {
        Node current = new Node(stringarr[0]);
        for(int i = 0; i < stringarr.length; i++)
        {
            Node temp = new Node(stringarr[i]);
            if(head == null)
            {
                head = temp;
                current = temp;
            }
            current.setNext(temp);
            current = temp;
        }
    }

    /*  deleting the duplicated by searching through for one
        and then taking it out of the linked list by reassigning the previous'
        next to the currents next
    */ 
    
    public void deleteDups()
    {
        Node temp = head;
        while(temp != null)
        {
            Node current = temp.getNext();
            Node previous = temp;
            while(current != null)
            {
                if(temp.getData().equals(current.getData()))
                {
                    previous.setNext(current.getNext());
                }
                else
                    previous = current;
                
                current = current.getNext();
            }
            temp = temp.getNext();
        }
    }
    
    // printing by adding to a string then printing out said string
    
    public void print()
    {
        String word = "";
        Node current = head;
        while(current != null)
        {
            word = word + current.getData() + " ";
            current = current.getNext();
        }
        System.out.println(word);
    }
    
}
