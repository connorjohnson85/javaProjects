import java.util.Scanner;


class TicTacToe {
  public static void main(String[] args) {
     String answer = "";
     String computer;
     String player;
     String[] board = new String[9];
     for (int i = 0; i < 9; i++) {
       board[i] = "*";
     }
     Scanner input = new Scanner(System.in);
     System.out.println("Welcome to Tic-Tac-Toe!");
     System.out.println("X's or O's?");
     while (!answer.equals("X") || !answer.equals("O")) {
       answer = input.nextLine();
       System.out.println(answer);
       System.out.println(answer.equals("X"));
       if (answer.equals("X") || answer.equals("O")) {
         break;
       }
     }
     System.out.println("You have picked: " + answer + "!");
     if (answer.equals("X")) {
       computer = "O";
       player = "Player1";
     }
     else {
       computer = "X";
       player = "Computer";
     }
     while (true) {
	if (player.equals("Computer")) {
          board = play(player, computer, board, input);
        }
        else {
	  board = play(player, answer, board, input);
	}
        PrintBoard(board);
	if (player.equals("Player1")) {
          player = "Computer";
        }
        else {
          player = "Player1";
        }
	System.out.println("Computer is moving...");
     }
  }

  private static boolean checkWin(String player, String[] board) {
    if (board[0].equals(board[1]) && board[1].equals(board[2])) {
      System.out.println(player + " wins! Congratulations!");
      return true;
    }
    else if (board[3].equals(board[4]) && board[3].equals(board[5])) {
      System.out.println(player + " wins! Congratulations!");
      return true;
    }
    else if (board[6].equals(board[7]) && board[6].equals(board[8])) {
      System.out.println(player + " wins! Congratulations!");
      return true;
    }
    else if (board[0].equals(board[4]) && board[0].equals(board[8])) {
      System.out.println(player + " wins! Congratulations!");
      return true;
    }
    else if(board[2].equals(board[4]) && board[2].equals(board[6])) {
      System.out.println(player + " wins! Congratulations!");
      return true;
    }
    else if(board[0].equals(board[3]) && board[0].equals(board[6])) {
      System.out.println(player + " wins! Congratulations!");
      return true;
    }
    else if(board[1].equals(board[4]) && board[7].equals(board[0])) {
      System.out.println(player + " wins! Congratulations!");
      return true;
    }
    else if(board[2].equals(board[5]) && board[2].equals(board[8])) {
      System.out.println(player + " wins! Congratulations!");
      return true;
    }
    else {
      return false;
    }
  }
  private static String[] play(String player, String letter, String[] board, Scanner input) {
    if (player.equals("Player1")) {
      System.out.println("Where would you like to go?");
      int space = Integer.parseInt(input.nextLine());
      space = space - 1;
      board[space] = letter;
      return board;
    }
    else if (player.equals("Computer")) {
      int number = computerAI(board, letter);
      board[number] = letter;
      return board;
    }
    else {
      return board;
    }
  }
  private static int computerAI(String[] board, String letter) {
    int value = 0;
    String playerLetter;
    if (letter.equals("X")) {
      playerLetter = "O";
    }
    else {
      playerLetter = "X";
    }
    if (board[0].equals(letter) && board[1].equals(letter) && !board[2].equals("*")) {
      value = 2;
    }
    else if (board[0].equals(letter) && board[2].equals(letter) && !board[1].equals("*")) {
      value = 1;
    }
    else if (board[1].equals(letter) && board[2].equals(letter) && board[0].equals("*")) {
      value = 0;
    }
    else if (board[3].equals(letter) && board[4].equals(letter) && !board[5].equals("*")) {
      value = 5;
    }
    else if (board[3].equals(letter) && board[5].equals(letter) && !board[4].equals("*")) {
      value = 4;
    }
    else if (board[4].equals(letter) && board[5].equals(letter) && !board[3].equals("*")) {
      value = 3;
    }
    else if (board[6].equals(letter) && board[7].equals(letter) && !board[8].equals("*")) {
      value = 8;
    }
    else if (board[6].equals(letter) && board[8].equals(letter) && !board[7].equals("*")) {
      value = 7;
    }
    else if (board[7].equals(letter) && board[8].equals(letter) && !board[6].equals("*")) {
      value = 6;
    }
    else if (board[0].equals(letter) && board[3].equals(letter) && !board[6].equals("*")) {
      value = 6;
    }
    else if (board[0].equals(letter) && board[6].equals(letter) && !board[3].equals("*")) {
      value = 3;
    }
    else if (board[3].equals(letter) && board[6].equals(letter) && !board[0].equals("*")) {
      value = 0;
    }
    else if (board[1].equals(letter) && board[4].equals(letter) && !board[7].equals("*")) {
      value = 7;
    }
    else if (board[1].equals(letter) && board[7].equals(letter) && !board[4].equals("*")) {
      value = 4;
    }
    else if (board[4].equals(letter) && board[7].equals(letter) && !board[1].equals("*")) {
      value = 1;
    }
    else if (board[2].equals(letter) && board[5].equals(letter) && !board[8].equals("*")) {
      value = 8;
    }
    else if (board[2].equals(letter) && board[8].equals(letter) && !board[5].equals("*")) {
      value = 5;
    }
    else if (board[5].equals(letter) && board[8].equals(letter) && !board[2].equals("*")) {
      value = 2;
    }
    else if (board[0].equals(letter) && board[4].equals(letter) && !board[8].equals("*")) {
      value = 8;
    }
    return value;
  }
  private static void PrintBoard(String[] board) {
    int offset = 0;
    for (int i = 0; i < 3; i++) {
	System.out.println(board[0+offset] + "|" + board[1+offset] + "|" + board[2+offset]);
	if (i != 2) {
          System.out.println("- - -");
        }
	offset += 3;
      }
    }
}
