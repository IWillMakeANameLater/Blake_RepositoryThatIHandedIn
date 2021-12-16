import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    /**
     *
     * @return Returns information about the deposit in the form of a string
     * In the format of " Deposit of: [ amount ] Date: [ Date ] into account: [ account ] "
     */
    public String toString(){
        return "Deposit of: $" + this.amount + " Date: " + this.date + " into account: " + this.account;
    }
}
