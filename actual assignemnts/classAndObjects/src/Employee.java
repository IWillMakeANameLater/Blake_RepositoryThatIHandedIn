public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee (int id, String firstName, String lastName, int salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getID(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }

    public int getSalary(){
        return this.salary;
    }

    public int getAnnualSalary(){
        return this.salary*12;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int raiseSalary(int percent){
        double salaryIncrease = 1f + (percent/100f);
        this.salary = (int)(this.salary * salaryIncrease);
        return this.salary;
    }

    @Override
    public String toString(){
        return "ID: " + this.id + "\nName: " + this.firstName + " " + this.lastName + " \nSalary: " + this.salary;
    }
}