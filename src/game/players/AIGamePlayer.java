package game.players;

import game.GamePlayer;
import game.PlayerPosition;
import game.board.BoardState;
import strategies.Heuristic;

public class AIGamePlayer implements GamePlayer {
    private BoardState currentSate;
    private Heuristic heuristic;
    private PlayerPosition positionPrev;
    private int depth;

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

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setHeuristic(Heuristic heuristic) {
        this.heuristic = heuristic;
    }

    @Override
    public void setPosition(PlayerPosition position) {
        this.positionPrev = PlayerPosition.nextPosition(position);
    }

    @Override
    public int[][] playNextMove() {
        if(currentSate.isTerminal()) return null;

        BoardState optimalState = minMaxAlgo(this.currentSate,this.depth,Integer.MIN_VALUE,Integer.MAX_VALUE,true,this.positionPrev);
        return optimalState.getNextOptimalBoard();
    }

    private BoardState minMaxAlgo(BoardState stateNow,int depthDFS,int alpha,int beta,boolean isMaxPlayer,PlayerPosition positionPrev) {
        PlayerPosition positionNow = PlayerPosition.nextPosition(positionPrev);

        stateNow.setPosition(positionNow);

        if(depthDFS==0 || stateNow.isTerminal()) {
            this.heuristic.setCurrentBoard(stateNow.getCurrBoard());
            this.heuristic.setBoardWidth(stateNow.getWidthBoard());
            this.heuristic.setPlayerPosition(positionNow);

            int effectOfThisMove = this.heuristic.effectOfThisMove();
            stateNow.setWeightOftheState(effectOfThisMove);

            return stateNow;
        }

        if(isMaxPlayer) {
            stateNow.setWeightOftheState(Integer.MIN_VALUE);

            for(int i=1;i<stateNow.getWidthBoard()-1;i++) {
                if(stateNow.nextState(i)==null) {
                    continue;
                }
                BoardState nextState = minMaxAlgo(stateNow.nextState(i),depthDFS-1,alpha,beta,false,positionNow);

                if(nextState.getWeightOftheState()>stateNow.getWeightOftheState()) {
                    stateNow.setWeightOftheState(nextState.getWeightOftheState());
                    stateNow.setNextOptimalBoard(nextState.getCurrBoard());
                }

                alpha=Math.max(alpha,stateNow.getWeightOftheState());

                if(alpha>=beta) {
                    break;
                }

                return stateNow;
            }
        }
        else {
            stateNow.setWeightOftheState(Integer.MAX_VALUE);

            for(int i=1;i<stateNow.getWidthBoard()-1;i++) {
                if(stateNow.nextState(i)==null) {
                    continue;
                }
                BoardState nextState = minMaxAlgo(stateNow.nextState(i),depthDFS-1,alpha,beta,true,positionNow);

                if(nextState.getWeightOftheState()<stateNow.getWeightOftheState()) {
                    stateNow.setWeightOftheState(nextState.getWeightOftheState());
                    stateNow.setNextOptimalBoard(nextState.getCurrBoard());
                }
                beta=Math.min(beta,stateNow.getWeightOftheState());   //in javapoint there is eval instead of minEval

                if(alpha>=beta) {
                    break;
                }
            }
            return stateNow;
        }

        return null;
    }
}
