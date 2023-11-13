package Backtracking;
import java.util.*;

class permutation
{
    static void swap(char[] arr,int a,int b)
    {
        char c=arr[a];
        arr[a]=arr[b];
        arr[b]=c;
    }
    static void permute1(char[] s,int l,int r)
    {
        if(l==r)
        {
            System.out.println(s);
            return;
        }
        else
            for (int i = l; i <= r; i++)
            {
                swap(s, l, i);
                permute1(s, l + 1, r);
                swap(s, l, i);
            }
    }
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char []arr=s.toCharArray();
        permute1(arr,0,s.length()-1);
    }
}