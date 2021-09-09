package controller;

import model.Const;

public interface IGeneralManagement<T> extends Const {

    T initFromKeyboard() throws IllegalArgumentException;

    boolean add(T t);

    void add(int index, T t);

    void display(String id);

    void displayAll();

    boolean update(String id);

    T remove(String id);
}