package tk.zhangh.action;

import tk.zhangh.service.AlgorithmService;
import tk.zhangh.service.CertainlyAlgorithmService;
import javax.servlet.http.HttpServletRequest;

/**
 * 确定性算法action
 * Created by ZhangHao on 16/4/30.
 */
public class CertainlyAlgorithmAction extends BaseAction{
    @Override
    boolean isPrime(String numStr) {
        System.out.println("111");
        if (getAlgorithmService() == null){
            setAlgorithmService(new CertainlyAlgorithmService());
        }
        AlgorithmService service = getAlgorithmService();
        long num = Long.parseLong(numStr);
        return service.isPrime(num);
    }
}
