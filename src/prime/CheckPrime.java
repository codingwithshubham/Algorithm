package prime;
/**
 * CheckPrime
 */
import java.util.*;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for(int i=2; i*i<=num; i++){
            if(num%i == 0){
                System.out.print("Not Prime");
                return;
            }
        }
        System.out.println("Prime");
    }
    
}