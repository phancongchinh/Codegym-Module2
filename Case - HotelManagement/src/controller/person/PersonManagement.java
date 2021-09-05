package controller.person;

import model.Const;
import model.PersonalInformation;

import java.time.LocalDate;

public abstract class PersonManagement implements Const {

    public PersonalInformation initFromKeyBoard() {
        System.out.print(ENTER_PERSONAL_ID);
        String id = scanner.nextLine();
        System.out.print(ENTER_NAME);
        String name = scanner.nextLine();
        System.out.print(ENTER_DATE_OF_BIRTH);
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
        return new PersonalInformation(id, name, dateOfBirth);
    }
}