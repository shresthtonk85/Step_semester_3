import java.util.Scanner;
public class st1{
    public static void main(String[] args){
        int n;
        boolean isPrime=true;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=2;i<n;i++){
            if(n%i==0){
                isPrime=false;
                break;
            }
        }System.out.println("is the number "+n+" prime? "+isPrime);
    }
}