/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stategraph;

/**
 *
 * @author lukasbernard
 * I wrote this graphing utility class myself
 * Its purpose is to create a list of each state and its border states
 */
public class GraphingUtility
{
    Node[] stateList;
    static int place;
    /**
     * 
     * @param M 
     * Uses M to declare the size of our array stateList
     * also initializes the static int place to zero
     */
    public GraphingUtility(int M)
    {
        stateList = new Node[M];
        place = 0;
    }
    /**
     * 
     * @param vertex
     * @param edge 
     * Takes the state and border state to put them in the
     * correct slots in either the array, linked list, or both
     */
    public void add(String vertex, String edge)
    {

        if(!contains(vertex)) //if contains returns false
        {
            stateList[place] = new Node(vertex); //the current place in our list will be filled by the state
            stateList[place].setNext(new Node(edge)); //we will set the next node in this list to the border state of our state
            place++; //incriment place
        }
        else if(contains(vertex)) //if contains returns true
        {
            boolean includes = false; //includes is set to false to signifiy the border state is not included thusfar.
            Node temp = stateList[get(vertex)]; //temp is set to our initial node
            while(temp.getNext() != null) //while temp has a next value
            {
                if(temp.getState().equals(edge)) //if the border state is already in the linked list set includes to true
                    includes = true;
                temp = temp.getNext();
            }
            if((!includes) && (!temp.getState().equals(edge))) //if it is not included yet and the current state is not the border state
                temp.setNext(new Node(edge)); //set the next state in the linked list to the border state
        }
        if(!contains(edge)) //everything is the same as the above if else statements with the exception of state and border state switching places
        {
            stateList[place] = new Node(edge);
            stateList[place].setNext(new Node(vertex));
            place++;
        }
        else if(contains(edge))
        {
            boolean includes = false;
            Node temp = stateList[get(edge)];
            while(temp.getNext() != null)
            {
                if(temp.getState().equals(vertex))
                    includes = true;
                temp = temp.getNext();
            }
            if((!includes) && !temp.getState().equals(vertex))
                temp.setNext(new Node(vertex));
        }
        
    }
    /**
     * boolean contains
     * @param state
     * @return true if state is in the array
     * @return false if array is null or state is not in the array
     */
    public boolean contains(String state) //return true if there, false if not
    {
        if(stateList[0] == null) //if the array is empty return false, cannot be here
        {
            return false;
        }
        for (Node stateList1 : stateList) //iterate through every item in the array
        {
            if(stateList1 == null) //if the array entry is null continue to the next node
                continue;
            else if(stateList1.getState().equals(state)) //if the state is in equal to the current entry return true
            {
                return true;
            }
        }
        return false; //if nothing has been returned till this point, return false, the state must not be located in the array yet
    }
    /**
     * 
     * @param state
     * @return value
     * this is just a function to iterate through the array and find the index value
     * of the current state we are searching for.
     */
    public int get(String state)
    {
        int value = 49;
        for(int index = 0; index < stateList.length; index++) //iterate through the array
        {
            if(stateList[index] == null) //if the array entry is null
                continue;
            else if(stateList[index].getState().equals(state)) //if the index nodes state is equal to the state string set the value to the index value
                value = index;
        }
        return value;
    }
}
