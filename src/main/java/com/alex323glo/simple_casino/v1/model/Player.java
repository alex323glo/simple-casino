package com.alex323glo.simple_casino.v1.model;

/**
 * Player model.
 *
 * @author alex323glo
 * @version 0.1.0
 */
public class Player {

    private String id;
    private Balance balance;

    /**
     * Empty constructor.
     */
    public Player() {
    }

    /**
     * Simple constructor (assigns id field).
     * Also, it assigns balance field with zero-filled
     * (not Null) value.
     *
     * @param id initial field value.
     */
    public Player(String id) {
        this.id = id;
        balance = new Balance();
    }

    /**
     * Extended constructor (assigns id and balance fields).
     *
     * @param id initial field value.
     * @param balance initial field value.
     *
     * @see Balance
     */
    public Player(String id, Balance balance) {
        this.id = id;
        this.balance = balance;
    }

    /**
     * Getter (id field).
     *
     * @return field value.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter (id field).
     *
     * @param id new field value.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter (balance field).
     *
     * @return field value.
     */
    public Balance getBalance() {
        return balance;
    }

    /**
     * Setter (balance field).
     *
     * @param balance new field value.
     */
    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (id != null ? !id.equals(player.id) : player.id != null) return false;
        return balance != null ? balance.equals(player.balance) : player.balance == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                '}';
    }
}
