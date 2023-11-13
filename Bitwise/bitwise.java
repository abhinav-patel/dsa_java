package Bitwise;
import java.util.*;
public class bitwise
{
    void checkKthBit(int n,int k)
    {
        if((n&(1<<(k-1)))!=0)
            System.out.println("Yes");
        else
            System.out.println("no");
    }
    void checkKthBit2(int n,int k)
    {
        if(((n>>(k-1))&1)==1)
            System.out.println("Yes");
        else
            System.out.println("no");
    }

     void countSetBits(int n) //naive solution
    {
        int c=0;
        while(n>0)
        {
            if((n&1)==1) //if(n%2)==0;
                c++;
            n=n>>1;      //n=n/2;
        }
    }
    //Brian Kernnigham's solution
    int countSETBITS(int n) //O(set bits)
    {
        int res=0;
        while(n>0)
        {
            n=n&(n-1);
            res++;
        }
        return res;
    }

    //lookup table method O(1) time
    int table[]=new int[256];
    void initialize()
    {
        table[0]=0;
        for(int i=1;i<256;i++)
            table[i]=(i&1)+table[i/2];
    }
    int count(int n)
    {
        int res=table[n&0xff];
        n=n>>8;
        res=res+ table[n&0xff];
        n=n>>8;
        res=res+ table[n&0xff];
        n=n>>8;
        res=res+ table[n&0xff];
        return res;
    }

    //checking if the number is power of two or not- Brian Kernningham's algo-the number of set bits will be one;
    //diff method:
    void powerOfTwo(int n)
    {
        if(n==0)
            System.out.println("false");
        else
            System.out.println(((n&(n-1))==0)?"True":"False");

    }

    //finding only odd occuring number
    //XOR all of them
}
