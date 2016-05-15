package tk.zhangh.service;

import java.math.BigInteger;

/**
 * 算法service
 * Created by ZhangHao on 16/4/30.
 */
public interface AlgorithmService {
    boolean isPrime(String numberStr);
    boolean isEven(BigInteger num);
}
