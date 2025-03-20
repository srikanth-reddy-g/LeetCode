class Bank {

    long accountBalance[];
    long n;

    public Bank(long[] balance) {
        accountBalance = new long[balance.length];
        accountBalance = balance;
        n = accountBalance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        account1 -= 1;
        account2 -= 1;
        if (account1 >= 0 && account1 < n && account2 >= 0 && account2 < n && money >= 0
                && accountBalance[account1] >= money) {
            accountBalance[account1] -= money;
            accountBalance[account2] += money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        account -= 1;
        if (account >= 0 && account < n) {
            accountBalance[account] += money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        account -= 1;
        if (account >= 0 && account < n && money >= 0 && accountBalance[account] >= money) {
            accountBalance[account] -= money;
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */