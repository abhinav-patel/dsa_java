package Greedy;
import java.sql.SQLOutput;
import java.util.*;

class Items implements Comparable<Items> {
    int wt, val;
    public Items(int w, int v) {
        wt = w;
        val = v;
    }
    @Override
    public int compareTo(Items i) {
        return (i.val / i.wt) - (val / wt);
    }
}

class test {
    public static void main(String[] args)
    {
        Items[] arr = new Items[]{new Items(10, 60),
                new Items(40, 40),
                new Items(20, 100),
                new Items(30, 120)};

        int w=50;
        System.out.println(knapSack(arr,w));

    }
    static double knapSack(Items []arr,int k)
    {
        Arrays.sort(arr);
        double res=0.0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].wt<=k)
            {
                res=res+arr[i].val;
                k=k-arr[i].wt;
            }
            else {
                res = res + (k * (arr[i].val / arr[i].wt));
                break;
            }
        }
        return res;
    }
}