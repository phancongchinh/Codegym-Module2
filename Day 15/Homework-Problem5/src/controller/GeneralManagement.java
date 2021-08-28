package controller;

public interface GeneralManagement<T> {
    boolean add(T t);
    void display(String id);
    void displayAll();
    boolean edit(String id);
    void remove(String id);
}
