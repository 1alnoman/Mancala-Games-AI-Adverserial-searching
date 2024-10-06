package game;

import game.board.MancalaBoard;

public class GameSystem {
    GamePlayer player1;
    GamePlayer player2;
    MancalaBoard board;

    public GamePlayer getPlayer1() {
        return player1;
    }

    public void setPlayer1(GamePlayer player1) {
        this.player1 = player1;
    }

    public GamePlayer getPlayer2() {
        return player2;
    }

    public void setPlayer2(GamePlayer player2) {
        this.player2 = player2;
    }

    public MancalaBoard getBoard() {
        return board;
    }

    public void setBoard(MancalaBoard board) {
        this.board = board;
    }

    public void play() {
        showBoard(this.getBoard().getBoard());

        PlayerPosition posP1 = PlayerPosition.BOTTOM;
        player1.setPosition(posP1);
        player2.setPosition(PlayerPosition.nextPosition(posP1));

        player1.setCurrState(board.getBoard(), board.getBoardWidth());

        System.out.println("P1 give move: ");
        int[][] afterP1Move = player1.playNextMove();
        showBoard(afterP1Move);

        player2.setCurrState(afterP1Move ,board.getBoardWidth());

        System.out.println("P2 give move: ");
        int[][] afterP2Move = player2.playNextMove();
        showBoard(afterP2Move);

        while (afterP1Move != null && afterP2Move != null) {
            player1.setCurrState(afterP2Move, board.getBoardWidth());
            System.out.println("P1 give move: ");
            afterP1Move = player1.playNextMove();

            player2.setCurrState(afterP1Move ,board.getBoardWidth());
            System.out.println("P2 give move: ");
            afterP2Move = player2.playNextMove();
        }
    }

    private void showBoard(int[][] board) {
        System.out.print("\t||");
        for (int j=1;j<this.board.getBoardWidth()-1;j++) {
            System.out.print("\t("+j+")");
        }
        System.out.print("\t||");
        System.out.print("\n\t||");
        for (int j=1;j<this.board.getBoardWidth()-1;j++) {
            System.out.print("\t "+board[0][j]);
        }
        System.out.print("\t||");
        System.out.print("\n"+board[0][0]+"\t||");


        for (int j=1;j<this.board.getBoardWidth()-1;j++) {
            System.out.print("\t");
        }
        System.out.print("\t||\t"+board[1][this.getBoard().getBoardWidth()-1]);

        System.out.print("\n\t||");
        for (int j=1;j<this.board.getBoardWidth()-1;j++) {
            System.out.print("\t "+board[1][j]);
        }
        System.out.print("\t||");
        System.out.print("\n\t||");
        for (int j=this.board.getBoardWidth()-2;j>=1;j--) {
            System.out.print("\t("+j+")");
        }
        System.out.print("\t||");

        System.out.println("\n\n");
    }
}
