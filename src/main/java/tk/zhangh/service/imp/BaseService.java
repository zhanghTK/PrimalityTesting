package tk.zhangh.service.imp;

import tk.zhangh.service.AlgorithmService;
import tk.zhangh.util.BigIntegerUtils;

import java.math.BigInteger;

/**
 * Created by ZhangHao on 16/5/15.
 */
public abstract class BaseService implements AlgorithmService{
    public boolean isEven(BigInteger num) {
        if (num.mod(BigIntegerUtils.TWO).equals(BigInteger.ZERO)){
            return true;
        }else {
            return false;
        }
    }

    public abstract boolean oddIsPrime(BigInteger integer);

    public boolean isPrime(String numberStr) {
        BigInteger num = new BigInteger(numberStr);
        if(isEven(num) && !num.equals(BigIntegerUtils.TWO)){
            return false;
        }
        return oddIsPrime(num);
    }
}
