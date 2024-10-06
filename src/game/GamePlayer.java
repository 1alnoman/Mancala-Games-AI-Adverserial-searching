package game;

import game.board.BoardState;
import strategies.Heuristic;

public interface GamePlayer {
    public void  setCurrState(int[][] board,int widthBoard);
    public int[][] playNextMove();
    public void setPosition(PlayerPosition position);
    public BoardState getCurrentSate();
}
