package tk.zhangh.action;

import tk.zhangh.service.AlgorithmService;
import tk.zhangh.service.CertainlyService;

/**
 * 确定性算法action
 * Created by ZhangHao on 16/4/30.
 */
public class CertainlyAction extends BaseAction{
    @Override
    boolean isPrime(String numStr) {
        if (getAlgorithmService() == null){
            setAlgorithmService(new CertainlyService());
        }
        AlgorithmService service = getAlgorithmService();
        return service.isPrime(numStr);
    }
}
