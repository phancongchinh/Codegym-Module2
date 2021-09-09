package controller.personalInformation;

import controller.guest.GuestManagement;
import controller.staff.StaffManagement;
import model.Const;
import model.PersonalInformation;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PersonalInformationManagement implements IPersonalInformationManagement, Const {

    private static final GuestManagement GUEST_MANAGEMENT = GuestManagement.getInstance();
    private static final StaffManagement STAFF_MANAGEMENT = StaffManagement.getInstance();

    private PersonalInformationManagement(){}

    public static PersonalInformationManagement getInstance() {
        return PersonalInformationManagementHelper.INSTANCE;
    }

    private static class PersonalInformationManagementHelper {
        private static final PersonalInformationManagement INSTANCE = new PersonalInformationManagement();
    }

    @Override
    public PersonalInformation initInformationForA(String description) {
        System.out.print(ENTER_PERSONAL_ID);
        String id = scanner.nextLine();
        switch (description) {
            case GUEST: {
                if (GUEST_MANAGEMENT.existsGuestId(id)) {
                    System.out.println(GUEST_ID_EXISTED);
                    return null;
                }
            }
            case STAFF: {
                if (STAFF_MANAGEMENT.existsStaffId(id)) {
                    System.out.println(STAFF_ID_EXISTED);
                    return null;
                }
            }
        }

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