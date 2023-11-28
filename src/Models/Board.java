package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>>board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>(); //big arraylist 2D mat

        for(int i = 0; i < size; i++){
            board.add(new ArrayList<>());//[{}, {},{}]

            for(int j = 0; j < size; j++){
                board.get(i).add(new Cell(i,j));  //[{Cell,Cell,Cell},{Cell,Cell,Cell},{Cell,Cell,Cell}  ]
            }
        }
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public List<List<Cell>> getBoard(){
        return  board;
    }

    public  void setBoard(List<List<Cell>>board){
        this.board = board;
    }

    public  void print(){
        for(List<Cell>row :board){
            for(Cell cell: row){
                cell.print();
            }
            System.out.println();
        }
    }

}
