package HW1;

import java.util.Arrays;

public class PrimeSieve {
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        boolean[] isPrime = new boolean[size];
        Arrays.fill(isPrime, true);
        isPrime[2] = true;
        isPrime[1] = false;
        isPrime[0] = false;
        for(int i = 0; i < size; ++i) {
            if(isPrime[i]) {
                for(int p = i * i; p < size; p += i) {
                    isPrime[p] = false;
                }
            }
        }
        for(int i = 0; i < isPrime.length; ++i){
            System.out.print(isPrime[i] + "," + i + " ");
        }
    }
}
