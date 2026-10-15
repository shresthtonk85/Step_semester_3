import java.util.Scanner;
public class st5 {
    public static void main(String[] args) {
        int num,orignum,sum,digit;
        Scanner sc=new Scanner(System.in);
        num=sc.nextInt();
        orignum=num;
        sum=0;
        while(num>0){
            digit=num%10;
            sum+=digit*digit*digit;
            num=num/10;
        }
        if(sum==orignum){
            System.out.println("it is an Armstrong number");
        }else{
            System.out.println("it is not an Armstrong number");
        }
    }
}
