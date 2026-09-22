package Array;

public class CountSubArray {
    public static int countSubArray(int[] arr,int k){
        
        int left=0,sum=0,count=0;
        
        for(int right=0;right<arr.length;right++){
            sum+=arr[right];
            while(sum>k){
                sum-=arr[left];
                left++;
            }
            count+=(right-left+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int [] arr={1,2,1,1,1};
        // [1],[1,2],[2],[2,1],[1],[1,1],[1],[1,1,1],[1,1],[1]
        int k=3;
        System.out.print("Count of SubArrays where sum <= "+k+" is "+ countSubArray(arr,k));
    }
}
