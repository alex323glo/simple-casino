package com.alex323glo.simple_casino.v1.service;

import com.alex323glo.simple_casino.v1.exception.ServiceException;
import com.alex323glo.simple_casino.v1.model.response.BalanceResponse;
import com.alex323glo.simple_casino.v1.model.response.ResponseStatus;
import org.junit.*;

import static org.junit.Assert.*;

// TODO finish test and replace @Ignore
@Ignore
public class WalletServiceTest {

    private WalletService walletService;

    private static final String EXISTING_PLAYER_ID = "existing_id";
    private static final String NONEXISTENT_PLAYER_ID = "nonexistent_id";

    private static final Double VALID_DEPOSIT_AMOUNT = 100d;
    private static final Double INVALID_DEPOSIT_AMOUNT = -100d;

    private static final Double VALID_WITHDRAW_AMOUNT = 70d;
    private static final Double INVALID_WITHDRAW_AMOUNT = -70d;

    @Before
    public void setUp() throws Exception {
        // TODO use WalletService implementation for setUp
    }

    @After
    public void tearDown() throws Exception {
        // TODO use WalletService implementation for tearDown
    }

    @Test
    public void registerWithOK() throws Exception {
        BalanceResponse response = walletService.register(NONEXISTENT_PLAYER_ID);
        assertEquals(ResponseStatus.OK, response.getStatus());
        assertEquals(0d, response.getBalance().getAmount(), 0d);
    }

    @Test
    public void registerWithKO() throws Exception {
        BalanceResponse response = walletService.register(EXISTING_PLAYER_ID);
        assertEquals(ResponseStatus.KO, response.getStatus());
    }


    @Test(expected = ServiceException.class)
    public void registerWithException() throws Exception {
        walletService.register(null);
    }

    @Test
    public void depositWithOK() throws Exception {
        BalanceResponse response = walletService.deposit(EXISTING_PLAYER_ID, VALID_DEPOSIT_AMOUNT);
        assertEquals(ResponseStatus.OK, response.getStatus());
        assertEquals(VALID_DEPOSIT_AMOUNT, response.getBalance().getAmount(), 0d);
    }

    @Test
    public void depositWithKOOnWrongId() throws Exception {
        BalanceResponse response = walletService.deposit(NONEXISTENT_PLAYER_ID, VALID_DEPOSIT_AMOUNT);
        assertEquals(ResponseStatus.KO, response.getStatus());
        assertEquals(0d, response.getBalance().getAmount(), 0d);
    }

    @Test
    public void depositWithKOOnWrongAmount() throws Exception {
        BalanceResponse response = walletService.deposit(EXISTING_PLAYER_ID, INVALID_DEPOSIT_AMOUNT);
        assertEquals(ResponseStatus.KO, response.getStatus());
        assertEquals(0d, response.getBalance().getAmount(), 0d);
    }

    @Test(expected = ServiceException.class)
    public void depositWithExceptionOnId() throws Exception {
        walletService.deposit(null, VALID_DEPOSIT_AMOUNT);
    }

    @Test(expected = ServiceException.class)
    public void depositWithExceptionOnAmount() throws Exception {
        walletService.deposit(EXISTING_PLAYER_ID, null);
    }

    @Test
    public void withdrawWithOK() throws Exception {
        BalanceResponse depositResponse = walletService.deposit(EXISTING_PLAYER_ID, VALID_DEPOSIT_AMOUNT);
        BalanceResponse withdrawResponse = walletService.withdraw(EXISTING_PLAYER_ID, VALID_WITHDRAW_AMOUNT);
        assertEquals(ResponseStatus.OK, withdrawResponse.getStatus());
        assertEquals(VALID_DEPOSIT_AMOUNT - VALID_WITHDRAW_AMOUNT,
                depositResponse.getBalance().getAmount() - withdrawResponse.getBalance().getAmount(),
                0d);
    }

    @Test
    public void withdrawWithKOOnWrongId() throws Exception {
        BalanceResponse response = walletService.withdraw(NONEXISTENT_PLAYER_ID, VALID_WITHDRAW_AMOUNT);
        assertEquals(ResponseStatus.KO, response.getStatus());
    }

    @Test
    public void withdrawWithKOOnWrongAmount() throws Exception {
        walletService.deposit(EXISTING_PLAYER_ID, VALID_DEPOSIT_AMOUNT);
        BalanceResponse withdrawResponse = walletService.withdraw(EXISTING_PLAYER_ID, INVALID_WITHDRAW_AMOUNT);
        assertEquals(ResponseStatus.KO, withdrawResponse.getStatus());
        assertEquals(VALID_DEPOSIT_AMOUNT, withdrawResponse.getBalance().getAmount(), 0d);
    }

    @Test
    public void withdrawWithKOOnInsufficientAmount() throws Exception {
        walletService.deposit(EXISTING_PLAYER_ID, VALID_DEPOSIT_AMOUNT);
        BalanceResponse withdrawResponse = walletService.withdraw(EXISTING_PLAYER_ID, VALID_DEPOSIT_AMOUNT + 1d);
        assertEquals(ResponseStatus.KO, withdrawResponse.getStatus());
        assertEquals(VALID_DEPOSIT_AMOUNT, withdrawResponse.getBalance().getAmount(), 0d);
    }

    @Test(expected = ServiceException.class)
    public void withdrawWithExceptionOnId() throws Exception {
        walletService.withdraw(null, VALID_WITHDRAW_AMOUNT);
    }

    @Test(expected = ServiceException.class)
    public void withdrawWithExceptionOnAmount() throws Exception {
        walletService.withdraw(EXISTING_PLAYER_ID, null);
    }

    @Test
    public void balanceWithOK() throws Exception {
        walletService.deposit(EXISTING_PLAYER_ID, VALID_DEPOSIT_AMOUNT);
        BalanceResponse response = walletService.balance(EXISTING_PLAYER_ID);
        assertEquals(ResponseStatus.OK, response.getStatus());
        assertEquals(VALID_DEPOSIT_AMOUNT, response.getBalance().getAmount(), 0d);
    }

    @Test
    public void balanceWithKO() throws Exception {
        BalanceResponse response = walletService.balance(NONEXISTENT_PLAYER_ID);
        assertEquals(ResponseStatus.KO, response.getStatus());
    }

    @Test(expected = ServiceException.class)
    public void balanceWithException() throws Exception {
        walletService.balance(null);
    }

}