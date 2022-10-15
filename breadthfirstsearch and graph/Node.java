/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stategraph;

/**
 *
 * @author lukasbernard
 * I wrote this node class, used previously in my lab 8
 */
public class Node
{
    private final String vertex;
    private Node next;
    private Node prestate;
    private Node prestatetwo;
    /**
     * 
     * @param state
     * Assigns the value of the global state string
     * These values will never be changed so there need not
     * be a set function for either of these data attributes
     * 
     */
    Node(String state)
    {
        this.vertex = state;
    }
    public String getState() //returns the state
    {
        return vertex;
    }
    public void setNext(Node next) //sets the next node
    {
        this.next = next;
    }
    public Node getNext() //returns the next node
    {
        return next;
    }
    public void setP(Node p) //for the parent state
    {
        prestate = p;
    }
    public Node getP()
    {
        return prestate;
    }
    public void setPT(Node p) //for the parent states parent
    {
        prestatetwo = p;
    }
    public Node getPT()
    {
        return prestatetwo;
    }
}
