import java.util.Scanner;

public class ReadOutLoud {

    public static void main(String[] args) {
        displayResult(
                readTheNumber()
        );
        readAnother();
    }

    public static int getInputNumber() {
        System.out.println("Enter the number:");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String readTheNumber() {
        int number = getInputNumber();
        if (number > 999 || number < 0) {
            return "Out of ability!";
        } else {
            String numberString = (new Integer(number)).toString();
            switch (numberString.length()) {
                case 1:
                    return read(numberString.charAt(0));
                case 2:
                    return readTwoDigitNumber(numberString);
                case 3:
                    return readThreeDigitNumber(numberString);
                default:
                    return "";
            }
        }
    }

    public static void displayResult(String str) {
        System.out.println(str);
    }

    public static String read(char digit) {
        switch (digit) {
            case '0':
                return "không";
            case '1':
                return "một";
            case '2':
                return "hai";
            case '3':
                return "ba";
            case '4':
                return "bốn";
            case '5':
                return "năm";
            case '6':
                return "sáu";
            case '7':
                return "bảy";
            case '8':
                return "tám";
            case '9':
                return "chín";
            default:
                return "";
        }
    }

    public static String readTwoDigitNumber(String numObj) {
        if (numObj.charAt(0) == '1') {
            switch (numObj.charAt(1)) {
                case '0':
                    return "mười";
                case '5':
                    return "mười lăm";
                default:
                    return "mười " + read((numObj.charAt(1)));
            }
        } else {
            switch (numObj.charAt(1)) {
                case '0':
                    return read(numObj.charAt(0)) + " mươi";
                case '1':
                    return read(numObj.charAt(0)) + " mươi mốt";
                case '4':
                    return read(numObj.charAt(0)) + " mươi tư";
                case '5':
                    return read(numObj.charAt(0)) + " mươi lăm";
                default:
                    return read(numObj.charAt(0)) + " mươi " + read((numObj.charAt(1)));
            }
        }
    }

    public static String readThreeDigitNumber(String numObj) {
        if (numObj.charAt(1) == '0') {
            if (numObj.charAt(2) == '0') {
                return read(numObj.charAt(0)) + " trăm";
            } else {
                return read(numObj.charAt(0)) + " trăm linh " + read(numObj.charAt(2));
            }
        } else {
            return read(numObj.charAt(0)) + " trăm " + readTwoDigitNumber(numObj.substring(1));
        }
    }

    public static void readAnother() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Read another number? Y/N?");
        char response = sc.next().charAt(0);
        switch (response) {
            case 'y':
                displayResult(readTheNumber());
                readAnother();
                break;
            case 'n':
                return;
            default:
                readAnother();
        }
    }
}
