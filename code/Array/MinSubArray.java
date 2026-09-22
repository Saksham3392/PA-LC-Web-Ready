package Array;



public class MinSubArray {
    public static int minSubArray(int[] arr,int k){
        
        int sum=0,left=0,minLength=Integer.MAX_VALUE;
        
        for(int right=0;right<arr.length;right++){
            sum+=arr[right];
            while(sum>=k){
                minLength=Math.min(right-left+1,minLength);
                sum-=arr[left];
                left++;
            }
        }
        if(minLength==Integer.MAX_VALUE) return 0;
        return minLength;
    }
    public static void main(String[] args) {
        int [] arr={2,3,1,2,4,3,1};
        int k=7;
        System.out.print("Minimum length of SubArray whose sum is more than or equal to k is "+ minSubArray(arr,k));
    }
    
}
