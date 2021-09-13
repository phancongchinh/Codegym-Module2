package controller.Data;

import java.io.IOException;

public interface IDataManagement {
    void exportData() throws IOException;

    void importData() throws IOException;
}
