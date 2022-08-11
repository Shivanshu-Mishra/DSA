package com.shivanshu.in.madeeasy.linkedlist.circleexist;

import java.util.ArrayList;
import java.util.List;

/**
 * Floyd cycle finding algorithm uses two pointers moving at
 * different speeds to walk the linked list. Once they enter the loop they are expected to meet, which
 * denotes that there is a loop.
 * This works because the only way a faster moving pointer would point to the same location as a
 * slower moving pointer is if somehow the entire list or a part of it is circular. Think of a tortoise
 * and a hare running on a track. The faster running hare will catch up with the tortoise if they are
 * running in a loop.
 */
public class FloydCycleFindingSolution {
  public static boolean isCircleExist(Node node){
        Node hare=node,tortosie=node;
      System.out.println(String.format("Start:(%sH,%sT)",hare.getData().toString(),tortosie.getData().toString()));
        while(tortosie!=null){
            if(hare.getNextNode()==null || hare.getNextNode().getNextNode()==null){
               // System.out.println(String.format("(%sH,%sT)",hare.getData().toString(),tortosie.getData().toString()));
                return false;
            } else {

            hare=hare.getNextNode().getNextNode();
            tortosie=tortosie.getNextNode();
                System.out.println(String.format("(%sH,%sT)",hare.getData().toString(),tortosie.getData().toString()));
            }
            if(tortosie.equals(hare)){
                //System.out.println(String.format("(%sH,%sT)",hare.getData().toString(),tortosie.getData().toString()));
                return true;
            }
        }
        return false;
    }
}
