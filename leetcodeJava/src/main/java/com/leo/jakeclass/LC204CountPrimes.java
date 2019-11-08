package com.leo.jakeclass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LC204CountPrimes {
    public static void printPrime(int n) {
        int count = 0;// for number 2;
        for (int i = 2; i < n; i++) {
            if (i > 2 && i % 2 == 0) {
                continue;
            }
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }

            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }

    public static int countPrimes(int n) {
        //corner
        if (n < 2) {
            return 0;
        }

        //init
        boolean[] isPrimes = new boolean[n];
        for (int i = 0; i < isPrimes.length; i++) {
            isPrimes[i] = true;
        }
        int count = 0;
        //iter
        for (int i = 2; i < n; i++) {
            if (!isPrimes[i]) {
                continue;
            }

            if (isPrime(i)) {
                for (int j = i * i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }

        for (int i = 2; i < isPrimes.length; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }
        //return
        return count;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        countPrimes(499979);
    }
}

