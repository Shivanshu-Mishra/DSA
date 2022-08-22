package com.shivanshu.in.madeeasy.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class MergeSortedLinkedList<E extends Integer> {

    public LinkedList iterativeMerge(LinkedList<E> list1, LinkedList<E> list2) {
        LinkedList<E> mergeList = new LinkedList();
        int list1Size = list1.size();
        int list2Size = list2.size();
        int list1Counter = 0;
        int list2Counter = 0;
        while (list1Counter < list1Size && list2Counter < list2Size) {
            if (list1.get(list1Counter).compareTo(list2.get(list2Counter)) < 0) {
                mergeList.add(list1.get(list1Counter));
                list1Counter++;
            } else if (list1.get(list1Counter).compareTo(list2.get(list2Counter)) > 0) {
                mergeList.add(list2.get(list2Counter));
                list2Counter++;
            } else {
                mergeList.add(list1.get(list1Counter));
                list1Counter++;
                list2Counter++;
            }
        }
        while(list1Counter<list1Size){
            mergeList.add(list1.get(list1Counter));
            list1Counter++;
        }
        while(list2Counter<list2Size){
            mergeList.add(list2.get(list2Counter));
            list2Counter++;
        }
        return mergeList;
    }
}
