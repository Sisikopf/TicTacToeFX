package sample.Model;

/**
 * Created by Vladimir on 30.09.2015.
 */
public class Game {

    enum State {Blank, X, O}

    ;
    boolean gameOver;
    int n;
    State[][] board;
    int moveCount;
    State currentState;

    public State getCurrentState() {
        return currentState;
    }

    public String getStringCurrentState() {
        return currentState.toString();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Game()
    {
        newGame();
    }

    public void newGame() {
        n = 3;
        board = new State[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n;j++)
            {
                board[i][j]=State.Blank;
            }
        moveCount = 0;
        gameOver =false;
        currentState = State.X;
    }

    public void changeState() {
        if (currentState == State.O) {
            currentState = State.X;
        } else {
            currentState = State.O;
        }
    }

    public boolean  Move(int x, int y) {
        if (board[x][y] == State.Blank) {
            board[x][y] = currentState;
            moveCount++;
            return true;
        }
        return false;
    }

    public boolean isDraw()
    {
        if(moveCount>=n*n)
        {
            gameOver =true;
            return true;
        }
        return false;
    }

    public boolean checkConditions(int x, int y) {
        for (int i = 0; i < n; i++) {
            if (board[x][i] != currentState)
                break;
            if (i == n - 1) {
                gameOver =true;
                return true;
            }
        }

        //check row
        for (int i = 0; i < n; i++) {
            if (board[i][y] != currentState)
                break;
            if (i == n - 1) {
                gameOver =true;
                return true;
            }
        }

        //check diag
        if (x == y) {
            //we're on a diagonal
            for (int i = 0; i < n; i++) {
                if (board[i][i] != currentState)
                    break;
                if (i == n - 1) {
                    gameOver =true;
                    return true;
                }
            }
        }

        //check anti diag (thanks rampion)
        for (int i = 0; i < n; i++) {
            if (board[i][(n - 1) - i] != currentState)
                break;
            if (i == n - 1) {
                gameOver =true;
                return true;
            }
        }
        return false;
    }


}


