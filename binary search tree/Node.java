/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author lukasbernard
 */
public class Node {
    
    private char data; //my data attribute as a char
    private Node left; //the node declaration for the right node
    private Node right; //the node declaration for the left node
    
    Node(char d) //creating a node with data char d
    {
        data = d; //assigning char d to data
    }
    
    public char getData(){return data;} //returns data
    public Node getLeft(){return left;} //returns left node
    public Node getRight(){return right;} //returns right node
    public void setRight(Node temp){right = temp;} //@param temp set right node to temp
    public void setLeft(Node temp){left = temp;} //@param temp set left node to temp
}
