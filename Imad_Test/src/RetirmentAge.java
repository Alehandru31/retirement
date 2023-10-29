public class RetirmentAge {
    private int retirement_age;
    private int birth_month;
    private int birth_years;
    private int validate = 0;
    private int validateCont;
    private int validateData;

    public void setValidateCont(int validateCont) {
        this.validateCont = validateCont;
    }

    public void setValidateData(int validateData) {
        this.validateData = validateData;
    }

    public int getValidate() {
        return validate;
    }

    public int getValidateCont() {
        return validateCont;
    }

    public int getValidateData() {
        return validateData;
    }


    public int getRetirement_age() {
        return retirement_age;
    }

    public void setRetirement_age(int retirement_age) {
        this.retirement_age = retirement_age;
    }

    public int getBirth_month() {
        return birth_month;
    }

    public void setBirth_month(int birth_month) {
        this.birth_month = birth_month;
    }

    public int getBirth_years() {
        return birth_years;
    }

    public void setBirth_years(int birth_years) {
        this.birth_years = birth_years;
    }
}
