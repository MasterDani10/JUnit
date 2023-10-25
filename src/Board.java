import java.util.ArrayList;
import java.util.List;

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
    public void selectPlayerOne(Player player){
        player1 = new Player(player.name());
    }
    public void selectPlayerTwo(Player player){
        player2 = new Player(player.name());
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
        int p;
        if (player1.name().equals(player.name())) {
            p = 1;
        }
        else{
            p = 2;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == p &&
                        (       checkDirection(board, i, j, 1, 0) ||
                                checkDirection(board, i, j, 0, 1) ||
                                checkDirection(board, i, j, 1, 1) ||
                                checkDirection(board, i, j, 1, -1))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks for the winning sequence in the direction of the specified starting point (x, y).
     *
     * This method determines if there is a consecutive sequence of five stones in a row of the
     * same player starting current position (x, y) and checking different directions (dx, dy).
     *
     * @param board The 2D array represents the game board. Each entry should be 0 (empty),
     *              1 representing Player 1, or 2 representing player 2
     * @param x The starting x-coordinate representing the columns on the board
     * @param y The starting y-coordinate representing the rows on the board
     * @param dx Checks the x-direction
     * @param dy Checks the y-direction
     * @return Returns true if there is a winning sequence in the specified direction
     *         starting from the position (x, y). Otherwise, returns false.
     */

    private boolean checkDirection(int[][] board, int x, int y, int dx, int dy) {
        int n = board.length;
        int player = board[x][y];

        for (int i = 0; i < 5; i++){
            int newX = x + dx * i;
            int newY = y + dy * i;
            if (newX < 0 || newX >= n || newY < 0 || newY >= n || board[newX][newY] != player) {
                return false;
            }
        }
        return true;
    }

    /** Return the winning row. For those who are not familiar with
     * the Iterable interface, you may return an object of
     * List<Place>. */
    public Iterable<Place> winningRow(Player player) {
        int playerNum;
        if (player1.name().equals(player.name())) {//checking if player 1 or 2
            playerNum = 1;
        } else {
            playerNum = 2;
        }
        int[][] directions = {{1, 0}, {0, 1}, {1, 1}, {1, -1}};//initializing directions for winning row

        for (int i = 0; i < board.length; i++) {// iterating through rows and columns
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] != playerNum){//if position doesnt contain stone continues to check rest of positions
                    continue;
                }
                for(int dir = 0; dir < directions.length; dir++){
                    List<Place> row = new ArrayList<>();//stores position of stones
                    for(int count = 0; count < 5; count++){//checking for five in a row
                        int x = i + directions[dir][0] * count;
                        int y = j + directions[dir][1] * count;
                        if(x < 0 || x >= board.length || y >= board.length || board[x][y] != playerNum){//checking coordinates of the stones and if its the players stone if not clear row
                            row.clear();
                            break;
                        }
                        row.add(new Place(x, y));//if coordinates of stone are the players then coordinates are stored
                    }
                    if(row.size() == 5){// if 5 coordinates are stored in the row returns the winning row
                        return row;
                    }
                }
            }
        }
        return new ArrayList<>();// if not returns an empty list
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
        // other methods if needed ...
    }
}
