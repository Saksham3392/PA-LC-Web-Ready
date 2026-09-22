package Array;

import java.util.*;


class MaxSum {
    
    public static int maxSum(int arr[],int k){
        int windowSum=0;
        for(int i=0;i<k;i++){
            windowSum+=arr[i];
        }
        int maxSum=windowSum;
        for(int i=k;i<arr.length;i++){
            windowSum+=arr[i];
            windowSum-=arr[i-k];
            maxSum=Math.max(windowSum,maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[]={1,2,4,3,9,11};
        int k=3;
        System.out.println(maxSum(arr,k));
    }
}
