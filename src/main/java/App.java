public class App {
    public static void main(String[] args) {
        Currency AUD = new Currency(2);

        Exchange ASX = new Exchange(AUD);

        Share ASX_ATEC = new Share(ASX, "ATEC");
        Share ASX_FANG = new Share(ASX, "FANG");
        Share ASX_NAB = new Share(ASX, "NAB");
        Share ASX_NDQ = new Share(ASX, "NDQ");
        Share ASX_QAN = new Share(ASX, "QAN");

        ASX_ATEC.setCurrentPrice(new Money(AUD, "23.71"));
        ASX_FANG.setCurrentPrice(new Money(AUD, "18.81"));
        ASX_NAB.setCurrentPrice(new Money(AUD, "26.11"));
        ASX_NDQ.setCurrentPrice(new Money(AUD, "31.74"));
        ASX_QAN.setCurrentPrice(new Money(AUD, "4.55"));

        Portfolio portfolio = new Portfolio();
        Account account = new Account();

        account.addTransaction(new Transaction(new Money(AUD, "2415.01"), ASX_ATEC, 126));
        account.addTransaction(new Transaction(new Money(AUD, "6052.45"), ASX_FANG, 422));
        account.addTransaction(new Transaction(new Money(AUD, "989"), ASX_NAB, 43));
        account.addTransaction(new Transaction(new Money(AUD, "5407.72"), ASX_NDQ, 247));
        account.addTransaction(new Transaction(new Money(AUD, "1847.24"), ASX_QAN, 490));

        for (Share share : account.getHoldings().keySet()) {
            Holding holding = account.getHoldings().get(share);
            System.out.println(share.getLabel() + ", Cost: $" + holding.totalCost() + ", Value: $" + holding.totalValue());
        }
    }
}
