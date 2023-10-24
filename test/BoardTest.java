import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board = new Board();
    Player luis = new Player("Luis");
    Player ben = new Player("Ben");
    int x, y = 0;
    @BeforeEach
    void setUp(){
        board = new Board();
        board.selectPlayerOne(luis);
        board.selectPlayerTwo(ben);
    }
    @Test
    void size() {
        assertEquals(15,board.size);
    }
    @Test
    void size2() {
        int size = 17;
        Board board2 = new Board(size);
        assertEquals(size,board2.size);
    }

    @Test
    void clear() {

    }

    @Test
    void isFull() {

    }

    @Test
    void placeStone() {
        board.placeStone(x,y,luis);
        assertTrue(board.isOccupiedBy(x,y,luis));
    }

    @Test
    void isEmpty() {
        board.placeStone(x,y,luis);
        assertFalse(board.isEmpty(x,y));
    }

    @Test
    void isOccupied() {
        board.placeStone(x,y,luis);
        assertTrue(board.isOccupied(x,y));
    }

    @Test
    void isOccupiedBy() {
        board.placeStone(x,y,luis);
        assertTrue(board.isOccupiedBy(x,y,luis));
    }

    @Test
    void playerAt() {
        board.placeStone(x,y,luis);
        assertEquals(luis.name(),board.playerAt(x,y).name());
    }

    @Test
    void isWonBy() {
        board.placeStone(0,1,luis);
        board.placeStone(0,2,luis);
        board.placeStone(0,3,luis);
        board.placeStone(0,4,luis);
        board.placeStone(0,5,luis);
        assertTrue(board.isWonBy(luis));
    }

    @Test
    void isWonByHorizontal() {
        board.placeStone(7,4,ben);
        board.placeStone(8,4,ben);
        board.placeStone(9,4,ben);
        board.placeStone(10,4,ben);
        board.placeStone(11,4,ben);
        assertTrue(board.isWonBy(ben));
    }
    @Test
    void isWonByVertical() {
        board.placeStone(9, 7, luis);
        board.placeStone(9, 6, luis);
        board.placeStone(9, 3, luis);
        board.placeStone(9, 4, luis);
        board.placeStone(9, 5, luis);
        assertTrue(board.isWonBy(luis));
    }
    @Test
    void isWonByDiagonal() {
        board.placeStone(2,2,ben);
        board.placeStone(6,6,ben);
        board.placeStone(3,3,ben);
        board.placeStone(4,4,ben);
        board.placeStone(5,5,ben);
        assertTrue(board.isWonBy(ben));
    }
    @Test
    void isWonByFalse() {
        board.placeStone(0,1,luis);
        board.placeStone(0,2,luis);
        board.placeStone(0,3,ben);
        board.placeStone(0,4,luis);
        board.placeStone(0,5,luis);
        assertFalse(board.isWonBy(luis));
    }
//
//    @Test
//    void winningRow() {
//    }

    @Test
    void selectPlayerOne(){
        Player daniel = new Player("Daniel");
        board.selectPlayerOne(daniel);
        board.placeStone(7,7,daniel);
        assertEquals("Daniel",board.playerAt(7,7).name());
    }
    @Test
    void selectPlayerTwo(){
        Player alex = new Player("Alex");
        board.selectPlayerOne(alex);
        board.placeStone(5,5,alex);
        assertEquals("Alex",board.playerAt(5,5).name());
    }
}