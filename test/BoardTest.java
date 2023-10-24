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