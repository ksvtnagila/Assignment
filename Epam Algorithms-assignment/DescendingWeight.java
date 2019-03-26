package Epam.algorithms;
import java.util.*;
public class DescendingWeight {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        class Element implements Comparable<Element>{
            int value;
            int mod;
            Element(int value,int mod){
                this.value=value;
                this.mod=mod;
            }
            public int compareTo(Element n){
                if(this.mod<n.mod){
                    return 1;
                }
                else if(this.mod==n.mod){
                    if(this.value<n.value){
                        return -1;
                    }
                    else if(this.value==n.value){
                        return 0;
                    }
                    else{
                        return 1;
                    }
                }
                else{
                    return -1;
                }
            }
            @Override
            public String toString(){
                return ""+value;
            }
        }
        Element[] A=new Element[N];
        int num;
        for(int i=0;i<N;i++){
            num=sc.nextInt();
            A[i]=new Element(num,num%K);
            
        }
        Arrays.sort(A);
        for(Element n:A){
            System.out.print(n+" ");
        }
    }
}

