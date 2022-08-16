package com.shivanshu.in.madeeasy.linkedlist;

import com.shivanshu.in.madeeasy.linkedlist.circleexist.Node;

import java.util.HashMap;

public class LinkedListMergePoint {

    public Node mergePoint(Node list1, Node list2) {
        HashMap<Node, Integer> record = new HashMap<>();
        while (list1 != null) {
            record.put(list1, 1);
            list1 = list1.getNextNode();
        }
        while (list2 != null) {
            if (record.containsKey(list2))
                return list2;
            list2 = list2.getNextNode();
        }
        return null;
    }
}
