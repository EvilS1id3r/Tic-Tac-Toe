import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] cells = "         ".toCharArray();
        output(cells);
        boolean runProgram = true;
        boolean xTurn = true;
        while (runProgram) {
            System.out.print("Enter the coordinates: ");
            Scanner scan = new Scanner(System.in);
            int x, y;
            if (scan.hasNextInt()) {
                x = scan.nextInt();
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (scan.hasNextInt()) {
                y = scan.nextInt();
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (x > 3 || x < 1 || y > 3 || y < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            int index = Math.abs(y - 3) * 3 + x - 1;
            if (cells[index] == ' ') {
                if (xTurn) {
                    cells[index] = 'X';
                    xTurn = false;
                } else {
                    cells[index] = 'O';
                    xTurn = true;
                }
                output(cells);
                if (xThreeInARow(cells)) {
                    System.out.println("X wins");
                    runProgram = false;
                } else if (oThreeInARow(cells)) {
                    System.out.println("O wins");
                    runProgram = false;
                } else if (empty(cells) == 0) {
                    System.out.println("Draw");
                    runProgram = false;
                }
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }
    }

    public static void output(char[] cells) {
        System.out.println("---------");
        System.out.println("| " + cells[0] + " " + cells[1] + " " + cells[2] + " |");
        System.out.println("| " + cells[3] + " " + cells[4] + " " + cells[5] + " |");
        System.out.println("| " + cells[6] + " " + cells[7] + " " + cells[8] + " |");
        System.out.println("---------");
    }

    public static int empty(char[] cells) {
        int emptyCells = 0;
        for (int i = 0; i < 9; i++) {
            if (cells[i] == ' ') {
                emptyCells++;
            }
        }
        return emptyCells;
    }

    public static boolean xThreeInARow(char[] cells) {
        boolean xThree = false;
        if (cells[0] == cells[1] && cells[1] == cells[2] && cells[0] == 'X' ||
                cells[3] == cells[4] && cells[4] == cells[5] && cells[3] == 'X' ||
                cells[6] == cells[7] && cells[7] == cells[8] && cells[6] == 'X' ||
                cells[0] == cells[3] && cells[3] == cells[6] && cells[0] == 'X' ||
                cells[1] == cells[4] && cells[4] == cells[7] && cells[1] == 'X' ||
                cells[2] == cells[5] && cells[5] == cells[8] && cells[2] == 'X' ||
                cells[0] == cells[4] && cells[4] == cells[8] && cells[0] == 'X' ||
                cells[2] == cells[4] && cells[4] == cells[6] && cells[2] == 'X') {
            xThree = true;
        }
        return xThree;
    }

    public static boolean oThreeInARow(char[] cells) {
        boolean oThree = false;
        if (cells[0] == cells[1] && cells[1] == cells[2] && cells[0] == 'O' ||
                cells[3] == cells[4] && cells[4] == cells[5] && cells[3] == 'O' ||
                cells[6] == cells[7] && cells[7] == cells[8] && cells[6] == 'O' ||
                cells[0] == cells[3] && cells[3] == cells[6] && cells[0] == 'O' ||
                cells[1] == cells[4] && cells[4] == cells[7] && cells[1] == 'O' ||
                cells[2] == cells[5] && cells[5] == cells[8] && cells[2] == 'O' ||
                cells[0] == cells[4] && cells[4] == cells[8] && cells[0] == 'O' ||
                cells[2] == cells[4] && cells[4] == cells[6] && cells[2] == 'O') {
            oThree = true;
        }
        return oThree;
    }
}
