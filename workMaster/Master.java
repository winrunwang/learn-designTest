package workMaster;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2017/2/15.
 */
//任务的分配和最终结果的合成
public class Master {
    //任务队列
    protected Queue<Object> workQueue= new ConcurrentLinkedQueue<Object>();
    //Worker进程队列
    protected Map<String ,Thread> threadMap= new HashMap<String ,Thread>();
    //子任务处理结果集
    protected Map<String ,Object> resultMap= new ConcurrentHashMap<String, Object>();

    public Master(Worker worker,int countThread){
       worker.setResultMap(resultMap);
       worker.setWorkQueue(workQueue);
       for(int i=0;i<countThread;i++){
           threadMap.put(Integer.toString(i),new Thread(worker,Integer.toString(i)));
       }
    }

    public void submit(Object worker){
        workQueue.add(worker);
    }
    //返回子任务结果集
    public Map<String ,Object> getResultMap(){
        return resultMap;
    }

    public void execute(){
        for(Map.Entry<String , Thread> entry:threadMap.entrySet()){
            entry.getValue().start();
        }
    }

    public boolean isEnd(){
        for(Map.Entry<String , Thread> entry:threadMap.entrySet()){
           if(entry.getValue().getState()!=Thread.State.TERMINATED){
                 return false;
           }
        }
        return true;
    }

}
