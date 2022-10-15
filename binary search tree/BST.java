/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author lukasbernard
 * 
 * creates a binary search tree
 */
public class BST 
{
    private Node root = null; //setting data attribute root as a null node
    private int heightl = 0; //declaring private int heightl for left side height to zero
    private int heightr = 0; //declaring private int heightr for right side height to zero
    
    public void add(char x) //method for adding the char to a node 
    {
        Node temp = new Node(x); //declaring a node with char x as the data value
        if(root == null) //if the root is null set the node to temporary node
        {
            root = temp;
        }
        else //if there is a root call the add function with the temp and root
        {
            add(temp, root);
        }
    }
    public void add(Node x, Node y) //add function takes in the node we are searching for and the current node we are comparing to
    {
        if(x.getData() > y.getData()) //if the node we are searching for is bigger than the comparing node
        {
            if(y.getRight() == null) //if there is no node already bigger than the node we are comparing to
            {
                y.setRight(x); //set the larger node to our node
                heightr++; //increase the height of the right branch
                
            }
            else if(y.getRight() != null) // if there is a node already to the right of y
                add(x, y.getRight()); //recursively send back the node to the right of y and our node we are searching to place
        }
        else if(x.getData() < y.getData()) //if the node we are searching for is smaller than the comparing node
        {
            if(y.getLeft() == null) //if there is no node smaller than y yet
            {
                y.setLeft(x); //set the node to the left of y to x
                heightl++; //increase the height of the left branch
            }
            else if(y.getLeft() != null) //if there is a node smaller than y
                add(x, y.getLeft()); //recursively call back with node x and the node smaller than y
        }
        else if(x.getData() == y.getData()) //if there is a matching key nullify our current node
        {
            x = null;
        }
            
    }
    public void print() //method for printing inorder, preorder, postorder, recursive height, and attribute height
    {
        System.out.print("Inorder traversal:   ");
        inorder(root); //send the root to the inorder method
        System.out.println();
        System.out.println();
        System.out.print("Preorder traversal:  ");
        preorder(root); //send the root to the preorder method
        System.out.println();
        System.out.println();
        System.out.print("Postorder traversal: ");
        postorder(root); //send the root to the postorder method
        System.out.println();
        System.out.println("Tree height recursive: " + treeHeight(root)); //use the treeheight function with parameter root
        System.out.println();
        if(heightl > heightr) //if the left height is larger
            System.out.println("Tree height with attribute: " + heightl);
        else //if the right height is larger
            System.out.println("Tree height with attribute: " + heightr);
    }
    public void inorder(Node n) //prints the inorder list of nodes, parameter node n
    {
        if(n == null) //if node n comes back as null, return to go to the next statement
            return;
        
        inorder(n.getLeft()); //recursively call back with the node to the left of current node
        System.out.print(n.getData() + " "); //print the data of the current node
        inorder(n.getRight()); //recursively call back with the node to the right of the current node
        
    }
    public void preorder(Node n) //prints the preorder list of nodes, parameter node n
    {
        if(n == null) //if node n comes back as null, return to go to the next statement
            return;
        System.out.print(n.getData() + " "); //print the data of the current node
        inorder(n.getLeft()); //recursively call back with the node to the left of current node
        inorder(n.getRight()); //recursively call back with the node to the right of the current node
    }
    public void postorder(Node n) //prints the postorder list of nodes, parameter node n
    {
        if(n == null) //if node n comes back as null, return to go to the next statement
            return;
        inorder(n.getLeft()); //recursively call back with the node to the left of current node
        inorder(n.getRight()); //recursively call back with the node to the right of the current node
        System.out.println(n.getData() + " "); //print the data of the current node
    }
    public int treeHeight(Node n) //find the height of the tree
    {
        if(n == null) //if n is null return 0
            return 0;
        else //if n is not null
        {
            int leftheight = treeHeight(n.getLeft()); //the int of the leftheight is the recursion of the node to the left
            int rightheight = treeHeight(n.getRight()); //the int of the rightheight is the recursion of the node to the right
            if(leftheight > rightheight) //if the leftheight is greater return this height plus one
                return(leftheight + 1);
            else  //if the rightheight is greater return this height plus one
                return(rightheight + 1);
        }
    }
}
