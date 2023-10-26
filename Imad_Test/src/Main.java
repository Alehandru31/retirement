
import java.time.LocalDateTime;
import java.util.Scanner;

import static java.lang.System.exit;
import static sun.security.util.KeyUtil.validate;

public class Main {
    public static void main(String[] args) {

        //  LocalDateTime dateTime = LocalDateTime.now();



        // 1. declare
        Scanner val = new Scanner(System.in);
        TimeDate timeDate = new TimeDate();
        RetirmentAge retirmentAge = new RetirmentAge();

        System.out.println("Today date - " + timeDate.date);
        System.out.println("Today time - " + timeDate.time);
        System.out.println("Write please Retirement_age in your Country! ");
        retirmentAge.setRetirement_age(val.nextInt());
        System.out.println("Write please your  Birth_month! ");
        retirmentAge.setBirth_month(val.nextInt());
        System.out.println("You write your birth_month - " + retirmentAge.getBirth_month() +
                '\n' + "Write please your year of birth ");
        retirmentAge.setBirth_years(val.nextInt());  //Years in the present
        System.out.println("You write your year of birth - " + retirmentAge.getBirth_years());
        retirmentAge.retirement();

        // 2. Validate
        if (validateRetirement(retirmentAge)== false ) {
            System.out.println("ERROR");
            return;
        }

        // 3.calculate
        calculateRetirement(retirmentAge);


        // 4. printout
        System.out.println(retirmentAge);
    }


    private void calculateRetirement (RetirmentAge retirementAge) {
        public void retirement() {
            retirement_age = retirement_age - (getYear() - birth_years);
            System.out.println('\n' + "Years for retirement - " + retirement_age);
            int month = 12 - getMonth() + birth_month;
            System.out.println("Month for retirement  - " + month);
        }
    }

    private boolean validateRetirement(RetirmentAge input) {
        if (retirementAge >= 60 && retirementAge <= 67) {
            this.retirement_age = retirementAge;
        } else if (birth_month > 0 && birth_month <= 12) {
            this.birth_month = birth_month;
        } else if (birth_years > 0 && birth_years <= getYear()) {
            this.birth_years = birth_years;
        } else {
            this.birth_month = -1;
            System.out.println("You don't write correct birth_month or year of birth: " + '\n' + "Please write agan:");
        }
        return false;
    }
}
