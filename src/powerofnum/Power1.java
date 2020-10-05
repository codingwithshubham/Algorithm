package powerofnum;

public class Power1 {
    public static void main(String[] args) {
        System.out.println(power(5, 2));
    }

    static int power(int n, int m){
        int ans = 1;
        

        for(int i=0; i<m; i++){
            ans = ans * n;
        }
        return ans;
    }
    
}

//Time : O(n)
//space : O(1)
