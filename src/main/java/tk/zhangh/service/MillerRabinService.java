package tk.zhangh.service;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by ZhangHao on 16/5/7.
 */
public class MillerRabinService implements AlgorithmService{
    public static final int Times = 10;

    public boolean isPrime(String numberStr) {
        BigInteger num = new BigInteger(numberStr);
        boolean result = millerRabinTest(num);
        return result;
    }

    public BigInteger quickMod(BigInteger a, BigInteger b, BigInteger m){
        BigInteger ans = BigInteger.ONE;
        a = a.mod(m);
        while(!(b.equals(BigInteger.ZERO))){
            if((b.mod(BigInteger.valueOf(2))).equals(BigInteger.ONE)){
                ans = (ans.multiply(a)).mod(m);
                b = b.subtract(BigInteger.ONE);
            }
            b = b.divide(BigInteger.valueOf(2));
            a = (a.multiply(a)).mod(m);
        }
        return ans;
    }

    public boolean millerRabinTest(BigInteger n){
        if(n.equals(BigInteger.valueOf(2))) return true;
        if(n.equals(BigInteger.ONE)) return false;
        if((n.mod(BigInteger.valueOf(2))).equals(BigInteger.ZERO)) return false;
        BigInteger m = n.subtract(BigInteger.ONE);
        BigInteger y = BigInteger.ZERO;
        int k = 0;
        while((m.mod(BigInteger.valueOf(2))).equals(BigInteger.ZERO)){
            k++;
            m = m.divide(BigInteger.valueOf(2));
        }
        Random d = new Random();
        for(int i=0;i<Times;i++){
            int t = 0;
            if(n.compareTo(BigInteger.valueOf(10000)) == 1){
                t = 10000;
            }else{
                t = n.intValue() - 1;
            }
            int a = d.nextInt(t) + 1;
            BigInteger x = quickMod(BigInteger.valueOf(a),m,n);
            for(int j=0;j<k;j++){
                y = (x.multiply(x)).mod(n);
                if(y.equals(BigInteger.ONE) && !(x.equals(BigInteger.ONE)) && !(x.equals(n.subtract(BigInteger.ONE)))) return false;
                x = y;
            }
            if(!(y.equals(BigInteger.ONE))) return false;
        }
        return true;
    }
}
