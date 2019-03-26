package Epam.algorithms;
import java.util.*;

public class HelpOutTheIndianArmy
{
	
	
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		int numCheckPoints =sc.nextInt();
		long startingPoint = sc.nextLong();
		long endingPoint = sc.nextLong();
		
		Fleet[] farr = new Fleet[numCheckPoints];
		for(int i=0;i<numCheckPoints;i++)
		{
			long x = sc.nextLong();
			long p = sc.nextLong();
			farr[i] = new Fleet(x-p,x+p);
		}
		
		Arrays.sort(farr);
		ArrayList<Fleet> b = new ArrayList<Fleet>();
		
		long c = farr[0].left;
		long d = farr[0].right;
		
		
		for(int i=1;i<numCheckPoints;i++)
		{
			if(farr[i].left<=d)
				d = Math.max(d, farr[i].right);
			else
			{
				b.add(new Fleet(c,d));
				c = farr[i].left;
				d = farr[i].right;
			}
		}
		b.add(new Fleet(c,d));
		int i;
		long ans = 0;
		for(i=0;i<b.size();i++)
		{
			if(startingPoint>=endingPoint)
			{
				startingPoint = endingPoint;
				break;
			}
			
			if(b.get(i).left<=startingPoint && startingPoint<=b.get(i).right)
				startingPoint = b.get(i).right;
			
			else if(startingPoint<=b.get(i).left && endingPoint>=b.get(i).right)
			{
				ans+=b.get(i).left-startingPoint;
				startingPoint = b.get(i).right;
				
			}
			else if(startingPoint<=b.get(i).left && endingPoint>=b.get(i).left &&  endingPoint<=b.get(i).right)
			{
				ans+=b.get(i).left-startingPoint;
				startingPoint = endingPoint;
			}
			
			else if(startingPoint<=b.get(i).left && endingPoint<=b.get(i).left)
			{
				ans+=endingPoint-startingPoint;
				startingPoint = endingPoint;
			}
		}
		
		if(startingPoint<endingPoint)
			ans+=endingPoint-startingPoint;
		System.out.println(ans);
		
	}
}
 class Fleet implements Comparable<Fleet>{
    long left;
    long right;
    Fleet(long i,long s){
       left=i;
       right=s;
    }
    public int compareTo(Fleet o){
        if(left>o.left)
        return 1;
        else if(left==o.left)
        return 0;
        else
        return -1;
    }
}