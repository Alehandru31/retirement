import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 1. declare
        Scanner val = new Scanner(System.in);
        LocalDateTime dateTime = LocalDateTime.now();
        RetirmentAge retirmentAge = new RetirmentAge();

        System.out.println("Today date - " + dateTime.toLocalDate());
        System.out.println("Today time - " + dateTime.toLocalTime());

        System.out.println("Write please Retirement_age in your Country! ");

        //Validate

        while (retirmentAge.getValidate() == 0) {
            if (retirmentAge.getValidateCont() == 0) {
                retirmentAge.setValidateData(val.nextInt());
                boolean validateRetirementOut = validateRetirementAge(retirmentAge.getValidateData());
                if (validateRetirementOut == true) {
                    retirmentAge.setRetirement_age(retirmentAge.getValidateData());
                    System.out.println("Write please your  Birth_month! ");
                    retirmentAge.setValidateCont(retirmentAge.getValidateCont() + 1);
                }
            }
            if (retirmentAge.getValidateCont() == 1) {
                retirmentAge.setValidateData(val.nextInt());
                boolean validateBirthMonthOut = validationBirthMonth(retirmentAge.getValidateData());
                if (validateBirthMonthOut == true) {
                    retirmentAge.setBirth_month(retirmentAge.getValidateData());
                    System.out.println("Write please your year of birth ");
                    retirmentAge.setValidateCont(retirmentAge.getValidateCont() + 1);
                }
            }
            if (retirmentAge.getValidateCont() == 2) {
                int date = dateTime.getYear();
                retirmentAge.setValidateData(val.nextInt());
                boolean validateBirthYarOut = validateBirthYar(retirmentAge.getValidateData(), date);
                if (validateBirthYarOut == true) {
                    retirmentAge.setBirth_years(retirmentAge.getValidateData());
                    retirmentAge.setValidateCont(0);
                    break;
                }
            }
        }

        // 3.calculate
        int[] calculateMas = new int[]{dateTime.getYear(), dateTime.getMonthValue(), retirmentAge.getRetirement_age(), retirmentAge.getBirth_month(), retirmentAge.getBirth_years()};
        int[] calculateMasReturn = calculateRetirement(calculateMas);
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                System.out.println("Years for retirement is: " + calculateMasReturn[i]);
            } else {
                System.out.println("Month for retirement is: " + calculateMasReturn[i]);
            }
        }
    }

    //Methods
    public static boolean validateBirthYar(int validateYar, int dataTime) {
        if (validateYar >= 1920 && validateYar <= dataTime) {
            return true;
        } else {
            System.out.println("You don't write correct Retirement_age or birth Month or Year of birth: " + '\n' + "Please write agan:");
            return false;
        }
    }

    public static boolean validationBirthMonth(int validationMonth) {
        if (validationMonth > 0 && validationMonth <= 12) {
            return true;
        } else {
            System.out.println("You don't write correct Retirement_age or year of birth: " + '\n' + "Please write agan:");
            return false;
        }
    }

    public static boolean validateRetirementAge(int validateRetirement) {
        if (validateRetirement >= 60 && validateRetirement <= 70) {
            return true;
        } else {
            System.out.println("You don't write correct Retirement_age or year of birth: " + '\n' + "Please write agan:");
            return false;
        }
    }

    private static int[] calculateRetirement(int[] calculateMas) {

        int retirement_age = (calculateMas[2] - (calculateMas[0] - calculateMas[4])-1);
        int month = 12 - calculateMas[1] + calculateMas[3];
        int[] result = new int[]{retirement_age, month};
        return result;
    }
}