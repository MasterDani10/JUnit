package omok.model;

import omok.model.Player;
public class Board {
    protected int[][] board;
    Player player1;
    Player player2;
    int size;
    /** Create a new board of the default size. */
    public Board() {
        size = 15;
        this.board = new int[size][size];
    }

    /** Create a new board of the specified size. */
    public Board(int size) {
        this.size = size;
        this.board = new int[size][size];
    }

    /** Return the size of this board. */
    public int size() {
        return size;
    }

    /** Removes all the stones placed on the board, effectively
     * resetting the board to its original state.
     */
    public void clear() {
        board = new int[size][size];
    }

    /** Return a boolean value indicating whether all the places
     * on the board are occupied or not.
     */
    public boolean isFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Place a stone for the specified player at a specified
     * intersection (x, y) on the board.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     * @param player Player whose stone is to be placed
     */
    public void placeStone(int x, int y, Player player) {
        if(player1.name().equals(player.name())){
            board[y][x] = 1;
        }
        else{
            board[y][x] = 2;
        }
    }

    /**
     * Return a boolean value indicating whether the specified
     * intersection (x, y) on the board is empty or not.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean isEmpty(int x, int y) {
        if(board[y][x] == 0){
            return true;
        }
        return false;
    }

    /**
     * Return a boolean value indicating whether the specified
     * intersection (x, y) on the board is occupied or not.
     *
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean isOccupied(int x, int y) {
        if(board[y][x] == 0){
            return false;
        }
        return true;
    }

    /**
     * Return a boolean value indicating whether the specified
     * intersection (x, y) on the board is occupied by the given
     * player or not.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public boolean isOccupiedBy(int x, int y, Player player) {
        if(player1.name().equals(player.name())){
            if(board[y][x] == 1){
                return true;
            }
        }
        if(player2.name().equals(player.name())){
            if(board[y][x] == 2){
                return true;
            }
        }
        return false;
    }

    /**
     * Return the player who occupies the specified intersection (x, y)
     * on the board. If the place is empty, this method returns null.
     *
     * @param x 0-based column (vertical) index
     * @param y 0-based row (horizontal) index
     */
    public Player playerAt(int x, int y) {
        if(board[y][x] == 1){
            return player1;
        }
        else if(board[y][x] == 2){
            return player2;
        }
        else{
            return null;
        }
    }

    /**
     * Return a boolean value indicating whether the given player
     * has a winning row on the board. A winning row is a consecutive
     * sequence of five or more stones placed by the same player in
     * a horizontal, vertical, or diagonal direction.
     */
    public boolean isWonBy(Player player) {
    }

    /** Return the winning row. For those who are not familiar with
     * the Iterable interface, you may return an object of
     * List<Place>. */
    public Iterable<Place> winningRow() {
    }

    /**
     * An intersection on an Omok board identified by its 0-based column
     * index (x) and row index (y). The indices determine the position
     * of a place on the board, with (0, 0) denoting the top-left
     * corner and (n-1, n-1) denoting the bottom-right corner,
     * where n is the size of the board.
     */
    public static class Place {
        /** 0-based column index of this place. */
        public final int x;

        /** 0-based row index of this place. */
        public final int y;

        /** Create a new place of the given indices.
         *
         * @param x 0-based column (vertical) index
         * @param y 0-based row (horizontal) index
         */
        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void selectPlayer1(Player player){
            player1 = new Player(player.name());
        }
        public void selectPlayer2(Player player){
            player2 = new Player(player.name());
        }

        // other methods if needed ...
    }
}
