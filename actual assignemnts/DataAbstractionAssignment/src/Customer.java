import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;


    /**
     * Default constructor.
     * Balance for checking and saving will be set to 0.
     * The account number would be set to 1.
     * Deposits and Withdraws would be empty ArrayLists.
     * The name of the account would be "Default"
     */
    public Customer(){
        checkBalance = 0.00;
        savingBalance = 0.00;
        accountNumber = 1;

        deposits = new ArrayList<Deposit>();
        withdraws = new ArrayList<Withdraw>();

        name = "Default";
    }

    /**
     *
     * @param name
     * @param accountNumber
     * @param checkDeposit
     * @param savingDeposit
     *
     * Creates a new customer account with a specified ID and name.
     * As well as a starting amount in their checking account and savings account.
     * Deposits and Withdraws would be empty ArrayLists.
     */
    public Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.accountNumber = accountNumber;

        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;

        deposits = new ArrayList<Deposit>();
        withdraws = new ArrayList<Withdraw>();

        this.name = name;
    }

    /**
     * requires a valid account and date.
     * if amount deposited it less than 0 then it will set it to zero.
     * @param amt
     * @param date
     * @param account
     * @return balance of the account that was deposited into or -1 if the deposit was not successful
     *
     * Adds a deposit to a specified account's balance.
     */
    public double deposit(double amt, Date date, String account){
        if( amt < 0){
            amt = 0;
        }
        this.deposits.add(new Deposit(amt, date, account));
        if (account == CHECKING){
            this.checkBalance += amt;
            return this.checkBalance;
        } else if (account == SAVING){
            this.savingBalance += amt;
            return this.savingBalance;
        }
        return -1;
    }

    /**
     * Requires a valid date and account
     * @param amt to withdraw. if this is less than 0 then it will be set to 0.
     * @param date of withdraw
     * @param account to withdraw from
     * @return balance of the account after withdraw or -1 if the withdraw was rejected/not successful
     *
     * will also check for if the withdraw would cause the account to go over their
     * overdraft limit before doing the withdraw. if it would, then the withdraw request would be rejected.
     */
    public double withdraw(double amt, Date date, String account){
        if( amt < 0){
            amt = 0;
        }

        if (!checkOverdraft(amt, account)){
            this.deposits.add(new Deposit( amt, date, account));
            if (account == CHECKING){
                this.checkBalance -= amt;
                return this.checkBalance;
            } else if (account == SAVING){
                this.savingBalance -= amt;
                return this.savingBalance;
            }
        }

        return -1;
    }

    /**
     *
     * @param amt that would be withdrawn
     * @param account
     * @return if the account would go over their overdraft due to withdrawing of a specified amount
     */
    private boolean checkOverdraft(double amt, String account){
        boolean isOver = false;
        if (account == CHECKING){
            if (this.checkBalance - amt < OVERDRAFT){
                isOver = true;
            }
        } else if (account == SAVING){
            if (this.savingBalance - amt < OVERDRAFT){
                isOver = true;
            }
        }
        return isOver;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
