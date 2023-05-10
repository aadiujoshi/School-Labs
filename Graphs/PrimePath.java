import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class PrimePath {

    static int[] all_primes = new int[1061];
    static HashMap<Integer, HashSet<Integer>> primeMap = new HashMap<>();

    static {
        int j = 0;
        for(int i = 1000; i <= 9999; i++){
            if(isPrime(i))
                all_primes[j++] = i;
        }

        for(int pr : all_primes){
            HashSet<Integer> hs = new HashSet<>();

            for(int p : all_primes){
                if(diff1(pr, p) != -1)
                    hs.add(p);
            }   

            primeMap.put(pr, hs);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        start = in.nextInt();
        end = in.nextInt();
        
        System.out.println(search(start, 0));
        in.close();
    }

    static int start, end;
    static HashSet<Integer> checked = new HashSet<>();

    public static int search(int prime, int moves){
        if(prime == end) return moves;
        
        var map = primeMap.get(prime);
        int[] pos = new int[map.size()];
        int k = 0;
        for (int n : map) 
            pos[k++] = n;
        
        //sort by sameness to target
        for(int i = 0; i < pos.length; i++){
            int mi = i;
            int md = digDiff(end, pos[i]);

            for(int j = i+1; j < pos.length; j++){
                if(digDiff(end, pos[j]) < md){
                    mi = j;
                    md = digDiff(end, pos[j]);
                }
            }

            var tmp = pos[mi];
            pos[mi] = pos[i];
            pos[i] = tmp;
        }
        
        //FINISH FROM HERE AFTER SORTING
        //I CAN ALSO BE AN ACTUALLY GOOD CODER AND MEMOIZE/TABULATE THIS SO ITS LIKE 100X FASTER (SEARCH BOTTOM UP FROM TARGET)

        return -1;
    }

    private static int digDiff(int n1, int n2){
        if(n1 == n2) return 0;
        int d = 0;
        for(int m = 0; m <= 4; m++){
            if((n1 % 10) != (n2 % 10))
                d++;
            n1 /= 10;
            n2 /= 10;
        }
        return d;
    }

    //return single diff num of n2 from n1, -1 otherwise
    private static int diff1(int n1, int n2){
        if(n1 == n2) return -1;
        int d = -1;
        for(int m = 0; m <= 4; m++){
            if((n1 % 10) != (n2 % 10)){
                //diff of 2 or more
                if(d != -1) return -1;
                d = (n2 % 10);
            }
            n1 /= 10;
            n2 /= 10;
        }
        return d;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) 
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) 
            if (n % i == 0) 
                return false;
        return true;
    }
}
