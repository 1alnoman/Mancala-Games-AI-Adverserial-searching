import game.GameSystem;
import game.PlayerPosition;
import game.board.MancalaBoard;
import game.move.PlayerMove;
import game.players.PlayerGenerator;

public class MancalaMain {
    public static void main(String[] args) {
        int [][]board={{0,5,2,8,0},{0,1,2,3,0}};

        MancalaBoard mancalaBoard = new MancalaBoard();
        mancalaBoard.setBoardWidth(6);
        mancalaBoard.setInitStonesInEachBin(4);
        mancalaBoard.initializeBoard();

        GameSystem gameSystem = new GameSystem();
        gameSystem.setBoard(mancalaBoard);
        gameSystem.setPlayer1(PlayerGenerator.generatePlayer("human"));
        gameSystem.setPlayer2(PlayerGenerator.generatePlayer("human"));

        gameSystem.play();
    }
}
