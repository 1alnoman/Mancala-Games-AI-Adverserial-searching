package game;

public enum PlayerPosition {
    TOP,BOTTOM;

    public static PlayerPosition nextPosition(PlayerPosition position) {
        if(position.equals(PlayerPosition.TOP)) {
            return PlayerPosition.BOTTOM;
        }
        return PlayerPosition.TOP;
    }
}
