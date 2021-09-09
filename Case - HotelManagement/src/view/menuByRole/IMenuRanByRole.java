package view.menuByRole;

import model.Const;
import model.Role;
import view.IMenu;

public interface IMenuRanByRole extends IMenu,Const {
    void ranByRole(Role role);
}