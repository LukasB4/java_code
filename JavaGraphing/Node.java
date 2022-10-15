/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author lukasbernard
 * 
 * I authored this node class myself
 */
public class Node
{
    private int key; //integer key
    private Node next; //next node in linked list
    private int weight = 0; //the weight in this case is the amount of attached pieces after a base node
    private Node tail; //the tail node of my linked lists
    
    public Node(int key) 
    {
        this.key = key;
    }
    
    public void setNext(Node next)
    {
        this.next = next;
    }
    public Node getNext()
    {
        return next;
    }
    public int getKey()
    {
        return key;
    }
    public int getWeight() //get the weight value
    {
        return weight;
    }
    public void addWeight() //add one to the weight value
    {
        weight++;
    }
    public void setWeight(int weight) //set the weight to an int parameter
    {
        this.weight = weight;
    }
    public Node getTail()
    {
        return tail;
    }
    public void setTail(Node tail) //set the tail node of the linked list
    {
        this.tail = tail;
    }
}
