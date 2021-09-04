package controller;

import model.Const;

public interface IGeneralManagement<T> extends Const {

    void add(T t);

    void display(String id);

    void displayAll();

    boolean update(String id);

    void delete(String id);
}
