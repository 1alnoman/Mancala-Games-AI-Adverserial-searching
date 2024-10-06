package strategies;

import game.PlayerPosition;

public interface Heuristic {
    public void setBoardWidth(int width);
    public void setPlayerPosition(PlayerPosition position);
    public void setCurrentBoard(int[][] currBoard);
    public int effectOfThisMove();
}
