/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author lukasbernard
 * this is my node class
 */
public class Node {
    String value;
    String key;
    private Node right;
    private Node left;
    private Node parent;
    
    boolean color; //stores the color
    //takes the key and the value
    public Node(String key, String value)
    {
        this.key = key;
        this.value = value;
    }
    //returns the key string
    public String key()
    {
        return key;
    }
    //returns the value string
    public String value()
    {
        return value;
    }
    //sets the value string to a new value
    public void value(String value)
    {
        this.value = value;
    }
    //sets the key to a new key
    public void key(String key)
    {
        this.key = key;
    }
    //returns the parent node
    public Node parent()
    {
        return parent;
    }
    //changes the node's color
    public void color(boolean color)
    {
        this.color = color;
    } 
    //returns the node's color
    public boolean color()
    {
        return color;
    }
    //sets the parent to the temp node
    public void parent(Node temp)
    {
        parent = temp;
    }
    //returns the right node
    public Node right()
    {
        return right;
    }
    //sets the right node
    public void right(Node temp)
    {
        right = temp;
    }
    //returns the left node
    public Node left()
    {
        return left;
    }
    //sets the left node to temp
    public void left(Node temp)
    {
        left = temp;
    }
    
}
