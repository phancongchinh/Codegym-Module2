package controller.contact;

import model.Const;

public interface IContactManagement<T> extends Const {

    T initFromKeyboard() throws IllegalArgumentException;

    boolean add(T t);

    void add(int index, T t);

    void display(String phoneNumber);

    void displayAll();

    boolean update(String phoneNumber);

    T remove(String phoneNumber);
}
