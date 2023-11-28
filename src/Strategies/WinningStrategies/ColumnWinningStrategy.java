package Strategies.WinningStrategies;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements  WinningStrategy {
    HashMap<Integer, HashMap<Symbol, Integer>>counts = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        //get the val of row, col,symbol
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        //increment value of symbol count by 1
        // If I want to increment the count of that symbol by 1
        if(!counts.containsKey(col)){
            counts.put(col, new HashMap<>());
        }
        Map<Symbol, Integer> colMap = counts.get(col);
        //if no value for count then put 0
        if(!colMap.containsKey(symbol)){
            colMap.put(symbol,0);
        }
        //increment the count by 1
        colMap.put(symbol,colMap.get(symbol)+1);
        //check if this a winner

        if(colMap.get(symbol) == board.getSize()){
            return  true;
        }
        return  false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol, Integer> colMap = counts.get(col);

        //dec the count by 1
        colMap.put(symbol,colMap.get(symbol)-1);

    }
}
