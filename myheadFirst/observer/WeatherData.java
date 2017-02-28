package myheadFirst.observer;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/16.
 */
public class WeatherData implements Subject{
    private ArrayList<Observer> list;
    private float total;   //统计
    private float status;   //状态
    private float forecast;  //预测

    public WeatherData() {
        this.list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = list.indexOf(observer);
        if(i>=0){
            list.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer: list) {
            observer.update(total,status,forecast);
        }
    }

    public void setDate(float total,float status,float forecast){
        this.total = total;
        this.status = status;
        this.forecast = forecast;
    }

    public void change(){
        notifyObserver();
    }
}
