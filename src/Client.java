import Controllers.GameController;
import Models.*;
import Strategies.WinningStrategies.ColumnWinningStrategy;
import Strategies.WinningStrategies.DiagonalWinningStrategy;
import Strategies.WinningStrategies.RowWinningStrategy;
import Strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Models.GameState.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        GameController gameController = new GameController();
        try {
            int dimension = 3;
            List<Player> playerList = new ArrayList<>();
            playerList.add(new Player(new Symbol('X'),"Sonali",1L, PlayerType.HUMAN));

            playerList.add(new Bot(new Symbol('O'),"GPT",2L,BotDifficultyLevel.EASY));

            List<WinningStrategy> winningStrategies = new ArrayList<>();
            winningStrategies.add(new RowWinningStrategy());
            winningStrategies.add(new ColumnWinningStrategy());
            winningStrategies.add(new DiagonalWinningStrategy());

            Game game = gameController.startGame(dimension, playerList, winningStrategies);

            while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
                gameController.printBoard(game);

                System.out.println("Does anyone want to undo? (y/n) ");
                String undoAns = scn.next();

                if(undoAns.equals("y")){
                    gameController.undo(game);
                    continue;
                }
                gameController.makeMove(game);
//

            }

            if(game.getGameState().equals(GameState.WIN)){
                System.out.println("Game is over we have a winner = "+ game.getWinner().getName());
            }else{
                System.out.println("Game is Over");
            }
        } catch(Exception ex){
            System.out.println("There was an exception in creating the game");
            System.out.println("the exception was "+ex);
        }


//

    }
}