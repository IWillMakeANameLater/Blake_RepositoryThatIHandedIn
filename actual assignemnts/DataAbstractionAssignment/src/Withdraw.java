import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    /**
     *
     * @return Returns information about the deposit in the form of a string
     * In the format of " Withdraw of: [ amount ] Date: [ Date ] into account: [ account ] "
     */
    public String toString(){
        return "Withdraw of: $" + this.amount + " Date: " + this.date + " into account: " + this.account;
    }
}
