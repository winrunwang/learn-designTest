package workMaster;

import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/15.
 */
public class Test {
    public static void main(String[] args) {
        //计算一个1-100的数
        Master master  =  new Master(new Handle(),5);
        for(int i=0;i<100;i++){
            master.submit(i);
        }
        master.execute();
        int re = 0;
        Map<String ,Object> resultMap =master.getResultMap();
        while(resultMap.size()>0 || !master.isEnd()){
            Set<String> keys = resultMap.keySet();
            String key =null;
            for(String k:keys){
                key=k;
                break;
            }
            Integer i =null;
            if(key!=null){
                i=(Integer)resultMap.get(key);
            }
            if(i!=null){
                //最终结果
                re+=i;
            }
            if(key!=null){
                //移除已经被计算过的项
                resultMap.remove(key);
            }
        }
        System.out.println(re);
    }
}
