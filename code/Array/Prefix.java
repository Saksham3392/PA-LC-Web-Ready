package Array;

class Prefix{
    public static void main(String[] args) {
        int[] arr={2,5,3,8,1,6};
        int[] prefix=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        int s=2;
        int e=5;
        int sum;
        if(s==0){
            sum=prefix[e];
        }
        else{
            sum=prefix[e]-prefix[s-1];
        }
        System.out.print(sum);
    }
}
