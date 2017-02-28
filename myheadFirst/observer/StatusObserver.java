package myheadFirst.observer;

/**
 * Created by Administrator on 2017/2/16.
 */
public class StatusObserver implements Observer {
    private float status;   //统计
    private Subject subject;

    @Override
    public void update(float total, float status, float forecast) {
        System.out.println("status的数据已更新");
        display(this.status,status);
        this.status = status;
    }

    public StatusObserver(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    public void display(float start,float end){
        System.out.println("status的数据为"+end);
        System.out.println("status的数据从"+ start + "变为"+end);
    }
}