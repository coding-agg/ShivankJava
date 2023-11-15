package Section18_DP;

public class knapsack {
    public static void main(String[] args) {

    }
    public static int knapsackRecursive(int[] weight,int[] price,int max,int ini,int start,int end){
        for (int k = start+1; k <end ; k++) {
            int profit = price[k] + knapsackRecursive(weight,price,max,ini+weight[k],start,k);
        }
        return -1;
    }
}
