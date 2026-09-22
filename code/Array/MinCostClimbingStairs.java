package Array;

import java.util.Scanner;


public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        return Math.min( solve(cost,0) ,  solve(cost,1));
        
    }
    public static int solve(int[] cost,int index){
        if(index>=cost.length)return 0;
        return cost[index]+ Math.min( solve(cost,index+1) , solve(cost,index+2));
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of stairs : ");
        int n=sc.nextInt();
        int[] cost=new int[n];
        System.out.println("Cost : ");
        for(int i=0;i<n;i++){
            cost[i]=sc.nextInt();
        }
        System.out.print("Minimum cost : "+minCostClimbingStairs(cost));
        sc.close();
    }
    
}
