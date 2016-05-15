package tk.zhangh.service.imp;

import tk.zhangh.service.AlgorithmService;
import tk.zhangh.util.BigIntegerUtils;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by ZhangHao on 16/5/15.
 */
public class SolovayStrassenService extends BaseService {
    public static final int iteration = 10;

    @Override
    public boolean oddIsPrime(BigInteger num) {
        return solovayStrassenTest(num);
    }

    public boolean solovayStrassenTest(BigInteger num) {
        if (num.equals(BigInteger.ZERO) || num.equals(BigInteger.ONE))
            return false;
        if (num.equals(BigIntegerUtils.TWO))
            return true;
        if (num.mod(BigIntegerUtils.TWO).equals(BigInteger.ZERO))
            return false;
        Random rand = new Random();
        for (int i = 0; i < iteration; i++)
        {
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
        if (a.compareTo(BigInteger.ZERO) < 0){
            a = a.multiply(BigIntegerUtils.MINUS_ONE);
            if (b.mod(BigIntegerUtils.FOUR).compareTo(BigIntegerUtils.THREE) == 0){
                j = j.multiply(BigIntegerUtils.MINUS_ONE);
            }
        }

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
        if (b.compareTo(BigInteger.ONE) == 0){
            return j;
        }
        return BigInteger.ZERO;
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
    }
}
