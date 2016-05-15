package tk.zhangh.service;

import tk.zhangh.util.BigIntegerUtils;

import java.math.BigInteger;

/**
 * 确定性算法service
 * Created by ZhangHao on 16/4/30.
 */
public class CertainlyService extends BaseService{
    public boolean oddIsPrime(BigInteger num) {
        if(isEven(num) && !num.equals(BigIntegerUtils.TWO)){
            return false;
        }
        BigInteger index;
        for (index = BigIntegerUtils.TWO; index.compareTo(num)==-1;index=index.add(BigInteger.ONE)){
            if (num.mod(index).equals(BigInteger.ZERO)){
                break;
            }
        }
        if (index.compareTo(num)==-1){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 3; i < 10000; i++) {
            boolean r = new CertainlyService().isPrime(Integer.toString(i));
            if (r){
                count++;
            }
            System.out.println(i + " is " + r);
        }
        System.out.println(count);
    }
}
