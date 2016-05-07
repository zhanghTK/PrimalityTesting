package tk.zhangh.action;

import tk.zhangh.service.AlgorithmService;

/**
 * Created by ZhangHao on 16/5/7.
 */
public class MillerRabinAction extends BaseAction{
    @Override
    boolean isPrime(String numStr) {
//        if (getAlgorithmService() == null){
//            setAlgorithmService(new CertainlyService());
//        }
        AlgorithmService service = getAlgorithmService();
        return service.isPrime(numStr);
    }
}
