package com.alex323glo.simple_casino.v1.service;

import com.alex323glo.simple_casino.v1.dao.DAO;
import com.alex323glo.simple_casino.v1.exception.DataValidationException;
import com.alex323glo.simple_casino.v1.exception.ServiceException;
import com.alex323glo.simple_casino.v1.model.Bet;
import com.alex323glo.simple_casino.v1.model.Game;
import com.alex323glo.simple_casino.v1.model.response.BalanceResponse;
import com.alex323glo.simple_casino.v1.model.response.BetResponse;
import com.alex323glo.simple_casino.v1.model.response.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

import static com.alex323glo.simple_casino.v1.util.Validator.*;

/**
 * Game microservice interface implementation.
 *
 * @author alex323glo
 * @version 0.1.0
 *
 * @see GameService
 */
public class GameServiceImpl implements GameService {

    private WalletService walletService;
    private DAO<String, Game> gameDAO;
    private DAO<String, Bet> betDAO;

    /**
     * Extended constructor (assigns walletService and gameDAO fields).
     *
     * @param walletService initial field value.
     * @param gameDAO initial field value.
     * @param betDAO initial field value.
     *
     * @see WalletService
     * @see DAO
     * @see Game
     * @see Bet
     */
    public GameServiceImpl(WalletService walletService, DAO<String, Game> gameDAO, DAO<String, Bet> betDAO) {
        if (walletService == null || gameDAO == null || betDAO == null) {
            throw new NullPointerException("walletService, gameDAO, or betDAO is null");
        }

        this.walletService = walletService;
        this.gameDAO = gameDAO;
        this.betDAO = betDAO;
    }

    /**
     * Getter (walletService field).
     *
     * @return field value.
     *
     * @see WalletService
     */
    public WalletService getWalletService() {
        return walletService;
    }

    /**
     * Setter (walletService field).
     *
     * @param walletService new field value.
     *
     * @see WalletService
     */
    public void setWalletService(WalletService walletService) {
        this.walletService = walletService;
    }

    /**
     * Getter (gameDAO field).
     *
     * @return field value.
     *
     * @see DAO
     * @see Game
     */
    public DAO<String, Game> getGameDAO() {
        return gameDAO;
    }

    /**
     * Setter (gameDAO field).
     *
     * @param gameDAO new field value.
     *
     * @see DAO
     * @see Game
     */
    public void setGameDAO(DAO<String, Game> gameDAO) {
        this.gameDAO = gameDAO;
    }

    /**
     * Getter (betDAO field).
     *
     * @return field value.
     *
     * @see DAO
     * @see Bet
     */
    public DAO<String, Bet> getBetDAO() {
        return betDAO;
    }

    /**
     * Setter (betDAO field).
     *
     * @param betDAO new field value.
     *
     * @see DAO
     * @see Bet
     */
    public void setBetDAO(DAO<String, Bet> betDAO) {
        this.betDAO = betDAO;
    }

    /**
     * Places new bet to concrete game using concrete player wallet.
     *
     * @param playerId unique identifier of existing player wallet.
     * @param gameId   unique identifier of existing game.
     * @param amount   needed amount, which will be placed as bet (will be withdrawn
     *                 from player wallet).
     * @return BalanceResponse with "OK" status and updated (not null) wallet balance value, if
     * bet positioning was successful, or BalanceResponse with "KO" and current wallet balance value, if
     * amount is insufficient for current wallet balance, or BalanceResponse with "KO" status,
     * if it was unsuccessful for another reasons (player id not found, or game id not found).
     * @throws ServiceException when passed arguments (playerId, gameId, amount) don't pass validation, or
     *                          service has some problems with execution of this business logic.
     * @see BalanceResponse
     * @see ServiceException
     */
    @Override
    public BalanceResponse placeBet(String playerId, String gameId, Double amount) throws ServiceException {
        try {
            validateId(playerId);
            validateId(gameId);
            validateAmount(amount);
        } catch (DataValidationException e) {
            e.printStackTrace();    // TODO could be replaced with logger
            throw new ServiceException("params didn't pass validation", e);
        }

        // TODO logic could be changed using commented code below
//        BalanceResponse walletServiceResponse = walletService.balance(playerId);
//        if (walletServiceResponse.getStatus().equals(ResponseStatus.KO)) {
//            return walletServiceResponse;
//        }

        Game game = gameDAO.read(gameId);
        if (game == null) {
            return new BalanceResponse(ResponseStatus.KO);
        }

        return walletService.withdraw(playerId, amount);
    }

    /**
     * Shows all bets of concrete player.
     *
     * @param playerId unique identifier of existing player wallet.
     * @return BetResponse with "OK" status and List of placed bets (if such doesn't have any
     * bet at the moment, the List will be not Null and empty), if show operation was successful,
     * or BetResponse with "KO" status, if it was unsuccessful (player id not found).
     * @throws ServiceException when passed arguments (playerId) don't pass validation, or
     *                          service has some problems with execution of this business logic.
     * @see BetResponse
     * @see ServiceException
     */
    @Override
    public BetResponse showBets(String playerId) throws ServiceException {
        try {
            validateId(playerId);
        } catch (DataValidationException e) {
            e.printStackTrace();    // TODO could be replaced with logger
        }

        if (walletService.balance(playerId).getStatus().equals(ResponseStatus.KO)) {
            return new BetResponse(ResponseStatus.KO);
        }

        List<Bet> resultBetList = betDAO.getValues().stream()
                .filter(bet -> bet.getPlayerId().equals(playerId))
                .collect(Collectors.toList());

        return new BetResponse(ResponseStatus.OK, resultBetList);
    }
}
