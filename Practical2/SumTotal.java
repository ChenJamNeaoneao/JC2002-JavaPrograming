//To get number from the user input
import java.util.Scanner;
public class SumTotal{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the started number:"); int x = input.nextInt();
        System.out.print("Enter the ended number:"); int y = input.nextInt();
        
        if (x > y){
            System.out.println("The started number must be smaller than the ended");
        }
        else
        {
            int sumTotal = 0;
            for (int total = x; total<= y; ++total){
                sumTotal += total;
            }
            System.out.println("The Total sum from your started number to your ended number is : " + sumTotal);
        }
        
        
    }
}