package it.unibo.oop.lab04.bank;

public class ExtendedStrictBankAccount extends SimpleBankAccount {
	
	private static final double TRANSACTION_FEE = 0.1;
	
	public ExtendedStrictBankAccount (final int usrID, final double balance) {
		super(usrID, balance);
	}
	
	public void computeManagementFees(final int usrID) {
        final double feeAmount = SimpleBankAccount.MANAGEMENT_FEE + (getNTransactions() * ExtendedStrictBankAccount.TRANSACTION_FEE);
        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
        	setBalance(getBalance() - feeAmount);
            resetTransactions();
        }
    }
	
	private boolean isWithdrawAllowed(final double amount) {
        return getBalance() > amount;
    }
	
	public void withdraw(final int usrID, final double amount) {
        if (isWithdrawAllowed(amount)) {
            this.transactionOp(usrID, -amount); 	//memo dopo aver visto le soluzioni:
        }											//qui si aggiunge solo la condizione:
    }												//fai prima a richiamare la funzione del padre!
	
	private void transactionOp(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            setBalance(getBalance() + amount);
            this.incTransactions();
        }
    }

}
