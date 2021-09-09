package controller.personalInformation;

import model.Const;
import model.PersonalInformation;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PersonalInformationManagement implements IPersonalInformationManagement, Const {

    private PersonalInformationManagement(){}

    public static PersonalInformationManagement getInstance() {
        return PersonalInformationManagementHelper.INSTANCE;
    }

    private static class PersonalInformationManagementHelper {
        private static final PersonalInformationManagement INSTANCE = new PersonalInformationManagement();
    }

    @Override
    public PersonalInformation initFromKeyBoard() {
        System.out.print(ENTER_PERSONAL_ID);
        String id = scanner.nextLine();
        System.out.print(ENTER_NAME);
        String name = scanner.nextLine();
        System.out.print(ENTER_DATE_OF_BIRTH);
        LocalDate dateOfBirth;
        try {
          dateOfBirth = LocalDate.parse(scanner.nextLine());
        }
        catch (DateTimeParseException exception) {
            System.out.println(EXCEPTION_DATE_TIME_PARSE);
            return null;
        }
        return new PersonalInformation(id, name, dateOfBirth);
    }
}