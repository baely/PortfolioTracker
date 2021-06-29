import java.util.ArrayList;

public class Holding {
    private final Share share;
    private final ArrayList<Transaction> transactions;

    public Holding(Share share) {
        this.share = share;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public int totalQuantity() {
        int quantity = 0;

        for (Transaction transaction : transactions) {
            quantity += transaction.getQuantity();
        }

        return quantity;
    }

    public Money totalValue() {
        return share.getPrice().mul(totalQuantity());
    }

    public Money totalCost() {
        Money cost = new Money(share.getExchange().getDefaultCurrency(), 0);

        for (Transaction transaction : transactions) {
            cost = cost.add(transaction.getAmount());
        }

        return cost;
    }
}
