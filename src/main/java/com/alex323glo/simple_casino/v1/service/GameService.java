package com.alex323glo.simple_casino.v1.service;

import com.alex323glo.simple_casino.v1.exception.ServiceException;
import com.alex323glo.simple_casino.v1.model.response.BalanceResponse;
import com.alex323glo.simple_casino.v1.model.response.BetResponse;

/**
 * Game microservice. Is a part of Simple Casino API.
 *
 * @author alex323glo
 * @version 0.1.0
 */
public interface GameService {

    /**
     * Places new bet to concrete game using concrete player wallet.
     *
     * @param playerId unique identifier of existing player wallet.
     * @param gameId unique identifier of existing game.
     * @param amount needed amount, which will be placed as bet (will be withdrawn
     *               from player wallet).
     * @return BalanceResponse with "OK" status and updated (not null) wallet balance value, if
     * bet positioning was successful, or BalanceResponse with "KO" status,
     * if it was unsuccessful (player id not found, or game id not found).
     * @throws ServiceException when passed arguments (playerId, gameId, amount) don't pass validation, or
     * service has some problems with execution of this business logic.
     *
     * @see BalanceResponse
     * @see ServiceException
     */
    BalanceResponse placeBet(String playerId, String gameId, Double amount) throws ServiceException;

    /**
     * Shows all bets of concrete player.
     *
     * @param playerId unique identifier of existing player wallet.
     * @return BetResponse with "OK" status and List of placed bets, if
     * show operation was successful, or BetResponse with "KO" status,
     * if it was unsuccessful (player id not found).
     * @throws ServiceException when passed arguments (playerId) don't pass validation, or
     * service has some problems with execution of this business logic.
     *
     * @see BetResponse
     * @see ServiceException
     */
    BetResponse showBets(String playerId) throws ServiceException;

}
