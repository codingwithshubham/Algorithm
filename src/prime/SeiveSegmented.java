package prime;

import java.util.*;
/**
 * printing primes upto n
 */
public class SeiveSegmented{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        segmentedSieve(num);

        sc.close();
    }

    static void segmentedSieve(int n){
        int segment = (int) Math.sqrt(n);
        int low = segment+1; // as for 1 to segment will be printed using seive when find prime
        int high =2*segment;

        //getting prime list upto sqrt(n)
        ArrayList primes = getPrimes(segment);

                                            
        while(low <= n){
           // for case  eg. [1 2 3] [ 4 5 6][ 7 8 9] [10] 
            if(high>n)
                high = n;

            boolean[] isPrimeSegment = new boolean[high-low+1];
            
            for( int i=0; i<high-low+1; i++){
                isPrimeSegment[i] = true;
            }
            
            /*
             * 	0    1      2
             *  low low+1 low+2
             */

            for(int i=0; i<primes.size(); i++){
                int prime = (int)primes.get(i);

                //getting base value which is multiple of current prime no.
                int base = low/prime*prime;
                if(base<low){
                    base = base+prime;
                }
                //if base become prime
                if(base == prime)
                    base = base+prime;
                
                for(int j = base; j<=high; j+=prime){
                   if(j%prime == 0)
                        isPrimeSegment[j-low] = false; 
                }
            }

            for(int i=0; i<high-low+1; i++){
                if(isPrimeSegment[i] == true)
                    System.out.print(i+low+" ");
            }

            low+=segment;
            high+=segment;
        }

    }

    //simple seive to get list of prime nos. upto sqrt(n)
    static ArrayList getPrimes(int n){
        boolean[] isPrime = new boolean[n+1];
        ArrayList primes = new ArrayList();
        
        //assuming only odd as prime
        for(int i=3; i<n+1; i+=2){
            isPrime[i] = true;
        }

        //iterating odd only
        for(int i=3; i*i<=n; i+=2){
            if(isPrime[i] == true){
                for(int j=i*i; j<=n; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        //special case i.e. 2 is only even no. which is prime 
        primes.add(2);
        System.out.print(2+" ");
        
        for(int i=3; i<n+1; i+=2){
            if(isPrime[i] == true){
                primes.add(i);
                System.out.print(i+" ");
            }
        }

        return primes;
    }
}

// time complexity : O(nlog(log(n)))
// space complexity : O(sqrt(n))