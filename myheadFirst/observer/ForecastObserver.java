package myheadFirst.observer;

/**
 * Created by Administrator on 2017/2/16.
 */
public class ForecastObserver implements Observer {
    private float forecast;   //统计
    private Subject subject;

    @Override
    public void update(float total, float status, float forecast) {
        System.out.println("forecast的数据已更新");
        display(this.forecast,forecast);
        this.forecast = forecast;
    }

    public ForecastObserver(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    public void display(float start,float end){
        System.out.println("forecast的数据为"+end);
        System.out.println("forecast的数据从"+ start + "变为"+end);
    }
}