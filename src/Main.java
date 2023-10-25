public class Main {
    public static void main(String[] args){
        Board gameBoard = new Board(15);

        Player player1 = new Player("Ben");
        Player player2 = new Player("Luis");

        gameBoard.selectPlayerOne(player1);
        gameBoard.selectPlayerTwo(player2);

        for (int i = 0; i < 5; i++) {
            gameBoard.placeStone(i, 7, player1);
        }

        if(gameBoard.isWonBy(player1)) {
            System.out.println(player1.name() + " has won!");
            Iterable<Board.Place> winningRow = gameBoard.winningRow(player1);
            for(Board.Place place : winningRow) {
                System.out.println("(" + place.x + "," + place.y + ")");

            }
        } else {
            System.out.println(player1.name() + " hasn't won yet.");
        }

        if(gameBoard.isWonBy(player2)) {
            System.out.println(player2.name() + " has won!");
        } else {
            System.out.println(player2.name() + " hasn't won yet.");
        }
    }
}


