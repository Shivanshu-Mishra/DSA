package com.shivanshu.in.madeeasy.recursion;

public class SortedArrayValidator {

    public int isSorted(int[] arr,int index){
        System.out.println(index);
        if(index==1) return 1;
        return (arr[index-1] < arr[index-2])?0:isSorted(arr,index-1);
    }

    public static void main(String[] args){
        SortedArrayValidator validator=new SortedArrayValidator();
        int[] arr={0,1,3,2,4,56};
        boolean isArraySorted=validator.isSorted(arr,arr.length)!=0;
        System.out.println("Is Array Sorted: "+isArraySorted);

    }
}
