package view.manager;

import view.IMenu;

public class InvoiceManagementMenu implements IMenu {
    private InvoiceManagementMenu(){}

    public static InvoiceManagementMenu getInstance() {
        return InvoiceMenuHelper.INSTANCE;
    }

    private static class InvoiceMenuHelper{
        private static final InvoiceManagementMenu INSTANCE = new InvoiceManagementMenu();
    }


    @Override
    public void draw() {

    }

    @Override
    public void run() {

    }
}
