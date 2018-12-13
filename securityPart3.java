import javax.swing.*;

privileged aspect securityPart3{
	private String account.password;
	private int account.pwCount = 0;
	//Change PW Function
	private void account.changePW(){
		String p = JOptionPane.showInputDialog(null, "Time to Change Password. Enter Old Password:");
		if(this.password.equals(p)){
			password = JOptionPane.showInputDialog(null, "Enter New Password:");
		}
		else {
			JOptionPane.showMessageDialog(null, "Incorrect Password");
		}
		pwCount = 0;
	}
	//Set Password After Contructor
	after(account A) : execution(account.new(..)) && target(A) {
		A.password = JOptionPane.showInputDialog(null, "Enter A Password For " + A.owner + ":");
	}
	//Require Password for any Function Call
	before(account A) : call(public * account.*(..)) && target(A) {
		if(A.pwCount > 3){
			A.changePW();
		}
		else {
			String p = JOptionPane.showInputDialog(null, "Enter Password For " + A.owner + ":");
			A.pwCount++;
			if(!A.password.equals(p)){
				JOptionPane.showMessageDialog(null, "Incorrect Password");
				return;
			}
		}
	}
}