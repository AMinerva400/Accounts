privileged aspect invariancePart1{
	//Check Withdraw
	before(account A, double b) : (call(void account.withdraw(..))) && target(A) && args(b){
		if(b < 0 || b > A.balance){
			System.out.println("Bad Input: " + b);
			System.exit(1);
		}
	}
	//Check Deposit
	before(double b) : (call(void account.deposit(..))) && args(b){
		if(b < 0){
			System.out.println("Bad Input: " + b);
			System.exit(1);
		}
	}
	
	void around() : (execution(void *.main(..))){
		account a1 = new account(400, "Account1");
		account a2 = new account(1000, "Account2");
		a1.withdraw(100);
		a2.withdraw(300);
		a2.deposit(1000);
		a2.deposit(50);
		a1.printbalance();
		a2.printbalance();
		a1.printRecord();
		a2.printRecord();
		
	}
}