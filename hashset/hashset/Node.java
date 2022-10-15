/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashset;

/**
 *
 * @author lukasbernard
 * This is my own node class
 */
public class Node {
    private int hashKey;
    private char value;
    private Node next;
    /**
     * 
     * @param hashKey
     * @param value 
     * Assigns the value of the global hashKey and value
     * These values will never be changed so there need not
     * be a set function for either of these data attributes
     */
    Node(int hashKey, char value)
    {
        this.hashKey = hashKey;
        this.value = value;
    }
    public int getHashKey()
    {
        return hashKey;
    }
    public char getValue()
    {
        return value;
    }
    public void setNext(Node next)
    {
        this.next = next;
    }
    public Node getNext()
    {
        return next;
    }
}
