package model.interfaces;

public interface ModelObservable {
    void addObserver(ModelObserver observer);
    void notifyObservers();
}
