package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccount extends AbstractBankAccount{

    private static final double TRANSACTION_FEE = 0.1;

	public RestrictedBankAccount(final int usrID, final double balance) {
        super(usrID, balance);
    }
    
    protected boolean isWithDrawAllowed(final double amount) {
        return getBalance() > amount;
    }

    protected double computeFees() {
    	return MANAGEMENT_FEE + (getNTransactions() * RestrictedBankAccount.TRANSACTION_FEE);
    }

}
