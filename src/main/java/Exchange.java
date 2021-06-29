import java.util.ArrayList;

public class Exchange {
    private final Currency defaultCurrency;
    private final ArrayList<Share> shares;

    public Exchange(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
        this.shares = new ArrayList<>();
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    public ArrayList<Share> getEntities() {
        return shares;
    }

    public Money getSharePrice(Share share) {
        return share.getCurrentPrice();
    }
}
