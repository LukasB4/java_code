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

//all original code

//adds to a stack, pops from the top of the stack if a $ is found
//then proceeds to print the stack
public class Stack {
    
    private Node head;
    private Node last;
    private String[] stringarr;
    
    Stack()
    {
        head = null;
    }
    
    public void split(String given)
    {
        stringarr = given.split(" ");
    }
    
    public void pushpop()
    {
        last = new Node(stringarr[0]);
        
        for(int i = 0; i < stringarr.length; i++)
        {
            Node temp = new Node(stringarr[i]);
            if(head == null)
            {
                head = temp;
                last = temp;
            }
            if(!"$".equals(temp.getData()))
            {
                temp.setPrev(last);
                last = temp;
            }
            else if("$".equals(temp.getData()))
            {
                temp = last.getPrev();
                System.out.println("Popping: " + temp.getData());
                last = null;
                last = temp;
            }
        }
    }
    
    public void print()
    {
        String word = "";
        Node current = last;
        
        while(true)
        {
            word = current.getData() + " " + word;
            
            if(current == head)
                break;
            
            current = current.getPrev();

        }
        System.out.println("Remaining words: " + word);
    }
}
