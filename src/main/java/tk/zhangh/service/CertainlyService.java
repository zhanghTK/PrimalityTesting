package tk.zhangh.service;

/**
 * 确定性算法service
 * Created by ZhangHao on 16/4/30.
 */
public class CertainlyService implements AlgorithmService{
    public boolean isPrime(String numberStr) {
        long num = Long.parseLong(numberStr);
        int i;
        for (i = 3;i <= Math.sqrt(num); i++){
            if (num % i == 0){
                break;
            }
        }
        if (i <= Math.sqrt(num)){
            return false;
        }else {
            return true;
        }
    }
}