package tk.zhangh.service;

import java.math.BigInteger;

/**
 * 确定性算法service
 * Created by ZhangHao on 16/4/30.
 */
public class CertainlyService implements AlgorithmService{
    public boolean isPrime(String numberStr) {
//        long num = Long.parseLong(numberStr);
//        int i;
//        for (i = 3;i <= Math.sqrt(num); i++){
//            if (num % i == 0){
//                break;
//            }
//        }
//        if (i <= Math.sqrt(num)){
//            return false;
//        }else {
//            return true;
//        }
        BigInteger num = new BigInteger(numberStr);
        BigInteger index = new BigInteger("3");
        for (index = new BigInteger("3"); index.compareTo(num)==-1;index=index.add(new BigInteger("1"))){
            if (num.mod(index).equals(new BigInteger("0"))){
                break;
            }
        }
        if (index.compareTo(num)==-1){
            return false;
        }else {
            return true;
        }
    }
}
