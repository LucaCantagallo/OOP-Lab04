package it.unibo.oop.lab04.bank2;

public class ClassicBankAccount extends AbstractBankAccount {
    
    public ClassicBankAccount(final int usrID, final double balance) {
        super(usrID, balance);
    }
    
    protected boolean isWithDrawAllowed(final double amount) {
        return true;
    }
    
    protected double computeFees() {
    	return MANAGEMENT_FEE;
    	    }

}
