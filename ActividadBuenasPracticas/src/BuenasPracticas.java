import java.util.Scanner;
public class BuenasPracticas{
    public static void main(String[]a){
        Scanner sc=new Scanner(System.in);
        System.out.print("n:");int n=sc.nextInt();
        int s=0;
        for(int i=1;i<=n;i++){s+=i;}
        System.out.println("r:"+s);
    }}