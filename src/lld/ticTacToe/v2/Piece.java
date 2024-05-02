package lld.ticTacToe.v2;

public enum Piece {
    ZERO('O'), CROSS('X');

    Piece(char o) {
        this.o = o;
    }
    final char o;

    @Override
    public String toString() {
        return String.valueOf(o);
    }
}
