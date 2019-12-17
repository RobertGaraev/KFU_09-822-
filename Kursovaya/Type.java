package Kursovaya;

public class Type {
    private String first_column, sixth_column;
    private double second_column, third_column, fourth_column, fifth_column;

    public Type(String first_column, double second_column, double third_column, double fourth_column, double fifth_column, String sixth_column) {
        this.first_column = first_column;
        this.second_column = second_column;
        this.third_column = third_column;
        this.fourth_column = fourth_column;
        this.fifth_column = fifth_column;
        this.sixth_column=sixth_column;
    }

    public String getFirst_column() {
        return first_column;
    }

    public void setFirst_column(String first_column) {
        this.first_column = first_column;
    }

    public double getSecond_column() {
        return second_column;
    }

    public void setSecond_column(double second_column) {
        this.second_column = second_column;
    }

    public double getThird_column() {
        return third_column;
    }

    public void setThird_column(double third_column) {
        this.third_column = third_column;
    }

    public double getFourth_column() {
        return fourth_column;
    }

    public void setFourth_column(double fourth_column) {
        this.fourth_column = fourth_column;
    }

    public double getFifth_column() {
        return fifth_column;
    }

    public void setFifth_column(double fifth_column) {
        this.fifth_column = fifth_column;
    }

    public String getSixth_column() {
        return sixth_column;
    }

    public void setSixth_column(String sixth_column) {
        this.sixth_column = sixth_column;
    }


}
