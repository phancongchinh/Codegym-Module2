package controller;

import model.Const;

public interface IGeneralManagement<T> extends Const {

    T initFromKeyboard() throws IllegalArgumentException;

    void add(T t);

    void display(String id);

    void displayAll();

    boolean update(String id);

    void remove(String id);
}