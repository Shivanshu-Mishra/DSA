package com.shivanshu.in.madeeasy.linkedlist.circleexist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * To find a circle in list we store node in a list and if while
 * traversing through list we met same node twice then there is a circle.
 */
public class StoreNodeSolution {

    public boolean isCircleExist(Node node){
        List<Node> nodes=new ArrayList<>();
        while(node.getNextNode()!=null){
            if(nodes.contains(node)){
                return true;
            }
            nodes.add(node);
            node=node.getNextNode();
        }
        return false;
    }
}
