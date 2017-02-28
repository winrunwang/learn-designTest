package myheadFirst.observer;

/**
 * Created by Administrator on 2017/2/17.
 */
public class TestMain {
    public static void main(String[] args) {
        WeatherData wd = new WeatherData();
        TotalObserver to = new TotalObserver(wd);
        StatusObserver so = new StatusObserver(wd);
        ForecastObserver fo = new ForecastObserver(wd);
        wd.setDate(1,2,3);
        wd.change();
        wd.setDate(2,3,4);
        wd.change();
        wd.removeObserver(to);
        wd.setDate(3,4,5);
        wd.change();
    }
}
