/*        Welcome to BIG BOSS Savings and Loan ....
   
You are the "NERD" in this assignment.  You need to implement at least
4/5 features demanded by the "BOSS", each in a separate aspect (and in
a separate file).  No changes can be made in this file, not even main.
You need to statisfy the requirements as stated by the BOSS.


BOSS: Hey nerd, write me a program to keep track of bank accounts!
*/

public class account
{
    private double balance;
    private String owner; 
    public account(double x, String s) { balance=x; owner=s; }
    public String owner() { return owner; }
    public void withdraw(double a) { balance -= a; }
    public void deposit(double a) { balance += a; }
    public void printbalance() { System.out.println(balance); }

    // main for testing:
  public static void main(String[] argv)
  {
      account a1 = new account(2000,"you boss");
      account a2 = new account(1000,"me nerd");
	  a1.deposit(400);
      a2.withdraw(300000);   // not enough money!
      a2.withdraw(-500000);  // trying to cheat!
      a1.printbalance();
      a2.printbalance();
	  
  }//main
} // account

/*
NERD: It's done sir!

BOSS: You call this a program?!  Is this all that your granola-eating,
      math-loving professors taught you how to do at Hofstra?  You can
      withdraw a greater amount than your current balance!  It's even
      possible to withdraw a negative amount, which will increase the
      balance. Deposit also doesn't check if the amount is negative.
      No wonder we're losing so much money, you useless nerd!  (1)

NERD: I've fixed the problems in the program sir!  

BOSS: How is the user going to interact with your program?  Most
      people need a graphical interface in order to use a computer:
      they're not nerdy geeks like you.  (2)

NERD: That's easy, I'll do a javax.swing interface right away!

BOSS: Your bleeding heart professors probably think that there aren't
      any bad people in the world (kum-ba-ya!)  There's no secret pin 
      or password that needs to be entered before a customer can make
      a transaction.  We don't live on a commune like your hippie
      professors.  (3)

NERD: OK, I'll do that too. 

BOSS: While you were doing that I got another nerd to implement a
      feature to charge a fee when a withdraw lowers the balance below
      a certain minimum.  But he can't get it to work and I fired him.
      Here's the code he was working on.  He left you some choice
      comments.  You need to get it to work, along with everything
      else you're working on, or I'll fire you too.  (4)

class gougingaccount extends account
{
    protected double minimum = 500.0; // minimum to avoid charges
    protected double fee = 3.99; // fee to be charged.
    public gougingaccount(double x, String s) 
    { if (x<minimum) x-=fee; super(x,s); }
    public void withdraw(double amt)  // override super.withdraw
    {  
	if (balance-amt < minimum) amt += fee;
	super.withdraw(amt);
    }	

//   COMMENTS FOR THE MOTHERHACKER WHO WROTE THE ACCOUNT CLASS:
// My code won't compile because you made the balance value PRIVATE!
// But the boss thinks it's my fault.  I hope he makes you fix your
// own mistake without changing any of the code you already wrote.
// That ought to teach you not to make stuff private!

}// gougingaccount class by grudging nerd.
*/


/*
NERD: It would've been nice if you told me all of this up front sir.   
      I could have done things differently then. It's so frustrating to 
      not know what else you're going to ask me to do next.

BOSS: Well tough! I can't think of everything at once.  It's your job
      to do what I ask, and I don't care how you do it.  Didn't you
      learn a bunch of fancy programming languages from your fancy pants
      professors?  Pick one that allows you to add these features
      easily, whithout messing up the rest of your program.

NERD: I think that would require what my professors would call "LOOSE
      COUPLING" and "SEPARATION OF CONCERN."  The problem is that some
      of these features CROSSCUT others.  It may be difficult to WEAVE
      them together.

BOSS: What a bunch of academic mumbo jumbo! I don't care how loose
      your couples are.   Anyway, the customers also want to see a
      transaction record.  Your programs need to keep track of all the
      transactions (withdraws and deposits) made on an account, and
      print out a report when asked for.  (5)

NERD: Not another feature! You're killing me boss!

BOSS: Get back to work nerd!
*/
