package com.alex323glo.simple_casino.v1.model;

/**
 * Game bet model.
 *
 * @author alex323glo
 * @version 0.1.0
 */
public class Bet {

    private double amount;
    private String playerId;
    private String gameId;

    /**
     * Empty constructor.
     */
    public Bet() {
    }

    /**
     * Extended constructor (assigns amount, playerId and gameId fields).
     *
     * @param amount initial field value.
     * @param playerId initial field value.
     * @param gameId initial field value.
     */
    public Bet(double amount, String playerId, String gameId) {
        this.amount = amount;
        this.playerId = playerId;
        this.gameId = gameId;
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

    /**
     * Getter (playerId field).
     *
     * @return field value.
     */
    public String getPlayerId() {
        return playerId;
    }

    /**
     * Setter (playerId field).
     *
     * @param playerId new field value.
     */
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    /**
     * Getter (gameId field).
     *
     * @return field value.
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * Setter (gameId field).
     *
     * @param gameId new field value.
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bet bet = (Bet) o;

        if (Double.compare(bet.amount, amount) != 0) return false;
        if (playerId != null ? !playerId.equals(bet.playerId) : bet.playerId != null) return false;
        return gameId != null ? gameId.equals(bet.gameId) : bet.gameId == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (playerId != null ? playerId.hashCode() : 0);
        result = 31 * result + (gameId != null ? gameId.hashCode() : 0);
        return result;
    }

    // TODO could be updated
    @Override
    public String toString() {
        return "Bet{" +
                "amount=" + amount +
                '}';
    }
}
