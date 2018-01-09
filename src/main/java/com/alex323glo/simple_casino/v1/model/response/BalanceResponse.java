package com.alex323glo.simple_casino.v1.model.response;

import com.alex323glo.simple_casino.v1.model.Balance;

/**
 * Service response model, which contains response status
 * and balance properties.
 *
 * @author alex323glo
 * @version 0.1.0
 *
 * @see Response
 * @see Balance
 */
public class BalanceResponse extends Response {

    private Balance balance;

    /**
     * Empty constructor.
     */
    public BalanceResponse() {
    }

    /**
     * Simple constructor (assigns status field).
     *
     * @param status initial field value.
     *
     * @see ResponseStatus
     */
    public BalanceResponse(ResponseStatus status) {
        this.status = status;
    }

    /**
     * Extended constructor (assigns status and balance fields).
     *
     * @param status initial field value.
     * @param balance initial field value.
     *
     * @see ResponseStatus
     * @see Balance
     */
    public BalanceResponse(ResponseStatus status, Balance balance) {
        this.status = status;
        this.balance = balance;
    }

    /**
     * Getter (balance field).
     *
     * @return field value.
     *
     * @see Balance
     */
    public Balance getBalance() {
        return balance;
    }

    /**
     * Setter (balance field).
     *
     * @param balance new field value.
     *
     * @see Balance
     */
    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BalanceResponse{" +
                "status=" + status +
                ", balance=" + balance +
                '}';
    }
}
