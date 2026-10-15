import java.util.Scanner;
public class st4{
    public static void main(String[] args){
        int n,on,sum,digit;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        on=n;
        sum=0;
        while(n>0){
            digit=n%10;
            sum+=digit*digit*digit;
            n=n/10;
        }if(sum==on){
            System.out.println("it is a armstrong number");
        }else{
            System.out.println("it is not a armstrong number");
        }
    }
}