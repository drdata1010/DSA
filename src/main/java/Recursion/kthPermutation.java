package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class kthPermutation {
    public static int factorial(int n){
        if(n <= 1) return 1;

        return n * (n-1);
    }
    public static String findKthPerm(int n, int k){
        k--;
        ArrayList<Integer> ls = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            ls.add(i);
        }
        String res = "";
        for(int i = 1; i <= n; i++){
            int fact = factorial(ls.size()-1);//find factorial
            int index = k / fact;
            res = res + ls.get(index);
            ls.remove(index);
            k = k % fact;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int kth = sc.nextInt();
        String kthPerm = findKthPerm(n,kth);
        System.out.println(kthPerm);
    }
}
