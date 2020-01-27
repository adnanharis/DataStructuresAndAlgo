// "static void main" must be defined in a public class.
// Check is Board game position valid. Also check for winner.

public class BoardGame {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        // char board[] = {'X', 'X', 'X',
        //                 'O', 'O', 'X',
        //                 'X', 'O', 'O'};

        char board[] = {'O', 'X', 'X',
                'O', 'O', 'O',
                'X', 'X', ' '};

        // char board[] = {' ', 'X', 'X',
        //                 'O', ' ', 'X',
        //                 'X', 'O', 'O'};

        // char board[] = {' ', ' ', ' ',
        //                 ' ', ' ', ' ',
        //                 ' ', ' ', ' '};

        // char board[] = {'X', 'X', 'X',
        //                 'O', 'O', 'O',
        //                 ' ', ' ', ' '};

        if ((isValid(board))) {
            System.out.println("Given board is valid");
            if (isWinner(board, 'X')) {
                System.out.println("X Wins");
            } else if (isWinner(board, 'O')) {
                System.out.println("O Wins");
            }
        } else {
            System.out.println("Given board is not valid");
        }
    }

    private static boolean isWinner(char[] board, char x) {
        int[][] winPos = new int[][] {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        for (int i = 0; i < winPos.length; i++) {
            if (board[winPos[i][0]] == x &&
                    board[winPos[i][1]] == x &&
                    board[winPos[i][2]] == x) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValid(char[] board) {
        int xCount = 0, oCount = 0, sCount = 0;
        for (int i = 0; i < board.length; i++) {
            switch(board[i]) {
                case 'X':
                    xCount++;
                    break;
                case 'O':
                    oCount++;
                    break;
                default:
                    sCount++;
            }
        }

        // Just add sCount with valid future number to xCount and oCount
        xCount += (sCount / 2) + (sCount % 2); // Will always be +1 as reminder
        oCount += (sCount / 2);

        System.out.println("Valid Moves " + (xCount == oCount + 1) + " " + isWinner(board, 'X') + " " + isWinner(board, 'O'));
        if (xCount != oCount + 1) {
            return false;
        }

        // Also check even board has valid moves but both are winner then also its a wrong board
        if (isWinner(board, 'X') && (isWinner(board, 'X') == isWinner(board, 'O'))) {
            return false;
        }

        return true;
    }
}

/*
// Geeks for Geeks
public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        char board[] = {'X', 'X', 'X',
                        'O', 'O', 'X',
                        'X', 'O', 'O'};

        if ((isValid(board))) {
            System.out.println("Given board is valid");
            if (isWin(board, 'X')) {
                System.out.println("X Wins");
            } else if (isWin(board, 'O')) {
                System.out.println("O Wins");
            }
        } else {
            System.out.println("Given board is not valid");
        }
     }

    private static boolean isWin(char[] board, char x) {
        int[][] winPos = new int[][] {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
        };

        // check for winnin position
        for (int i = 0; i < winPos.length; i++) {
            if (board[winPos[i][0]] == x &&
                    board[winPos[i][1]] == x &&
                    board[winPos[i][2]] == x) {
                        return true;
                }
        }
        return false;
    }

    private static boolean isValid(char[] board) {
        int xCount = 0, oCount = 0;
        for (char x : board) {
            switch(x) {
                case 'X':
                    xCount++;
                    break;
                case 'O':
                    oCount++;
                    break;
            }
        }

        if (xCount == oCount || xCount == oCount + 1) {
            if (isWin(board, 'O')) {
                if (isWin(board, 'X')) {
                    return false;
                }

                return xCount == oCount;
            }

            if (isWin(board, 'X')) {
                if (xCount != oCount + 1) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }
}

*/