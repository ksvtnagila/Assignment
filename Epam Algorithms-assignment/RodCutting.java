package Epam.algorithms;
import java.util.*;
public class RodCutting {
    public static void main(String args[] ) throws Exception {
       Scanner sc=new Scanner(System.in);
       int numOfTestCases=sc.nextInt();
       for(int i=0;i<numOfTestCases;i++){
          int lengthOfRod=sc.nextInt();
          int specialRodLength=3;//The minimum rod length that a special rod can have is 3.
          int numberOfRods=0;//Incase the rod length is 1 or 2 the number of the special rods remains 0
        while(specialRodLength<=lengthOfRod){
            numberOfRods++;
            specialRodLength=2*specialRodLength+1;//The rod can be a special rod only when the parent rod is of length 
            //2*rodLength+1
        }
          System.out.println(numberOfRods);
    }
}
}
