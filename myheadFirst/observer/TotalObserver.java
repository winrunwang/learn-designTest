package myheadFirst.observer;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/16.
 */
public class TotalObserver implements Observer {
    private float total = 0;   //统计
    private Subject subject;

    @Override
    public void update(float total, float status, float forecast) {
        System.out.println("total的数据已更新");
        display(this.total,total);
        this.total = total;
    }

    public TotalObserver(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    public void display(float start,float end){
        System.out.println("total的数据为1"+end);
        System.out.println("total的数据从"+ start + "变为"+end);
    }
}