/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashset;

/**
 *
 * @author lukasbernard
 * I wrote this hash code myself
 * The hash function's purpose is to create a hashset for each word
 */
public class hash {
    /**
     * 
     * @param temp
     * The add function takes the string given and places each letter individually
     * into slots in the node array based on their index hash value and creates a
     * linked list if there are more than one items at the index
     * @return true or false
     */
    public boolean add(String temp)
    {
        Node[] hashSet = new Node[12]; //declare a hashSet array holding nodes
        char[] splitWord = temp.toCharArray();
        for(int i = 0; i <= splitWord.length - 1; i++) //iterate through each letter in the string
        {
            int val = hashValue(splitWord[i]); //Send the current letter and recieve the hash value
            if(!contains(splitWord[i], hashSet[val])) //if contains returns false when given the letter and index
            {
                Node n = new Node(hashValue(splitWord[i]), splitWord[i]); //creates a new node with the hashvalue and letter
                if(hashSet[val] == null) //if there is not yet a node in the indexed slot, fill it with this new node
                    hashSet[val] = n;
                else //if there is a node in the indexed slot
                {
                    Node a = hashSet[val]; //temporary node
                    while(a.getNext() != null) //while there is a node after node a
                    {
                        a = a.getNext();
                    }
                    a.setNext(n); //after we find the end of the line, set a nodes next to node n
                }
            }
            else if(contains(splitWord[i], hashSet[val])) //if it does contain the letter return false immediately
            {
                return false;
            }
        }
        return true; //if false is never returned, return true because the characters must all be unique
    }
    /**
     * 
     * @param temp
     * @param a
     * Compares temp to the values of other nodes to see if it is contained in the linked list
     * Node a is the first node at the index that temp is located at
     * @return true if found, false if not
     */
    public boolean contains(char temp, Node a)
    {
        while(a != null) //while the linked list continues, and if it exists at all
        {
            if(a.getValue() == temp) //if the value is in the linked list return true
                return true;
            a = a.getNext();
        }
        return false; //if true is not returned then it must not contain the value
    }
    /**
     * 
     * @param key
     * @return the hash code for the current key
     */
    public int hashValue(char key)
    {
        return((Character.valueOf(key).hashCode() & 0x7fffffff) % 11);
    }
}
