package com.alex323glo.simple_casino.v1.service;

import com.alex323glo.simple_casino.v1.dao.DAO;
import com.alex323glo.simple_casino.v1.exception.ServiceException;
import com.alex323glo.simple_casino.v1.model.Player;
import com.alex323glo.simple_casino.v1.model.response.BalanceResponse;

/**
 * TODO finish doc.
 *
 * @author alex323glo
 * @version 0.1.0
 *
 * @see WalletService
 */
public class WalletServiceImpl implements WalletService {

    private DAO<String, Player> playerDAO;

    /**
     * Registers new player wallet in wallet service.
     *
     * @param playerId unique identifier of new player wallet.
     * @return BalanceResponse with "OK" status and zero-valued (not null) balance value, if
     * registration was successful, or BalanceResponse with "KO" status and
     * empty (null) balance value, if it was unsuccessful (player with such id was
     * already registered).
     * @throws ServiceException when passed arguments (playerId) don't pass validation, or
     *                          service has some problems with execution of this business logic.
     * @see BalanceResponse
     * @see ServiceException
     */
    @Override
    public BalanceResponse register(String playerId) throws ServiceException {
        // TODO complete implementation
        return null;
    }

    /**
     * Deposits needed amount to player wallet balance.
     *
     * @param playerId unique identifier of existing player wallet.
     * @param amount   needed amount, which will be deposed to player wallet.
     * @return BalanceResponse with "OK" status and updated (not null) balance value, if
     * deposition was successful, or BalanceResponse with "KO" status and
     * old (not null) balance value, if it was unsuccessful (player id not found).
     * @throws ServiceException when passed arguments (playerId, amount) don't pass validation, or
     *                          service has some problems with execution of this business logic.
     * @see BalanceResponse
     * @see ServiceException
     */
    @Override
    public BalanceResponse deposit(String playerId, Double amount) throws ServiceException {
        // TODO complete implementation
        return null;
    }

    /**
     * Processes withdraw operation with player wallet.
     *
     * @param playerId unique identifier of existing player wallet.
     * @param amount   needed amount, which will be withdrawn from player wallet.
     * @return BalanceResponse with "OK" status and updated (not null) balance value, if
     * withdraw operation was successful, or BalanceResponse with "KO" status and
     * old (not null) balance value, if it was unsuccessful (player id not found or
     * insufficient funds).
     * @throws ServiceException when passed arguments (playerId, amount) don't pass validation, or
     *                          service has some problems with execution of this business logic.
     * @see BalanceResponse
     * @see ServiceException
     */
    @Override
    public BalanceResponse withdraw(String playerId, Double amount) throws ServiceException {
        // TODO complete implementation
        return null;
    }

    /**
     * Shows player wallet's balance.
     *
     * @param playerId unique identifier of existing player wallet.
     * @return BalanceResponse with "OK" status and updated (not null) balance value, if
     * balance operation was successful, or BalanceResponse with "KO" status and
     * empty (null) balance value, if it was unsuccessful (player id not found).
     * @throws ServiceException when passed arguments (playerId) don't pass validation, or
     *                          service has some problems with execution of this business logic.
     * @see BalanceResponse
     * @see ServiceException
     */
    @Override
    public BalanceResponse balance(String playerId) throws ServiceException {
        // TODO complete implementation
        return null;
    }
}
