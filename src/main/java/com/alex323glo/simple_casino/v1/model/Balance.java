package com.alex323glo.simple_casino.v1.model;

/**
 * Game Wallet balance model.
 *
 * @author alex323glo
 * @version 0.1.0
 */
public class Balance {

    private double amount;

    /**
     * Empty constructor.
     */
    public Balance() {
    }

    /**
     * Simple constructor (assigns amount field)
     *
     * @param amount initial field value.
     */
    public Balance(double amount) {
        this.amount = amount;
    }

    /**
     * Getter (amount field).
     *
     * @return field value.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter (amount field).
     *
     * @param amount new field value.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Balance balance = (Balance) o;

        return Double.compare(balance.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(amount);
        return (int) (temp ^ (temp >>> 32));
    }
}
