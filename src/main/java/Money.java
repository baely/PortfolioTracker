public class Money {
    private final Currency currency;
    private int value;

    public Money(Currency currency) {
        this.currency = currency;
    }

    public Money(Currency currency, int value) {
        this(currency);
        this.value = value;
    }

    public Money(Currency currency, String value) {
        this(currency);

        int newValue;
        int cp = currency.getPrecision();

        String[] valueParts = value.replaceAll("(![\\d.])*", "").split("[.]");

        newValue = Integer.parseInt(valueParts[0]) * (int)Math.pow(10, currency.getPrecision());

        if (valueParts.length > 1) {
            int carry = (valueParts[1].length() > cp && Integer.parseInt(String.valueOf(valueParts[1].charAt(cp))) >= 5) ? 1 : 0;
            newValue += Integer.parseInt(String.format("%1$-" + cp + "s", valueParts[1]).replace(' ', '0').substring(0, cp));
            newValue += carry;
        }

        this.value = newValue;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        String stringValue = String.valueOf(this.value);
        return stringValue.substring(0, stringValue.length()-currency.getPrecision()) + "." + stringValue.substring(stringValue.length()-currency.getPrecision());
    }

    public Money add(int value) {
        return new Money(this.currency, this.value + value);
    }

    public Money add(Money other) throws IllegalArgumentException {
        if (this.currency != other.getCurrency())
            throw new IllegalArgumentException("Unable to add monies of different currencies");
        return this.add(other.getValue());
    }

    public Money mul(int value) {
        return new Money(this.currency, this.value * value);
    }
}
