package strategies;

import game.PlayerPosition;

public class StorageDiff implements Heuristic{
    private int[][] currBoard;
    private int widthBoard;
    PlayerPosition position;

    @Override
    public void setBoardWidth(int width) {
        this.widthBoard = width;
    }

    @Override
    public void setPlayerPosition(PlayerPosition position) {
        this.position=position;
    }

    @Override
    public void setCurrentBoard(int[][] currBoard) {
        this.currBoard=currBoard;
    }

    @Override
    public int effectOfThisMove() {
        int cost=0;
        if(this.position == PlayerPosition.TOP) {
            cost=this.currBoard[0][0]-this.currBoard[0][widthBoard-1];
        }
        else if(this.position == PlayerPosition.BOTTOM) {
            cost=this.currBoard[0][widthBoard-1]-this.currBoard[0][0];
        }
        return cost;
    }
}
