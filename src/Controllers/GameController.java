package Controllers;

import Models.Game;
import Models.GameState;
import Models.Player;
import Strategies.WinningStrategies.WinningStrategy;

import java.util.List;
public class GameController {

    public  Game startGame(int dimensionBoard, List<Player>players, List<WinningStrategy>winningStrategies) throws Exception{
        return Game.getBuilder().setBoardDimension(dimensionBoard).setPlayers(players).setWinningStrategies(winningStrategies).build();
    }

    public  void makeMove(Game game){
        game.makeMove();
    }
    public void printBoard(Game game){
        game.printBoard();
    }

    public GameState checkState(Game game){
        return game.getGameState();

    }
    public  void getWinner(Game game){
        game.getWinner();
    }

    public void undo(Game game) {
        game.undo();
    }
}
