package com.alex323glo.simple_casino.v1;

import com.alex323glo.simple_casino.v1.model.response.BalanceResponse;
import com.alex323glo.simple_casino.v1.model.response.Response;
import com.alex323glo.simple_casino.v1.service.GameService;
import com.alex323glo.simple_casino.v1.service.WalletService;

/**
 * Functional test by business scenario.
 *
 * @author alex323glo
 * @version 0.1.0
 */
public class ScenarioFunctionalTest {

    private static final String TEST_PLAYER_ID = "123";
    private static final String TEST_GAME_ID = "456";

    public static void main(String[] args) {
        WalletService walletService = createWalletService();
        GameService gameService = createGameService();

        printServiceResponse("register(" + TEST_PLAYER_ID + ")",
                walletService.register(TEST_PLAYER_ID));
        // will print: "service response: BalanceResponse{status=OK, balance=Balance{amount=0}}"

        printServiceResponse("deposit(" + TEST_PLAYER_ID + ", 100)",
                walletService.deposit(TEST_PLAYER_ID, 100d));
        // will print: "service response: BalanceResponse{status=OK, balance=Balance{amount=100}}"

        printServiceResponse("placeBet(" + TEST_PLAYER_ID + ", " + TEST_GAME_ID + ", 70)",
                gameService.placeBet(TEST_PLAYER_ID, TEST_GAME_ID, 70d));
        // will print: "service response: BalanceResponse{status=OK, balance=Balance{amount=30}}"

        printServiceResponse("placeBet(" + TEST_PLAYER_ID + ", " + TEST_GAME_ID + ", 50)",
                gameService.placeBet(TEST_PLAYER_ID, TEST_GAME_ID, 50d));
        // will print: "service response: BalanceResponse{status=OK, balance=Balance{amount=30}}"

        printServiceResponse("showBets(" + TEST_PLAYER_ID + ")",
                gameService.showBets(TEST_PLAYER_ID));
        // will print: "service response: BetResponse{status=OK, bets={Bet{amount=70}}}"

        printServiceResponse("balance(" + TEST_PLAYER_ID + ")",
                walletService.balance(TEST_PLAYER_ID));
        // will print: "service response: BalanceResponse{status=OK, balance=Balance{amount=30}}"
    }

    /**
     * Create new configured exemplar of GameService.
     *
     * @return new instance of GameService
     *
     * @see GameService
     */
    private static GameService createGameService() {
        // TODO use GameService implementation for setUp
        return null;
    }

    /**
     * Create new configured exemplar of WalletService.
     *
     * @return new instance of WalletService
     *
     * @see WalletService
     */
    private static WalletService createWalletService() {
        // TODO use GameService implementation for setUp
        return null;
    }

    /**
     * Prints Simple Casino service response.
     *
     * @param response Response object, needed to print.
     *
     * @see Response
     */
    private static void printServiceResponse(String actionInfo, Response response) {
        System.out.printf("# action: %s\n", actionInfo);
        System.out.printf("* service response: %s\n", response);
    }

}
