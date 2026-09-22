package Searching;


class Linear {
    static int LinearSearch(int[]arr ,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50};
        int target=30;
        int ans=LinearSearch(arr,target);
        if(ans==-1){
            System.out.println("Element not found");
        }
        System.out.println("Element is found at " + ans);
    }
}
