/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.pkg2;

/**
 * this node class is largely the same as my lab 6 but takes a float key instead
 * written by me
 * @author lukasbernard
 */
public class Node
{
    private String value;
    private float key;
    private Node right;
    private Node left;
    private Node parent;
    
    boolean color; //stores the color
    //takes the key and the value
    public Node(float key, String value)
    {
        this.key = key;
        this.value = value;
    }
    //returns the key string
    public float key()
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
    public void key(float key)
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
