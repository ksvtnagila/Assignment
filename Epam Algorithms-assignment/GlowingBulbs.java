package Epam.algorithms;

import java.util.*;
 
public class GlowingBulbs {
    
    static long len;
    static ArrayList<Integer> nums;
    public static void main(String args[] ) throws Exception {
       Scanner sc=new Scanner(System.in);
        int numOfTestcases = sc.nextInt();
        while(numOfTestcases-->0)
        {
             String line = sc.next();
             String input=sc.next();
             long k = Long.parseLong(input);
              nums=new ArrayList();
             int i,j;
             for(i=0;i<40;i++)
             {
                 if(line.charAt(i)=='1')
                 {
                     nums.add(i+1);
                 }
             }
             len=nums.size();
             long top=SearchOperation(k);
             System.out.println(top);
        }
    }
    
    static long SearchOperation(long k)
    {
        long low=1; long high=(long)Math.pow(10,15); high*=37; long result=0;
        while(low<=high)
        {
            long mid=(low+high)/2;
            long flg=calulate( mid);
            if(flg<k)
            {
                low=mid+1;
            }
            else {result=mid;high=mid-1;}
        }
        return result;
        
    }
    
    static long calulate(long max)
    {
        int y; long tot=0; int num1=1;
        for(y=1;y<(int)Math.pow(2,len);y++)
        {
            int flag=y;
            long mul1=1; int numof1=0,ind=0;
            while(flag!=0)
            {
                if((flag&1)>0)
                {
                    mul1*=(long)nums.get(ind); numof1++;
                }
                
                ind++;
                flag=flag>>1;
            }
            if(numof1%2==0)
            {
                tot-=max/mul1;
            }
            else
            tot+=max/mul1;
        }
        return tot;
    }
    
}
