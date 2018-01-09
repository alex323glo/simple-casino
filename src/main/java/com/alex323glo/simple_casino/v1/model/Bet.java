package com.alex323glo.simple_casino.v1.model;

/**
 * Game bet model.
 *
 * @author alex323glo
 * @version 0.1.0
 */
public class Bet {

    private double amount;

    /**
     * Empty constructor.
     */
    public Bet() {
    }

    /**
     * Simple constructor (assigns amount field).
     *
     * @param amount initial field value.
     */
    public Bet(double amount) {
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

        Bet bet = (Bet) o;

        return Double.compare(bet.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(amount);
        return (int) (temp ^ (temp >>> 32));
    }
}
