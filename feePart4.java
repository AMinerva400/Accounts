privileged aspect feePart4{
	private double account.minimum = 500.0;
	private double account.fee = 3.99;
	//Override Constructor
	void around(account A, double b, String o) : (execution(account.new(..))) && target(A) && args(b, o) {
		if(b < A.minimum) {
			b -= A.fee;
		}
		proceed(A,b,o);
	}
	//Override Withdraw
	void around(account A, double amt) : (call(void account.withdraw(..))) && target(A) && args(amt) {
		if(A.balance - amt < A.minimum){
			amt += A.fee;
		}
		proceed(A,amt);
	}
}