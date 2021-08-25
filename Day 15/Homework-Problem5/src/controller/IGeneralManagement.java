package controller;

public interface IGeneralManagement {
    void add();
    void display(String id);
    void displayAll();
    void edit(String id);
    void remove(String id);
    int searchById(String id);
    void request(String description);
}
