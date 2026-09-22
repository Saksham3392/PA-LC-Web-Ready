package Searching;


class MaxElement {
    static int MaximumElement(int[]arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={10,20,30,25,90,50};
        int ans=MaximumElement(arr);
        System.out.println("Maximum Element is " + ans);
    }
}
