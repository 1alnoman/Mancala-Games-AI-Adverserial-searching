package game.move;

import game.PlayerPosition;

public class PlayerMove {
    public static int[][] moveFromBin(int nBin, int[][] board, int widthBoard, PlayerPosition position) {
        if(nBin<widthBoard-1 && nBin>0) {
            int[][] newBoard=copyArray(board,widthBoard);

            int lane=0;              //lane 0 means top player
            if(position==PlayerPosition.TOP) lane=0;
            else if(position==PlayerPosition.BOTTOM) lane=1;

            int nStones = newBoard[lane][nBin];

            if(nStones < 1) return newBoard;
            else newBoard[lane][nBin]=0;

            int nowBin = nBin;

            for(int i=0;i<nStones;i++) {
                if(lane==0) nowBin--;
                else if(lane==1) nowBin++;

                if(position.equals(PlayerPosition.TOP)) {
                    if(nowBin < 0 && lane==0) {
                        lane = 1;
                        nowBin = 1;
                    }
                    else if(nowBin == widthBoard-1 && lane==1) {
                        lane = 0;
                        nowBin = widthBoard-2;
                    }
                }
                else if(position.equals(PlayerPosition.BOTTOM)) {
                    if(nowBin == widthBoard && lane==1) {
                        lane = 0;
                        nowBin = widthBoard-2;
                    }
                    else if(nowBin == 0 && lane==0) {
                        lane = 1;
                        nowBin = 1;
                    }
                }

                newBoard[lane][nowBin]++;
            }
            return newBoard;
        }
        return null;
    }

    private static int[][] copyArray(int[][] board,int width) {
        int[][] newBoard = new int[2][width];

        for(int i=0;i<2;i++) {
            for(int j=0;j<width;j++) {
                newBoard[i][j]=board[i][j];
            }
        }
        return newBoard;
    }
}
