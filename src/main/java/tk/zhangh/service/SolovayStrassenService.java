package tk.zhangh.service;

import tk.zhangh.util.BigIntegerUtils;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by ZhangHao on 16/5/15.
 */
public class SolovayStrassenService extends BaseService{
    public static final int iteration = 10;

    @Override
    public boolean oddIsPrime(BigInteger num) {
        return solovayStrassenTest(num);
    }

    public boolean solovayStrassenTest(BigInteger num) {
        /** base case **/
        if (num.equals(BigInteger.ZERO) || num.equals(BigInteger.ONE))
            return false;
//        if (n == 0 || n == 1)
//            return false;
        /** base case - 2 is prime **/
        if (num.equals(BigIntegerUtils.TWO))
            return true;
//        if (n == 2)
//            return true;
        /** an even number other than 2 is composite **/
        if (num.mod(BigIntegerUtils.TWO).equals(BigInteger.ZERO))
            return false;
//        if (n % 2 == 0)
//            return false;
        Random rand = new Random();
        for (int i = 0; i < iteration; i++)
        {
//            long r = Math.abs(rand.nextLong());
//            long a = r % (num - 1) + 1;
//            long jacobian = (num + Jacobi(a, num)) % num;
//            long mod = modPow(a, (num - 1)/2, num);
//            if(jacobian == 0 || mod != jacobian)
//                return false;
            Long t = Math.abs(rand.nextLong());
            BigInteger r = BigInteger.valueOf(t);
            BigInteger a = r.mod(num.subtract(BigInteger.ONE)).add(BigInteger.ONE);
            BigInteger jacobian = num.add(jacobi(a, num)).mod(num);
            BigInteger mod = modPow(a, num.subtract(BigInteger.ONE).divide(BigIntegerUtils.TWO), num);
            if (jacobian.equals(BigInteger.ZERO) || !mod.equals(jacobian)){
                return false;
            }
        }
        return true;
    }

    public BigInteger modPow(BigInteger a, BigInteger b, BigInteger c) {
//                long res = 1;
//        for (int i = 0; i < b; i++)
//        {
//            res *= a;
//            res %= c;
//        }
//        return res % c;
        BigInteger res = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(b) < 0; i = i.add(BigInteger.ONE)) {
            res = res.multiply(a);
            res = res.mod(c);
        }
        return res.mod(c);
    }

    public BigInteger jacobi(BigInteger a, BigInteger b) {
        if (b.compareTo(BigInteger.ZERO) <= 0 || b.mod(BigIntegerUtils.TWO).compareTo(BigInteger.ZERO) == 0){
            return BigInteger.ZERO;
        }
        BigInteger j = BigInteger.ONE;
//        if (b <= 0 || b % 2 == 0)
//            return 0;
//        long j = 1L;
        if (a.compareTo(BigInteger.ZERO) < 0){
            a = a.multiply(BigIntegerUtils.MINUS_ONE);
            if (b.mod(BigIntegerUtils.FOUR).compareTo(BigIntegerUtils.THREE) == 0){
                j = j.multiply(BigIntegerUtils.MINUS_ONE);
            }
        }
//        if (a < 0)
//        {
//            a = -a;
//            if (b % 4 == 3)
//                j = -j;
//        }

        while (!a.equals(BigInteger.ZERO)){
            while (a.mod(BigIntegerUtils.TWO).equals(BigInteger.ZERO)){
                a = a.divide(BigIntegerUtils.TWO);
                if (b.mod(BigIntegerUtils.EIGHT).compareTo(BigIntegerUtils.THREE) == 0 || b.mod(BigIntegerUtils.EIGHT).compareTo(BigIntegerUtils.FIVE) == 0){
                    j = j.multiply(BigIntegerUtils.MINUS_ONE);
                }
            }
            BigInteger temp = a;
            a = b;
            b = temp;
            if (a.mod(BigIntegerUtils.FOUR).compareTo(BigIntegerUtils.THREE) == 0 && b.mod(BigIntegerUtils.FOUR).compareTo(BigIntegerUtils.THREE) == 0){
                j = j.multiply(BigIntegerUtils.MINUS_ONE);
            }
            a = a.mod(b);
        }
//        while (a != 0)
//        {
//            while (a % 2 == 0)
//            {
//                a /= 2;
//                if (b % 8 == 3 || b % 8 == 5)
//                    j = -j;
//            }
//
//            long temp = a;
//            a = b;
//            b = temp;
//
//            if (a % 4 == 3 && b % 4 == 3)
//                j = -j;
//            a %= b;
//        }
        if (b.compareTo(BigInteger.ONE) == 0){
            return j;
        }
        return BigInteger.ZERO;
//        if (b == 1)
//            return j;
//        return 0;
    }

    public static void main(String[] args) {
        AlgorithmService service = new SolovayStrassenService();
        int count = 0;
        for (int i = 3; i < 10000; i++) {
            if (service.isPrime(""+i)){
                count++;
            }
        }
        System.out.println(count);
        System.out.println(service.isPrime(""+4));
        System.out.println(service.isPrime(""+5));
        System.out.println(service.isPrime(""+6));
        System.out.println(service.isPrime(""+7));
        System.out.println(service.isPrime(""+8));
        System.out.println(service.isPrime(""+9));
    }
}
