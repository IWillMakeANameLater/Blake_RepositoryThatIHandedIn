import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class Tests {

    Customer testCustomer;

    @Before
    public void setup(){
        testCustomer = new Customer();
    }

    @Test
    public void testWithdraw(){

        // withdraw
        assertEquals( -50f, testCustomer.withdraw( 50, new Date(), testCustomer.SAVING) , 0.1 ); // new balance : -50
        assertEquals(  -25f, testCustomer.withdraw( 25, new Date(), testCustomer.CHECKING) , 0.1 ); // new balance : -25

        // these should have no change on the balance
        assertEquals( -50f, testCustomer.withdraw( 0, new Date(), testCustomer.SAVING) , 0.1 ); // balance : -50
        assertEquals( -25f, testCustomer.withdraw( -25, new Date(), testCustomer.CHECKING), 0.1 ); // balance : -25

        // this should be rejected due to overdraft
        assertEquals(  -1, testCustomer.withdraw( 999, new Date(), testCustomer.CHECKING) , 0 ); // no balance change; should return -1
    }

    @Test
    public void testDeposit(){

        // deposit
        assertEquals( 50f, testCustomer.deposit(50, new Date(), testCustomer.SAVING) , 0.1); // New balance : 50
        assertEquals( 25f, testCustomer.deposit(25, new Date(), testCustomer.CHECKING) , 0.1); // New balance : 25

        // these should not have an impact on the balance of the account
        assertEquals( 50f, testCustomer.deposit(0, new Date(), testCustomer.SAVING) , 0.1); // balance : 50
        assertEquals( 25f, testCustomer.deposit(-25, new Date(), testCustomer.CHECKING) , 0.1); // balance : 25
    }

    @Test
    public void testDepositToString(){

        // create deposit
        Date currentTime = new Date();
        Deposit testDeposit = new Deposit(500.0, currentTime, testCustomer.SAVING);
        Deposit testDeposit2 = new Deposit(200.0, currentTime, testCustomer.CHECKING);

        // check deposit to string
        assertEquals("Deposit of: $500.0 Date: " + currentTime.toString() + " into account: Saving", testDeposit.toString()); // String should be "Deposit of: $500.0 Date: [ Date ] into account: Saving"
        assertEquals("Deposit of: $200.0 Date: " + currentTime.toString() + " into account: Checking", testDeposit2.toString()); // String should be "Deposit of: $200.0 Date: [ Date ] into account: Checking"

    }

    @Test
    public void testWithdrawToString(){

        // create deposit
        Date currentTime = new Date();
        Withdraw testWithdraw = new Withdraw(300.0, currentTime, testCustomer.SAVING);
        Withdraw testWithdraw2 = new Withdraw(100.0, currentTime, testCustomer.CHECKING);

        // check deposit to string
        assertEquals("Withdraw of: $300.0 Date: " + currentTime.toString() + " into account: Saving", testWithdraw.toString()); // String should be "Withdraw of: $300.0 Date: [ Date ] into account: Saving"
        assertEquals("Withdraw of: $100.0 Date: " + currentTime.toString() + " into account: Checking", testWithdraw2.toString()); // String should be "Withdraw of: $100.0 Date: [ Date ] into account: Checking"

    }
}
