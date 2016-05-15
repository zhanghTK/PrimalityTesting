package tk.zhangh.action;

import tk.zhangh.service.AlgorithmService;
import tk.zhangh.service.SolovayStrassenService;

/**
 * Created by ZhangHao on 16/5/15.
 */
public class SolovayStrassenAction extends BaseAction{
    @Override
    boolean isPrime(String numStr) {
        if (getAlgorithmService() == null){
            setAlgorithmService(new SolovayStrassenService());
        }
        AlgorithmService service = getAlgorithmService();
        return service.isPrime(numStr);
    }
}
