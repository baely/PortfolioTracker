import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    private final HashMap<Share, Holding> holdings;

    public Account() {
        this.holdings = new HashMap<>();
    }

    public HashMap<Share, Holding> getHoldings() {
        return holdings;
    }

    public Holding getHolding(Share share) {
        if (!holdings.containsKey(share)) {
            holdings.put(share, new Holding(share));
        }

        return holdings.get(share);
    }

    public void addTransaction(Transaction transaction) {
        getHolding(transaction.getShare()).addTransaction(transaction);
    }
}
