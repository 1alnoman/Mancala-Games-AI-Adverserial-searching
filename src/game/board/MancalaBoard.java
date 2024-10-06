package game.board;

import game.PlayerPosition;
import game.move.PlayerMove;

public class MancalaBoard {
    private int boardWidth;
    private int initStonesInEachBin;

    private int[][] board;  //(0,0) and (0,boardWidth) contains the storage..

    public int getBoardWidth() {
        return boardWidth;
    }

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth+2;   //2 for 2 reservers
        board = new int[this.boardWidth][this.boardWidth];
    }

    public int getInitStonesInEachBin() {
        return initStonesInEachBin;
    }

    public void setInitStonesInEachBin(int initStonesInEachBin) {
        this.initStonesInEachBin = initStonesInEachBin;
    }

    public int[][] getBoard() {
        return board;
    }

    public void initializeBoard() {
        for(int i=0;i<2;i++) {
            for (int j=1;j<this.getBoardWidth()-1;j++) {
                this.getBoard()[i][j]=this.getInitStonesInEachBin();
            }
            this.getBoard()[i][0]=0;
            this.getBoard()[i][this.getBoardWidth()-1]=0;
        }
    }
}
