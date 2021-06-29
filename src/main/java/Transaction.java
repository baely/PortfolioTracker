public class Transaction {
    private final Money amount;
    private final Share share;
    private final int quantity;

    public Transaction(Money amount, Share share, int quantity) {
        this.amount = amount;
        this.share = share;
        this.quantity = quantity;
    }

    public Money getAmount() {
        return amount;
    }

    public Share getShare() {
        return share;
    }

    public int getQuantity() {
        return quantity;
    }
}
