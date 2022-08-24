package com.problem;

public class RemoveDuplicate {

    public static void removeDuplicate(int[] array) {
        int[] newArrays = new int[array.length];
        int index =0;
       /* newArrays[index] = array[0];
        for(int i = 1; i < array.length; i++) {
            if(newArrays[index] == array[i]) {
            } else {
                newArrays[++index] = array[i];
            }
        }
        System.out.println(index);
        for(int j=0;j<index+1;j++){
            System.out.print(newArrays[j]+"::");
        }*/

       // by constant O(1) space
        int j=0;
        for(int i = 0; i < array.length-1; i++) {
            if(array[i] != array[i+1]) {
               array[j]= array[i];
               j++;
            }
        }
        array[j]=array[array.length-1];
        System.out.println(j+"check this point");
        for(int k=0;k<=j;k++){
            System.out.print(array[k]+"::");
        }

    }

    public static void main(String[] args) {
        //{0,1,1,2,2,2,2,3,24};
        //int array[] = {0,0,0,0,1,1,1,2,2,4,5,6};
        int array[] = {1,1,1,2,2,2,3};
        removeDuplicate(array);

    }
}


