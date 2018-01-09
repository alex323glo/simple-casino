package com.alex323glo.simple_casino.v1.model.response;

import com.alex323glo.simple_casino.v1.model.Bet;

import java.util.List;

/**
 * Service response model, which contains response status
 * and bets properties.
 *
 * @author alex323glo
 * @version 0.1.0
 *
 * @see Response
 */
public class BetResponse extends Response {

    private List<Bet> bets;

    /**
     * Empty constructor.
     */
    public BetResponse() {
    }

    /**
     * Simple constructor (assigns status field).
     *
     * @param status initial field value.
     *
     * @see ResponseStatus
     */
    public BetResponse(ResponseStatus status) {
        this.status = status;
    }

    /**
     * Extended constructor (assigns status and bets fields).
     *
     * @param status initial field value.
     * @param bets initial field value.
     *
     * @see ResponseStatus
     * @see Bet
     * @see List
     */
    public BetResponse(ResponseStatus status, List<Bet> bets) {
        this.status = status;
        this.bets = bets;
    }

    /**
     * Getter (bets field).
     *
     * @return field value.
     *
     * @see Bet
     * @see List
     */
    public List<Bet> getBets() {
        return bets;
    }

    /**
     * Setter (bets field).
     *
     * @param bets initial field value.
     *
     * @see Bet
     * @see List
     */
    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    @Override
    public String toString() {
        return "BetResponse{" +
                "status=" + status +
                ", bets=" + bets +
                '}';
    }
}
