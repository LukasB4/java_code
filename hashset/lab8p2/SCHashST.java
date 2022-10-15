/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8p2;

/**
 *
 * @author lukasbernard
 * I wrote the SCHashST class myself
 */
public class SCHashST<T> //class has generic of type T
{
    int M = 5; //size of the hash table
    Node[] hashTable = new Node[M]; //declaration for a hashtable of nodes
    static int value = 0; // the value of when the letter was inserted
    /**
     * 
     * @param key 
     * 
     * the put function takes a key, uses the index of the key
     * and places the node at the end of the linked list at the indexed space
     * in the hash table
     * 
     * @return none
     */
    public void put(T key)
    {
        Node temp = new Node(key, value);
        value++;
        Node n = hashTable[hash(key)]; //n is equal to the node at the base index of the hashtable
        if(n == null) //if there is no linked list at the index location put temp node there
        {
            hashTable[hash(key)] = temp;
            return;
        }
        while(n.getNext() != null) //iterates node n to the final node in the linked list
            n = n.getNext();
        n.setNext(temp); //sets the final node in the linked list's next to temp making it the final node
    }
    /**
     * 
     * @param key 
     * The get method takes the key and prints it's associated value
     */
    public void get(T key)
    {
        for(Node n = hashTable[hash(key)]; n != null; n = n.getNext()) //iterates through the linked list located at the hash value index of the given key
        {
            if(n.getKey() == key) //if any of these node's share this key it prints the value out and returns
            {
                System.out.println("Value for key " + key + " is: " + n.getVal());
                return;
            }
        }
        System.out.println(key + " was not found."); //if not found there will be no return so it will print the key was not found
    }
    /**
     * 
     * @param key
     * takes the key and returns 11 times its hashcode then modulus the size of the Array
     * @return the hashIndex
     */
    public int hash(T key)
    {
        return( (11*key.hashCode()-64)%M ); //returns the index slot in which the key sits
    }
    /**
     * @param none
     * method for printing out the nodes in our hashtable
     */
    public void print()
    {
        Node temp;
        for(int index = 0; index < M; index++) //iterates through all indices of the hashTable
        {
            temp = hashTable[index]; //sets temp to the initial node at the indice
            while(temp != null) //iterates through the linked list at the indice if there is one and prints its key val and index
            {
                System.out.println("Key: " + temp.getKey() + " Value: " + temp.getVal() + " Hash: " + hash((T) temp.getKey())); //of note: type cast temp.getKey to type T
                temp = temp.next; //cycle to next node in the linked list
            }
        }
    }
}
