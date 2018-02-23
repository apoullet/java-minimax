package calculations;

public class Board {
    //Array which is used to represent the board.
    private int[][] board;

    //Matrix which contains every winning combination.
    private int[][][] winMatrix = {{{0, 0}, {1, 0}, {2, 0}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 2}, {1, 2}, {2, 2}},
            {{0, 0}, {0, 1}, {0, 2}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{2, 0}, {2, 1}, {2, 2}},
            {{0, 0}, {1, 1}, {2, 2}},
            {{2, 0}, {1, 1}, {0, 2}}};

    //Constructor which initialize a new board.
    public Board() {
        board = new int[3][3];
    }

    //Constructor which is used to make a copy of the board put in the argument.
    public Board(Board board) {
        setBoard(board);
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = new int[3][3];

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                this.board[x][y] = board.getBoard()[x][y];
            }
        }
    }

    //This method uses the winning matrix to compare the spots and see if they all contain one of the player's number.
    //If not it returns false otherwise it returns true.
    public boolean checkWin(boolean player) {
        int value = (player) ? 1 : 2;

        for (int x = 0; x < 8; x++) {
            boolean win = true;

            for (int y = 0; y < 3; y++) {
                if (board[winMatrix[x][y][0]][winMatrix[x][y][1]] != value) {
                    win = false;
                    break;

                }
            }

            if (win) return true;
        }

        return false;
    }

    public boolean checkValid(int x, int y) {
        return (board[x][y] == 0);
    }

    //Checks if the board is full.
    public boolean checkFull() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[x][y] == 0) return false;
            }
        }

        return true;
    }
}
