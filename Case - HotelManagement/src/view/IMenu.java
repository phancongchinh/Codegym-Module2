package view;

import model.Const;

public interface IMenu extends Const {
    void draw();

    void handleChoice(String choice);
}
