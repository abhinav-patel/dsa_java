package Greedy;
import java.util.Arrays;
import java.util.Comparator;

class Activity
{
    int start;
    int finish;
    Activity(int a,int b)
    {
        start=a;
        finish=b;
    }
}
class myCmp implements Comparator<Activity>
{
    public int compare(Activity a,Activity b)
    {
        return (a.finish- b.finish);
    }
}

class Main
{
    public static void main(String []args)
    {
        Activity [] arr= new Activity[]{new Activity(2, 3),
                new Activity(5, 8),
                new Activity(6, 10),
                new Activity(1, 4)};

        System.out.println(maxActivity(arr));
    }
    static int maxActivity(Activity []arr)
    {
        Arrays.sort(arr,new myCmp());
        int res=1;
        int prev=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i].start>=arr[prev].finish)
            {
                res++;
                prev=i;
            }
        }
        return res;
    }
}