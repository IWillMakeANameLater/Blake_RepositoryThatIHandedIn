public class ElseAndIf {
    public static void main( String[] args )
    {
        int people = 30;
        int cars = 40;
        int buses = 15;

        if ( cars > people )
        {
            System.out.println( "We should take the cars." );
        }
        else if ( cars < people )
        {
            System.out.println( "We should not take the cars." );
        }
        else
        {
            System.out.println( "We can't decide." );
        }


        if ( buses > cars )
        {
            System.out.println( "That's too many buses." );
        }
        else if ( buses < cars )
        {
            System.out.println( "Maybe we could take the buses." );
        }
        else
        {
            System.out.println( "We still can't decide." );
        }


        if ( people > buses )
        {
            System.out.println( "All right, let's just take the buses." );
        }
        else
        {
            System.out.println( "Fine, let's stay home then." );
        }

        /* Answers
            1) The if and else statements evaluate a boolean expression.
            Based on the boolean the if statement will run different blocks of code.
            If-Else statements are a way to control the flow of your code as it is being run.

            2) Removing an else from an else if statement
            Seperates it from the original if statement.
            Normally, the If statement is "a level higher" than the else-if statement.
            However, by making the else if statement an if statement, they now share the same 'level"
            Which means if both evaluate to true, the original if statement will no longer override
            the else if statement. Both blocks of code can now be run. 
         */
    }
}
