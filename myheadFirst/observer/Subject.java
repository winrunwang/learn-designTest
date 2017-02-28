package myheadFirst.observer;

/**
 * Created by Administrator on 2017/2/17.
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
