/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stategraph;

/**
 *
 * @author lukasbernard
 * I wrote this breadFirstSearch function myself
 */
public class breadFirstSearch
{
    GraphingUtility gu; //declaration of the graphing utility
    Node[] list; //declare a node array called list
    int M;
    int place;
    /**
     * 
     * @param gu
     * @param M 
     * declare variables
     */
    breadFirstSearch(GraphingUtility gu, int M)
    {
        this.M = M; //global m is declared
        this.gu = gu; //declare graphing utility as the same as parameter
        place = gu.get("Montana"); //get the place of montana
        list = gu.stateList; //list is equal to the statelist
    } 
    /**
     * search() looks for the states adjacent, and 2-3 states away from Montana
     */
    public void search()
    {
        boolean[] visited = new boolean[M]; //true false list of every state position to check if state has been visited
        visited[place] = true; //original place has been visited
        Node t = list[place].getNext(); //next node in the linked list
        visited[gu.get(t.getState())] = true; //add this new state to visited as true
        Node headone = new Node(t.getState()); //head of queue one
        Node tailone = headone; //tail of queue one
        t = t.getNext(); //start at the next state because head is already initialized
        while(t != null) //while there exists an entry in the list
        {
            tailone.setNext(new Node(t.getState())); //set the next of tail to node t
            tailone = tailone.getNext(); //set tail one to the final node
            place = gu.get(t.getState()); //set place equal to the number location of t
            visited[place] = true; //set that we have visited this node
            t = t.getNext(); //set t to the next value
        }
        
        //start
        
        Node headtwo = null; //set the head of our second list to two
        Node tailtwo = headtwo; //set the tail of our second list to head
        while(headone != null) //while the head of the original queue is not null
        {
            place = gu.get(headone.getState()); //place is equal to the place of our head of queue one
            Node temp = list[place].getNext(); //temp is equal to this indice's next state
            while(temp != null) //while the temp node is not null
            {
                if(!visited[gu.get(temp.getState())]) //if the temp state hasnt been visited
                {
                    if(headtwo == null) //if there is no head just yet
                    {
                        headtwo = new Node(temp.getState()); //set head of queue two to temp
                        headtwo.setP(headone); //set the parent to headone
                        tailtwo = headtwo; //the tail is also the head
                    }
                    else //if there is a head
                    {
                        tailtwo.setNext(new Node(temp.getState())); //set the next of tailtwo
                        tailtwo = tailtwo.getNext(); //set tailtwo to the tail
                        tailtwo.setP(headone); //set the parent to headone
                    }
                }
                visited[gu.get(temp.getState())] = true; //add this state to visited as true
                temp = temp.getNext(); //temp equals temp.getNext()
            }
            headone = headone.getNext(); //headone is equal to headone.getNext()
        }
        Node headtw = headtwo; //a clone of headtwo, headtw iterates through to print
        while(headtw != null) //while headtw is not null
        {
            System.out.println("Montana to " + headtw.getState() + "(2): Montana -- " + headtw.getP().getState() + " -- " + headtw.getState());
            headtw = headtw.getNext(); //next in line
        }
        System.out.println(); //new line
        
        //end
        
        //everything below is the section labeled start and end copy pasted
        //except headtwo is replaced by headthree and tailtwo is replaced by tailthree
        //every instance of headone is replaced by headtwo as well in the while loop
        //I will label every other difference however
        
        Node headthree = null; 
        Node tailthree = headthree;
        while(headtwo != null)
        {
            place = gu.get(headtwo.getState());
            Node temp = list[place].getNext();
            while(temp != null)
            {
                if(!visited[gu.get(temp.getState())])
                {
                    if(headthree == null)
                    {
                        headthree = new Node(temp.getState());
                        headthree.setP(headtwo.getP()); //set the parent to headtwo
                        headthree.setPT(headtwo); //set the second level parent to headtwo
                        tailthree = headthree;
                    }
                    else
                    {
                        tailthree.setNext(new Node(temp.getState()));
                        tailthree = tailthree.getNext();
                        tailthree.setP(headtwo.getP()); //set the parent to headtwo's parent
                        tailthree.setPT(headtwo); //set the second level parent to headtwo
                    }
                }
                visited[gu.get(temp.getState())] = true;
                temp = temp.getNext();
            }
            headtwo = headtwo.getNext();
        }
        while(headthree != null) //print the state and the path it took to get there from Montana
        {
            System.out.println("Montana to " + headthree.getState() + "(3): Montana -- " + headthree.getP().getState() + " -- " + headthree.getPT().getState() + " -- " + headthree.getState());
            headthree = headthree.getNext();
        }
    }
}
