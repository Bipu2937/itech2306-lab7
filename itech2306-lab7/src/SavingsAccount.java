public class SavingsAccount extends BankAccount {
    private double withdrawalFee;
    private double interestRate;

    public SavingsAccount(double balance, String owner, double withdrawalFee, double interestRate) {
        super(balance, owner);
        this.withdrawalFee = withdrawalFee;
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        double total = amount + withdrawalFee;
        if (total <= getBalance()) {
            return super.withdraw(total);
        }
        return false;
    }

    public void applyInterest() {
        double interest = (getBalance() * interestRate) / 365;
        deposit(interest);
    }

    public double getWithdrawalFee() {
        return withdrawalFee;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
