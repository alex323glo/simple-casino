package com.alex323glo.simple_casino.v1.service;

import com.alex323glo.simple_casino.v1.exception.ServiceException;
import com.alex323glo.simple_casino.v1.model.Bet;
import com.alex323glo.simple_casino.v1.model.response.BalanceResponse;
import com.alex323glo.simple_casino.v1.model.response.BetResponse;
import com.alex323glo.simple_casino.v1.model.response.ResponseStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

// TODO finish test and replace @Ignore
@Ignore
public class GameServiceTest {

    private GameService gameService;

    private static final String EXISTING_PLAYER_ID = "existing_player_id";
    private static final String NONEXISTENT_PLAYER_ID = "nonexistent_player_id";

    private static final String EXISTING_GAME_ID = "existing_game_id";
    private static final String NONEXISTENT_GAME_ID = "nonexistent_game_id";

    private static final Double VALID_BET_AMOUNT = 70d;
    private static final Double INVALID_BET_AMOUNT = -70d;

    private static final Double DEFAULT_WALLET_BALANCE = 100d;

    @Before
    public void setUp() throws Exception {
        // TODO use GameService implementation for setUp
    }

    @After
    public void tearDown() throws Exception {
        // TODO use GameService implementation for tearDown
    }

    @Test
    public void placeBetWithOK() throws Exception {
        BalanceResponse response = gameService.placeBet(EXISTING_PLAYER_ID, EXISTING_GAME_ID, VALID_BET_AMOUNT);
        assertEquals(ResponseStatus.OK, response.getStatus());
        assertEquals(DEFAULT_WALLET_BALANCE - VALID_BET_AMOUNT,
                response.getBalance().getAmount(),
                0d);
    }

    @Test
    public void placeBetWithKOOnWrongPlayerId() throws Exception {
        BalanceResponse response = gameService.placeBet(NONEXISTENT_PLAYER_ID, EXISTING_GAME_ID, VALID_BET_AMOUNT);
        assertEquals(ResponseStatus.KO, response.getStatus());
    }

    @Test
    public void placeBetWithKOOnWrongGameId() throws Exception {
        BalanceResponse response = gameService.placeBet(EXISTING_PLAYER_ID, NONEXISTENT_GAME_ID, VALID_BET_AMOUNT);
        assertEquals(ResponseStatus.KO, response.getStatus());
    }

    @Test
    public void placeBetWithKOOnWrongAmount() throws Exception {
        BalanceResponse response = gameService.placeBet(NONEXISTENT_PLAYER_ID, EXISTING_GAME_ID, INVALID_BET_AMOUNT);
        assertEquals(ResponseStatus.KO, response.getStatus());
    }

    @Test
    public void placeBetWithKOOnInsufficientAmount() throws Exception {
        BalanceResponse response = gameService.placeBet(NONEXISTENT_PLAYER_ID, EXISTING_GAME_ID,
                DEFAULT_WALLET_BALANCE + 1d);
        assertEquals(ResponseStatus.KO, response.getStatus());
        assertEquals(DEFAULT_WALLET_BALANCE, response.getBalance().getAmount(), 0d);
    }

    @Test(expected = ServiceException.class)
    public void placeBetWithExceptionOnPlayerId() throws Exception {
        gameService.placeBet(null, EXISTING_GAME_ID, VALID_BET_AMOUNT);
    }

    @Test(expected = ServiceException.class)
    public void placeBetWithExceptionOnGameId() throws Exception {
        gameService.placeBet(EXISTING_PLAYER_ID, null, VALID_BET_AMOUNT);
    }

    @Test(expected = ServiceException.class)
    public void placeBetWithExceptionOnAmount() throws Exception {
        gameService.placeBet(EXISTING_PLAYER_ID, EXISTING_GAME_ID, null);
    }

    @Test
    public void showBetsWithOKOnEmptyBetList() throws Exception {
        BetResponse response = gameService.showBets(EXISTING_PLAYER_ID);
        assertEquals(ResponseStatus.OK, response.getStatus());
        assertEquals(0, response.getBets().size());
    }

    @Test
    public void showBetsWithOKOnNotEmptyBetList() throws Exception {
        gameService.placeBet(EXISTING_PLAYER_ID, EXISTING_GAME_ID, VALID_BET_AMOUNT);
        BetResponse response = gameService.showBets(EXISTING_PLAYER_ID);
        assertEquals(ResponseStatus.OK, response.getStatus());

        List<Bet> betList = response.getBets();
        assertEquals(1, betList.size());
        assertEquals(VALID_BET_AMOUNT, betList.get(0).getAmount(), 0d);
    }

    @Test
    public void showBetsWithKOOnWrongPlayerId() throws Exception {
        BetResponse response = gameService.showBets(NONEXISTENT_PLAYER_ID);
        assertEquals(ResponseStatus.KO, response.getStatus());
    }

    @Test(expected = ServiceException.class)
    public void showBetsWithExceptionOnPlayerId() throws Exception {
        gameService.showBets(null);
    }

}