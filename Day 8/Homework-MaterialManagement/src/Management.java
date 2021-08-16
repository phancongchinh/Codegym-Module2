import java.time.LocalDate;
import java.util.Scanner;

public class Management {
    Material[] materials = new Material[0];

    public void addMaterial(Material newMaterial) {
        Material[] newMaterials = new Material[materials.length + 1];
        System.arraycopy(materials, 0, newMaterials, 0, materials.length);
        newMaterials[newMaterials.length-1] = newMaterial;
        materials = newMaterials;
    }

    public void displayMaterial(String id) {
        int index = searchById(id);
        System.out.println(materials[index]);
    }

    public void displayAllMaterials() {
        if (materials.length == 0) {
            System.out.println(Const.EMPTY_LIST);
        } else {
            System.out.println(Const.CURRENT_LIST);
            for (Material material : materials) {
                System.out.println(material);
            }
        }
    }

    public void editMaterial(String id, Scanner scanner) {
        int index = searchById(id);
        int choice;
        do {
            drawEditMenu(id);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    Main.request(Const.NEW_NAME);
                    materials[index].setName(scanner.nextLine());
                    break;
                case 2:
                    scanner.nextLine();
                    Main.request(Const.NEW_ID);
                    materials[index].setId(scanner.nextLine());
                    return;
                case 3:
                    scanner.nextLine();
                    Main.request(Const.NEW_MFG);
                    materials[index].setManufacturingDate(LocalDate.parse(scanner.nextLine()));
                    break;
                case 4:
                    Main.request(Const.NEW_LIST_PRICE);
                    materials[index].setListPrice(scanner.nextInt());
                    break;
                case 5:
                    if (materials[index] instanceof Meat) {
                        Main.request(Const.NEW_WEIGHT);
                        ((Meat) materials[index]).setWeight(scanner.nextDouble());
                    }
                    if (materials[index] instanceof CrispyFlour) {
                        Main.request(Const.NEW_QUANTITY);
                        ((CrispyFlour) materials[index]).setQuantity(scanner.nextInt());
                    }
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        } while (choice !=0);
    }

    public void deleteMaterial(String id) {
        int index = searchById(id);
        Material[] newMaterials = new Material[materials.length - 1];
        System.arraycopy(materials, 0, newMaterials, 0, index);
        System.arraycopy(materials, index + 1, newMaterials, index, materials.length - index - 1);
        materials = newMaterials;
    }

    public int searchById(String id) {
        int index = -1;
        for (int i = 0; i < materials.length; i++) {
            if (materials[i].getId().compareTo(id) == 0) {
                index = i;
            }
        }
        return index;
    }

    public boolean doesExist(String ID){
        for (Material material : materials) {
            if (material.getId().compareTo(ID) == 0) {
                return true;
            }
        }
        return false;
    }

    public void sortByName() {
        for (int i = 0; i < materials.length; i++) {
            for (int j = i+1; j < materials.length; j++) {
                if (materials[i].getName().compareTo(materials[j].getName()) > 0){
                    Material temp = materials[i];
                    materials[i] = materials[j];
                    materials[j] = temp;
                }
            }
        }
    }

    public void drawEditMenu(String id) {
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("Material ID: " + id);
        displayMaterial(id);
        System.out.println("EDIT MENU!");
        System.out.println("\t 1. Change name!");
        System.out.println("\t 2. Change ID (Back to MAIN MENU required)!");
        System.out.println("\t 3. Change manufacturing date!");
        System.out.println("\t 4. Change list price!");

        int index = searchById(id);

        if (materials[index] instanceof Meat) {
            System.out.println("\t 5. Change weight!");
        }

        if (materials[index] instanceof CrispyFlour) {
            System.out.println("\t 5. Change quantity!");
        }

        System.out.println("\t 0. Back to MAIN MENU!");
        System.out.println("------------------------------------------------------------------------");
        System.out.print(Const.MAKE_CHOICE);
    }
}
