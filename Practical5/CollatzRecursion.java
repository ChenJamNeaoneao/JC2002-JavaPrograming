import java.util.*;

public class CollatzRecursion{
    public static int count = 0;
    public static void printCollatz(int n){
        if(n == 1){
            return;
        }
            else if (n % 2 ==0){
                count += 1;
                System.out.println(n);
                printCollatz(n/2);
            }
            else{
                count += 1;
                System.out.println(n);
                printCollatz(3 * n + 1);
            }
        }

    public static void main(String arg[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integar:");
        int n = scanner.nextInt();
    
        try{
            if (n <= 0){
                throw new IllegalArgumentException("Please use valid n \n( n should be greater than zero)");
            }
            System.out.println("Collatz sequence for n = " + n + ":");
            printCollatz(n);
            System.out.println("For initial n = :" + n + " it took " + count + " steps to reach 1."); 
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }           
    }

}





