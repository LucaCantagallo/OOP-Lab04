package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;

public abstract class AbstractBankAccount implements BankAccount {
	
	public static final double ATM_TRANSACTION_FEE = 1;
    public static final double MANAGEMENT_FEE = 5;

    private final int usrID;
    private double balance;
    private int nTransactions;
    
    public AbstractBankAccount(int usrID, double balance) {
        this.usrID = usrID;
        this.balance = balance;
        this.nTransactions = 0;
    }
    
    protected boolean checkUser(final int id) {
        return this.usrID == id;
    }
    
    public final void computeManagementFees(final int usrID) {
        final double feeAmount = computeFees();
        if (checkUser(usrID) && isWithDrawAllowed(feeAmount)) {
            balance -= feeAmount;
            resetTransactions();
        }
    }

    public void deposit(final int usrID, final double amount) {
        this.transactionOp(usrID, amount);
    }
    
    private void transactionOp(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
            this.incTransactions();
        }
    }
    
    protected void incTransactions() {
        this.nTransactions++;
    }

    public void depositFromATM(final int usrID, final double amount) {
        this.deposit(usrID, amount - AbstractBankAccount.ATM_TRANSACTION_FEE);
    }

    public double getBalance() {
        return this.balance;
    }
    
    protected void setBalance(final double amount) {
        this.balance = amount;
    }

    public int getNTransactions() {
        return this.nTransactions;
    }
    
    protected void resetTransactions() {
        this.nTransactions = 0;
    }

    public void withdraw(final int usrID, final double amount) {
        this.transactionOp(usrID, -amount);
    }

    public void withdrawFromATM(final int usrID, final double amount) {
        this.withdraw(usrID, amount + AbstractBankAccount.ATM_TRANSACTION_FEE);
    }
    
    protected abstract boolean isWithDrawAllowed(final double amount);
    
    protected abstract double computeFees();

}
