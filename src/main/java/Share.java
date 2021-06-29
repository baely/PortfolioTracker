public class Share {
    private final Exchange exchange;
    private final String label;

    private Money currentPrice;

    public Share(Exchange exchange, String label) {
        this.exchange = exchange;
        this.label = label;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public String getLabel() {
        return label;
    }

    public Money getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Money currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Money getPrice() {
        return exchange.getSharePrice(this);
    }
}