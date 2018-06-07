package de.dhbw.java.exercise.classes_01;

public class Account {

    private final int AccountNumber;
    private final String owner;
    private final float limit;

    private float balance;


    public static void main(String[] args) {

        Account account = new Account(1234, "Dagobert Duck", 10000, 1_000_000);
        System.out.println(account);
        System.out.println(account.deposit(100_000));
        System.out.println(account.withdraw(150_000));
        System.out.println(account.getBalance());
        System.out.println(account.withdraw(1_000_000));

    }

    public Account(int accountNumber, String owner, float limit, float balance) {
        AccountNumber = accountNumber;
        this.owner = owner;
        this.limit = limit;
        this.balance = balance;
    }

    public Account deposit(float amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Can't deposit Zero or lower");
        }
        this.balance += amount;
        return this;
    }

    public Account withdraw(float amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Can't withdraw zero or lower");
        }

        if (this.balance - amount < -limit) {
            System.out.println("Deckung nicht ausreichend");
            return this;
        }

        this.balance -= amount;
        return this;
    }

    public float getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountNumber=" + AccountNumber +
                ", owner='" + owner + '\'' +
                ", limit=" + limit +
                ", balance=" + balance +
                '}';
    }
}
