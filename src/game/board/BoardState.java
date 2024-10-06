package game.board;

import game.PlayerPosition;
import game.move.PlayerMove;

public class BoardState {
    private int[][] currBoard;
    private int[][] nextOptimalBoard;
    private int widthBoard;
    private int weightOftheState;
    private PlayerPosition position;

    public void setNextOptimalBoard(int[][] nextOptimalBoard) {
        this.nextOptimalBoard = nextOptimalBoard;
    }

    public int[][] getNextOptimalBoard() {
        return nextOptimalBoard;
    }

    public int[][] getCurrBoard() {
        return currBoard;
    }

    public void setCurrBoard(int[][] currBoard) {
        this.currBoard = currBoard;
    }

    public int getWidthBoard() {
        return widthBoard;
    }

    public void setWidthBoard(int widthBoard) {
        this.widthBoard = widthBoard;
    }

    public int getWeightOftheState() {
        return weightOftheState;
    }

    public void setWeightOftheState(int weightOftheState) {
        this.weightOftheState = weightOftheState;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }

    public boolean isTerminal() {
        int countRow1=0;
        for(int i=1;i<widthBoard-1;i++) countRow1+=currBoard[0][i];
        int countRow2=0;
        for(int i=1;i<widthBoard-1;i++) countRow2+=currBoard[1][i];

        if(countRow1==0) {
            for(int i=1;i<widthBoard-1;i++) {
                currBoard[1][i]=0;
            }
            this.getCurrBoard()[0][widthBoard-1] = countRow2;
            return true;
        }
        else if(countRow2==0) {
            for(int i=1;i<widthBoard-1;i++) {
                currBoard[0][i]=0;
            }
            this.getCurrBoard()[0][0] = countRow2;
            return true;
        }

        return false;
    }

    public BoardState nextState(int moveFormBinNo) {
        int [][] nextMovArr = PlayerMove.moveFromBin(moveFormBinNo,this.getCurrBoard(),this.getWidthBoard(),position);
        if(nextMovArr == null) return null;
        BoardState nextSate = new BoardState();
        nextSate.setCurrBoard(nextMovArr);
        nextSate.setWidthBoard(this.getWidthBoard());

        return nextSate;
    }
}
