/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.pkg2;

/**
 *
 * @author lukasbernard
 * I am using a lot of the same red black tree functions from my lab 6 program.
 * sameDay, highestVal, and lowestVal I wrote uniquely for this program however
 * Also converted to take and compare a float
 */
public class RedBlackTree
{
    private Node root = null; //set the root to null
    private final boolean RED = false; //setting red to false
    private final boolean BLACK = true; //setting black to true
    private Node pick;
    //get Uncle is a function to get the other node associated with the same grandparent
    public Node getUncle(Node temp)
    {
        Node gparent = temp.parent(); //set the grandparent
        if(gparent.right()==temp) //if the grandparents right child is the parent return the left child as the uncle
            return gparent.left();
        else //if the grandparents left child is the parent return the right child as the uncle
            return gparent.right();
    }
    //put method creates a new node and places it in the correct root if there is no root or calls place function
    public void put(float key, String value)
    {
        Node temp = new Node(key, value); //creates a new temp node
        if(root == null)
        {
            root = temp;
        }
        else
            place(temp, root);
    }
    //place takes two nodes and recursively places node temp in the correct place, greater or less than our node p
    // until it finds the same key or an empty place for the node to go
    public void place(Node temp, Node p)
    {        
        if(temp.key() == p.key()) //if the node keys are the same
        {
            p.value(temp.value());//sets the value of the original key to the new keys value
            flipColors(temp);
        }
        
        else if(temp.key() < p.key()) //if the node key is less than
        {
            if(p.left() == null) //if there is no node to the left of node p
            {
                p.left(temp); //sets the node to the left of p to temp
                temp.parent(p); //sets temp's parent to p
                temp.color(RED); //changes temp's color to red since it is inserted
                flipColors(temp);
            }
            else
            {
                place(temp, p.left()); //recursively calls place again with the next node in line to the left
            }
        }
        else if(temp.key() > p.key()) //if the node key is more than
        {
            if(p.right() == null) //if there is no node to the right of parent
            {
                p.right(temp); 
                temp.parent(p);
                temp.color(RED); //change the temp color to red
                flipColors(temp);
            }
            else
            {
                place(temp, p.right()); //recursively calls place again with the next largest node
            }
        }
    }
    //this is a method made to find if a color needs to be changed, and then changes the color if needed
    public void flipColors(Node temp)
    {
        Node parent = temp.parent();
        if(parent == null) //if there is no parent set the temp to black as the root
        {
            temp.color(BLACK);
            return;
        }
        if(parent.color() == BLACK) //if the parent is black nothing can change
            return;
        
        Node gparent = parent.parent(); //sets the grandparent to the parents parent
        
        if(gparent == null) //if there is no grandparent change the parents color to black because it is the root
        {
            parent.color(BLACK);
            return;
        }
        Node uncle = getUncle(parent); //calls the get uncle function
        if((uncle != null)&&(uncle.color() == RED)) //if the uncle exists and its color is red the parent will change to black as well as the uncle
            //then changes the grandparent to red, sends the grandparent back recursively to flip colors
        {
            parent.color(BLACK);
            gparent.color(RED);
            uncle.color(BLACK);
            flipColors(gparent);
        }
        else if(parent == gparent.left()) //if the parent is the left child
        {
            if(temp == parent.right()) //if temp is the right child
            {
                rotateLeft(parent); //rotate the parent subtree leftwards
                parent = temp; //set parent to the temp node
            }
            rotateRight(gparent); //rotate the tree to the right over the grandparent
            parent.color(BLACK); //parent color black
            gparent.color(RED); //grandparent color red
        }
        else if(parent == gparent.right()) //if the parent is the right child
        {
            if(temp == parent.left()) //if temp is the left child
            {
                rotateRight(parent); //rotate right over the parents tree
                parent = temp; //set the parent to the temp node
            }
            rotateLeft(gparent); //rotate left over the grandparent
            parent.color(BLACK); //parents color to black
            gparent.color(RED); //grandparents color to red
        }
        
    }
    //rotates the tree or subtree left over a fixed point
    public void rotateLeft(Node temp)
    {
        Node parent = temp.parent();
        Node rightC = temp.right();
        temp.right(rightC.left()); //sets the temp's right to the left of the right child
        
        if(rightC.left() != null) //if there is a left child of the right child
            rightC.left().parent(temp); //set the parent of this left child to temp
        rightC.left(temp); //right childs left to temp
        temp.parent(rightC);
        if(parent == null) //if there is no parent the root is then right child
            root = rightC;
        else if(parent.right() == temp) //if there is a parent right child and it is temp, set its right to the right child
            parent.right(rightC);
        else if(parent.left() == temp) //if the parent's left child is temp set its left child to the right child
            parent.left(rightC);
        
        if(rightC != null) //if there is a right child the right childs parent is parent
        {
            rightC.parent(parent);
        }
    }
    //same as the rotate left function with tweaks to when it changes rightward instead of left.
    public void rotateRight(Node temp)
    {
        Node parent = temp.parent();
        Node leftC = temp.left();
        
        temp.left(leftC.right()); 
        if(leftC.right() != null)
            leftC.right().parent(temp);
        leftC.right(temp);
        temp.parent(leftC);
        
        if(parent == null)
            root = leftC;
        else if(parent.right() == temp)
            parent.right(leftC);
        else if(parent.left() == temp)
            parent.left(leftC);
        
        if(leftC != null)
        {
            leftC.parent(parent);
        }
    }
    
    /**
     * this function goes to the leftmost leaf and returns it
     * @return temp
     */
    public Node lowestVal()
    {
        Node temp = root;
        if(temp != null) //if there is a root
        {
            while(temp.left() != null) //while there is still a left side child
                temp = temp.left(); //set temp to the left child
        }
        return temp;
    }
    /**
     * this method goes to the rightmost leaf and returns it
     * @return temp
     */
    public Node highestVal()
    {
        Node temp = root;
        if(temp != null) //if there is a root
        {
            while(temp.right() != null) //while there is a further right child
                temp = temp.right(); //set temp to its right child
        }
        return temp;
    }
    /**
     * calls the same day function, sending in the date and the root
     * @param date
     * @return 
     */
    public Node sameDay(String date)
    {
        pick = null;
        sameDay(root, date); //returns the node returned by sameday
        return pick;
    }
    /**
     * Searches through for the same date value and then returns the node
     * uses inorder traversal
     * @param n
     * @param date
     * 
     */
    public void sameDay(Node n, String date)
    {
        if(n == null) //if the node is null return
            return;
        if(n.value().equals(date)) //if the date equals the value set our node pick to n
        {
            pick = n;
        }
        sameDay(n.left(), date); //go through the left subtree
        sameDay(n.right(), date); //go through the right subtree
    }
    
}
