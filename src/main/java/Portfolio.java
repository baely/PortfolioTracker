import java.util.ArrayList;

public class Portfolio {
    private final ArrayList<Account> accounts;

    public Portfolio() {
        this.accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
