package Strategies.WinningStrategies;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {
    HashMap<Integer, HashMap<Symbol,Integer>> counts = new HashMap<>();
    //| 0 | -> x -> 0, o->0
    //| 1 | -> x -> 0, o -> 0

    @Override
    public boolean checkWinner(Board board, Move move) {
        //get the val of row, col,symbol
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();
        //increment value of symbol count by 1
        // If I want to increment the count of that symbol by 1
        if(!counts.containsKey(row)){
            counts.put(row, new HashMap<>());
        }
        Map<Symbol, Integer>rowMap = counts.get(row);
        //if no value for count then put 0
        if(!rowMap.containsKey(symbol)){
            rowMap.put(symbol,0);
        }
        //increment the count by 1
        rowMap.put(symbol, rowMap.get(symbol)+1);
        //check if this a winner

        if(rowMap.get(symbol) == board.getSize()){
            return  true;
        }
        return  false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol, Integer>rowMap = counts.get(row);
        rowMap.put(symbol, rowMap.get(symbol) - 1);


    }
}
