
import java.time.LocalDateTime;
import java.time.Month;
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
        int validate = 0, validateCont = 0, validateData;
        while (validate == 0) {
            if (validateCont == 0) {
                validateData = val.nextInt();
                boolean validateRetirementOut = validateRetirementAge(validateData);
                if (validateRetirementOut == true) {
                    retirmentAge.setRetirement_age(validateData);
                    System.out.println("Write please your  Birth_month! ");
                    validateCont++;
                }
            }
            if (validateCont == 1) {
                validateData = val.nextInt();
                boolean validateBirthMonthOut = validationBirthMonth(validateData);
                if (validateBirthMonthOut == true) {
                    retirmentAge.setBirth_month(validateData);
                    System.out.println("Write please your year of birth ");
                    validateCont++;
                }
            }
            if (validateCont == 2) {
                int date = dateTime.getYear();
                validateData = val.nextInt();
                boolean validateBirthYarOut = validateBirthYar(validateData, date);
                if (validateBirthYarOut == true) {
                    retirmentAge.setBirth_years(validateData);
                    validateCont = 0;
                    break;
                }
            }
        }

        // 3.calculate
        int yar = dateTime.getYear();
        int data = dateTime.getMonthValue();
        calculateRetirement(yar, data, retirmentAge.getRetirement_age(), retirmentAge.getBirth_month(), retirmentAge.getBirth_years());
        System.out.println();
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

    private static void calculateRetirement(int yar, int data, int retirement_age, int Birth_month, int Birth_years) {
        retirement_age = retirement_age - (yar - Birth_years);
        System.out.println('\n' + "Years for retirement - " + retirement_age);
        int month = 12 - data + Birth_month;
        System.out.println("Month for retirement  - " + month);
    }
}

