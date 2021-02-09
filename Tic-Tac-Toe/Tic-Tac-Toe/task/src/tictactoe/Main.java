package tictactoe;

import java.util.Scanner;

public class Main {

    private static final int N = 3;
    private static final char [][] cells = new char[N][N];
    private static final Scanner scanner = new Scanner(System.in);
    static char wins;

    static void Initialize(String inputText) {
        var index = 0;
        for (var i = 0; i < N; i++)
            for (var j = 0; j < N; j++)
                cells[i][j] = inputText.charAt(index++);
    }

    static void Print(){
        System.out.println("---------");
        for (var i = 0; i < N; i++) {
            System.out.print("| ");
            for (var j = 0; j < N; j++)
                System.out.print(cells[i][j] + " ");
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static boolean isNotFinished() {
        for (var i = 0; i < N; i++)
            for (var j = 0; j < N; j++)
                if(cells[i][j] == '_')
                    return true;
        return false;
    }
    static boolean isEquals(char val1, char val2, char val3) {
        return val1 == val2 && val2 == val3;
    }
    static boolean isRowEquals(){
        for (var i = 0; i < N; i++)
            if(isEquals(cells[i][0],cells[i][1],cells[i][2])) {
                wins = cells[i][0];
                return true;
            }
        return false;
    }
    static boolean isColEquals(){
        for (var i = 0; i < N; i++)
            if(isEquals(cells[0][i],cells[1][i],cells[2][i])){
                wins = cells[0][i];
                return true;
            }
        return false;
    }
    static boolean isDiagonalEquals(){
        if(isEquals(cells[0][0],cells[1][1],cells[2][2]) ||
                isEquals(cells[0][2],cells[1][1],cells[2][0])){
            wins = cells[1][1];
            return true;
        }
        return false;
    }
    static boolean isWin() {
        return isRowEquals() || isColEquals() || isDiagonalEquals();
    }
    static boolean isDraw(){
        int O = 0, X = 0, N = 0;
        for (var i = 0; i < N; i++)
            for (var j = 0; j < N; j++) {
                if ( cells[i][j] == 'O' )
                    O++;
                else if ( cells[i][j] == 'X' )
                    X++;
                else
                    N++;
            }
        return Math.abs(O - X) < 1 && N == 0;
    }
    static void ResultGamePrint(){
        if(isWin() && !isNotFinished())
            System.out.print(wins + " wins");
        else if(!isWin() && isNotFinished())
            System.out.print("Game not finished");
        else if(isDraw() )
            System.out.print("Draw");
        else
            System.out.print("Impossible");

    }
    public static void main(String[] args) {
        Initialize(scanner.next());
        Print();
        ResultGamePrint();
    }
}
