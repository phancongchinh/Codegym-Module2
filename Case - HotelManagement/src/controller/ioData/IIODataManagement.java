package controller.ioData;

import model.Const;

import java.io.IOException;

public interface IIODataManagement extends Const {
    void exportData() throws IOException;

    void importData() throws IOException;
}
