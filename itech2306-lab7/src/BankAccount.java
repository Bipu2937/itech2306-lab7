public class BankAccount {
    private double balance;
    private String owner;
    public boolean transfer(BankAccount fromAccount, double amount) {
        if (fromAccount == this || amount <= 0) {
            return false;
        }

        if (fromAccount.withdraw(amount)) {
            return this.deposit(amount);
        }

        return false;
    }

    public BankAccount(double balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }
}
