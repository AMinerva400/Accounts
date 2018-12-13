aspect recordPart5{
	private int account.withdrawCount = 0;
	private int account.depositCount = 0;
	
	after(account A) : call(void account.withdraw(..)) && target(A){
		A.withdrawCount++;
	}
	
	after(account A) : call(void account.deposit(..)) && target(A){
		A.depositCount++;
	}
	
	void account.printRecord(){
		System.out.println(withdrawCount + " Withdrawls - " + depositCount + " Deposits");
	}
}