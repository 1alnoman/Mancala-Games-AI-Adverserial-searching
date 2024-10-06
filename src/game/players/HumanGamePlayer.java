package game.players;

import game.GamePlayer;
import game.PlayerPosition;
import game.board.BoardState;
import game.move.PlayerMove;

import java.util.Scanner;

public class HumanGamePlayer implements GamePlayer {
    private BoardState currentSate;
    private PlayerPosition position;

    @Override
    public void setCurrState(int[][] board, int widthBoard) {
        currentSate = new BoardState();
        currentSate.setCurrBoard(board);
        currentSate.setWidthBoard(widthBoard);
        currentSate.setNextOptimalBoard(null);
    }
    @Override
    public BoardState getCurrentSate() {
        return currentSate;
    }
    @Override
    public void setPosition(PlayerPosition position) {
        this.position=position;
    }

    @Override
    public int[][] playNextMove() {
        Scanner scn = new Scanner(System.in);
        BoardState nextState = null;

        if(currentSate.isTerminal()) return null;

        currentSate.setPosition(this.position);
        while (nextState == null) {
            while (scn.hasNextLine()) {
                nextState = this.currentSate.nextState(Integer.parseInt(scn.nextLine()));
                break;
            }
        }

        return nextState.getCurrBoard();
    }

}
