package tk.zhangh.action;

import tk.zhangh.service.AlgorithmService;
import tk.zhangh.service.imp.MillerRabinService;

/**
 * Created by ZhangHao on 16/5/7.
 */
public class MillerRabinAction extends BaseAction{
    @Override
    boolean isPrime(String numStr) {
        if (getAlgorithmService() == null){
            setAlgorithmService(new MillerRabinService());
        }
        AlgorithmService service = getAlgorithmService();
        return service.isPrime(numStr);
    }
}
