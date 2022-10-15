/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

/**
 *
 * @author lukasbernard
 * adds a node max.
 */
public class MinPQ {
    Node max; //the maximum key'd node in the set
    /**
     * @param add, pass it the number of cases and the other information as the value
     * adds this information based on the key value.Creates a node. Make a linked list
     * with left and right nodes, then finding if our key is greater than or less than the
     * existing keys and placing it in the correct area by reordering the left and right
     * of the keys before and after it. If node is largest at the time it is assigned as max
     * @return none
    */
    public void add()
    {
        
    }
    /**
     * @param get the maximum node and return it to be added to the BST
     * this then deletes the maximum node from the PQ and assigns it to next largest.
     * @return returns the largest key'd node
     */
    public Node getMax()
    {

        max = nextlargestnode;
        return max;
    }
}
