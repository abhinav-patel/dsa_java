package Greedy;
import java.util.*;

class Job implements Comparable<Job>
{
    char id;
    int deadline,profit;
    public Job(char i,int d,int p)
    {
        id=i;
        deadline=d;
        profit=p;
    }
    public int compareTo(Job i)
    {
        return i.profit-this.profit;
    }
}
class test3
{
     public static void main(String[] args)
     {
         Job[] arr=new Job[]{new Job('a',4,50),
                 new Job('b',1,5),
                 new Job('c',1,20),
                 new Job('d',5,10),
                 new Job('e',5,80)};
         System.out.println(jobSequencing(arr,5));
     }
     static int jobSequencing(Job[] arr,int t)
     {
         Arrays.sort(arr);
         int n=arr.length;

         boolean []a=new boolean[t];
         char[] res=new char[t];
         int k=0;
         for(int i=0;i<n;i++)
         {
             for(int j=Math.min(t-1,arr[i].deadline-1);j>=0;j--)
             {
                 if(a[j]==false)
                 {
                     a[j]=true;
                     res[j]=arr[i].id;
                     k=k+arr[i].profit;
                     break;
                 }
             }
         }
         for(char j:res)
             System.out.println(j+" ");

         return k;

     }
}
