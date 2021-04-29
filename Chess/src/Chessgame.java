import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class Chessgame {
// Version 1


    public static void main(String[] args) {

        // Initialize the chessboard with white and black characters on its positions
        System.out.println("Welcome to my chessgame");
        System.out.println("Instructions:");
        System.out.println("To move a character: " + "   'oldXPos' , 'oldYPos' , 'newXPos' , 'newYPos'");
        System.out.println("To get help: " + "           @help");
        System.out.println();

        // Kings
        Chessboard chessboard = new Chessboard();
        King kingW = new King(true);
        chessboard.chessboard[kingW.position[0]][kingW.position[1]] = kingW;     // adding character to the chessboard
        King kingB = new King(false);
        chessboard.chessboard[kingB.position[0]][kingB.position[1]] = kingB;

        //Queens
        Queen queenW = new Queen(true);
        chessboard.chessboard[queenW.position[0]][queenW.position[1]] = queenW;
        Queen queenB = new Queen(false);
        chessboard.chessboard[queenB.position[0]][queenW.position[1]] = queenB;

        //Bishops
        int[] posBishopW1 = {0, 2};
        Bishop bishopW1 = new Bishop(true, posBishopW1);
        chessboard.chessboard[bishopW1.position[0]][bishopW1.position[1]] = bishopW1;
        int[] posBishopW2 = {0, 5};
        Bishop bishopW2 = new Bishop(true, posBishopW2);
        chessboard.chessboard[bishopW1.position[0]][bishopW2.position[1]] = bishopW2;

        int[] posBishopB1 = {7, 2};
        Bishop bishopB1 = new Bishop(false, posBishopB1);
        chessboard.chessboard[bishopB1.position[0]][bishopB1.position[1]] = bishopB1;
        int[] posBishopB2 = {7, 5};
        Bishop bishopB2 = new Bishop(false, posBishopB2);
        chessboard.chessboard[bishopB1.position[0]][bishopB2.position[1]] = bishopB2;

        //Knights
        int[] posKnightW1 = {0, 1};
        Knight knightW1 = new Knight(true, posKnightW1);
        chessboard.chessboard[knightW1.position[0]][knightW1.position[1]] = knightW1;
        int[] posKnightW2 = {0, 6};
        Knight knightW2 = new Knight(true, posKnightW2);
        chessboard.chessboard[knightW2.position[0]][knightW2.position[1]] = knightW2;

        int[] posKnightB1 = {7, 1};
        Knight knightB1 = new Knight(false, posKnightB1);
        chessboard.chessboard[knightB1.position[0]][knightB1.position[1]] = knightB1;
        int[] posKnightB2 = {7, 6};
        Knight knightB2 = new Knight(false, posKnightB2);
        chessboard.chessboard[knightB2.position[0]][knightB2.position[1]] = knightB2;

        //Rooks
        int[] posRookW1 = {0, 0};
        Rook rookW1 = new Rook(true, posRookW1);
        chessboard.chessboard[rookW1.position[0]][rookW1.position[1]] = rookW1;
        int[] posRookW2 = {0, 7};
        Rook rookW2 = new Rook(true, posRookW2);
        chessboard.chessboard[rookW2.position[0]][rookW2.position[1]] = rookW2;

        int[] posRookB1 = {7, 0};
        Rook rookB1 = new Rook(false, posRookB1);
        chessboard.chessboard[rookB1.position[0]][rookB1.position[1]] = rookB1;
        int[] posRookB2 = {7, 7};
        Rook rookB2 = new Rook(false, posRookB2);
        chessboard.chessboard[rookB1.position[0]][rookB2.position[1]] = rookB2;


        //Pawns
        for (int i = 0; i < 8; i++) {
            int[] white = {1, i};
            int[] black = {6, i};
            Pawn pawnW = new Pawn(true, white);
            chessboard.chessboard[pawnW.position[0]][pawnW.position[1]] = pawnW;
            Pawn pawnB = new Pawn(false, black);
            chessboard.chessboard[pawnB.position[0]][pawnB.position[1]] = pawnB;
        }


        // Print Chessboard
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    if (i == 1 && j != 9) {
                        System.out.print("--" + (char) (j + 64) + "---" + "   |   ");
                    } else if (j == 9) {
                        if ((i - 2) >= 0) System.out.print(" Y : " + (i - 2));
                    } else if (chessboard.chessboard[i - 2][j - 1] == null) {
                        System.out.print("XXXX-X" + "   |   ");
                    } else {
                        System.out.print(chessboard.chessboard[i - 2][j - 1].toString() + "   |   ");
                    }
                }
                System.out.println();
            }


        Boolean gameOver = false;
        Boolean player1 = true;
        Player one = new Player(true);
        Player two = new Player(false);
        //asking User  for Input
        while(!gameOver) {
            Scanner user1inp = new Scanner(System.in);

            if (player1 == true) {
                System.out.println("Player1 please make a move:");
                /***
                 * only if Name of character has a W inside possible + destination has to be free or a B inside
                 * at the moment numbers are used for x and y, but y coordinate should be a - h!!!
                 * old and new position have to be different!
                 * adapt to Player 2 - Pawn reaces end of field
                 */

                // Because we want to enter an input with x and y coordinate, and the array works different than we think of a normal coordinate system
                // we have to switch x and y coordinate to access the array/cordinate system at the right spot!
                try {
                    String user1 = user1inp.nextLine();
                    String[] inputArr = user1.split(" ");
                    System.out.println("Move from : " + inputArr[0] + "-" + inputArr[1] + " to : " + inputArr[2] + "-" + inputArr[3]);
                    Character current = chessboard.chessboard[Integer.parseInt(inputArr[1])][toUpperCase(inputArr[0].charAt(0)) - 65];
                    System.out.println("type : " + current.type);
                    Character destination = chessboard.chessboard[Integer.parseInt(inputArr[3])][toUpperCase(inputArr[2].charAt(0)) - 65];



                if(current != null){
                    if (current.white){
                    // each character has its own function to check if destination is reachable within one move
                    boolean movable = current.move(Integer.parseInt(inputArr[3]), (int) toUpperCase(inputArr[2].charAt(0)) - 65);
                    System.out.println("movable = " + movable);

                    /***
                     * Check if Pawn Kills only works for Player one (white)
                     * e 5 to e 6 Valid move, but Pawn is not moving
                     */
                    // check if pawn is able to kill
                    if (current.type.equals("Pawn") && movable == false && (Math.abs(Integer.parseInt(inputArr[3])-Integer.parseInt(inputArr[1]) )== 1) && Math.abs((toUpperCase(inputArr[2].charAt(0)) - 65)-(toUpperCase(inputArr[0].charAt(0)) - 65))==1) {
                        if(!destination.white){
                            movable = true;
                        }
                    }
                    if(movable) {
                        if (destination != null) {
                            if (!destination.white) {                                    // player 1 == white

                                if(chessboard.chessboard[Integer.parseInt(inputArr[3])][toUpperCase(inputArr[2].charAt(0)) - 65].type.equals("King")){
                                    gameOver = true;
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    System.out.println("xxxxxxxxx   -               PLAYER 1 WON               -    xxxxxxxxx");
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    break;
                                }
                                two.deadCharacters.add(chessboard.chessboard[Integer.parseInt(inputArr[3])][toUpperCase(inputArr[2].charAt(0)) - 65]);
                                // moving the character to new position
                                chessboard.move(Integer.parseInt(inputArr[1]), (int) toUpperCase(inputArr[0].charAt(0)) - 65, Integer.parseInt(inputArr[3]), (int) toUpperCase(inputArr[2].charAt(0)) - 65);
                                System.out.println("moved");
                                System.out.print("dead character player 2: " + two.deadCharacters.get(two.deadCharacters.size()-1));
                            }
                        } else {
                            // destination is null, we can move because field is empty
                            chessboard.move(Integer.parseInt(inputArr[1]), (int) toUpperCase(inputArr[0].charAt(0)) - 65, Integer.parseInt(inputArr[3]), (int) toUpperCase(inputArr[2].charAt(0)) - 65);
                            System.out.println("moved");
                        }


                        //if Pawn reaches other side of field, bring back best dead Character
                        System.out.println(Integer.parseInt(inputArr[3]));
                        if (current.type.equals("Pawn") && Integer.parseInt(inputArr[3]) == 7 && !one.deadCharacters.isEmpty()) {
                            Character ret = one.checkDeadCharacters();
                            // replace Pawn with best Character
                            chessboard.chessboard[Integer.parseInt(inputArr[3])][toUpperCase(inputArr[2].charAt(0)) - 65] = ret;
                        }


                    }

                             else {

                                // Print Chessboard
                                for (int i = 1; i <= 9; i++) {
                                    for (int j = 1; j <= 9; j++) {
                                        if (i == 1 && j != 9) {
                                            System.out.print("--" + (char) (j + 64) + "---" + "   |   ");
                                        } else if (j == 9) {
                                            if ((i - 2) >= 0) System.out.print(" Y : " + (i - 2));
                                        } else if (chessboard.chessboard[i - 2][j - 1] == null) {
                                            System.out.print("XXXX-X" + "   |   ");
                                        } else {
                                            System.out.print(chessboard.chessboard[i - 2][j - 1].toString() + "   |   ");
                                        }
                                    }
                                    System.out.println();
                                }
                                System.out.println("No valid move...!");
                                continue;
                            }
                        }
                    }
                    else{
                        // Print Chessboard
                        for (int i = 1; i<= 9; i++) {
                            for (int j = 1; j <= 9; j++) {
                                if (i == 1 && j != 9){
                                    System.out.print("--" + (char)(j+64) + "---" + "   |   ");
                                }
                                else if( j == 9){
                                    if((i-2) >= 0)  System.out. print( " Y : " + (i-2));
                                }
                                else if (chessboard.chessboard[i-2][j-1] == null) {
                                    System.out.print("XXXX-X" + "   |   ");
                                }else {
                                    System.out.print(chessboard.chessboard[i-2][j-1].toString() + "   |   ");
                                }
                            }
                            System.out.println();
                        }
                        System.out.println("No valid move...!");
                        continue;
                    }

                }

                catch (Exception e){
                    System.out.println("To move a character please use the format:  'character(a-h)' 'integer(0-7)' 'character(a-h)' 'integer(0-7)' ");
                    continue;
                }

                player1 = false;
            }
            else{
                // Player 2
                System.out.println("Player2 please make a move:");
                try {
                    String user1 = user1inp.nextLine();
                    String[] inputArr = user1.split(" ");
                    System.out.println("Move from : " + inputArr[0] + "-" + inputArr[1] + " to : " + inputArr[2] + "-" + inputArr[3]);
                    Character current = chessboard.chessboard[Integer.parseInt(inputArr[1])][toUpperCase(inputArr[0].charAt(0)) - 65];
                    System.out.println("type : " + current.type);
                    Character destination = chessboard.chessboard[Integer.parseInt(inputArr[3])][toUpperCase(inputArr[2].charAt(0)) - 65];

                    if(current != null) {
                        if (!current.white) {
                            // each character has its own function to check if destination is reachable within one move
                            boolean movable = current.move(Integer.parseInt(inputArr[3]), (int) toUpperCase(inputArr[2].charAt(0)) - 65);

                            /***
                             * Check if Pawn Kills only works for Player one (white)
                             */
                            // check if pawn is able to kill
                            if (current.type.equals("Pawn") && movable == false && (Math.abs(Integer.parseInt(inputArr[3]) - Integer.parseInt(inputArr[1])) == 1) && Math.abs((toUpperCase(inputArr[2].charAt(0)) - 65) - (toUpperCase(inputArr[0].charAt(0)) - 65)) == 1) {
                                if (!destination.white) {
                                    movable = true;
                                }
                            }
                            if (movable) {
                                if (destination != null) {
                                    if (destination.white) {                                    // player 1 == white
                                        // destination is not my own character , we can move and we kill the character on that position
                                        // adding dead Character to the list of dead characters
                                        if(chessboard.chessboard[Integer.parseInt(inputArr[3])][toUpperCase(inputArr[2].charAt(0)) - 65].type.equals("King")){
                                            gameOver = true;
                                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                            System.out.println("xxxxxxxxx   -               PLAYER 2 WON               -    xxxxxxxxx");
                                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                            break;
                                        }
                                        one.deadCharacters.add(chessboard.chessboard[Integer.parseInt(inputArr[3])][toUpperCase(inputArr[2].charAt(0)) - 65]);
                                        // moving the character to new position
                                        chessboard.move(Integer.parseInt(inputArr[1]), (int) toUpperCase(inputArr[0].charAt(0)) - 65, Integer.parseInt(inputArr[3]), (int) toUpperCase(inputArr[2].charAt(0)) - 65);
                                        System.out.println("moved");
                                        System.out.print("dead character player 1: " + one.deadCharacters.get(one.deadCharacters.size() - 1));
                                    }
                                } else {
                                    // destination is null, we can move because field is empty
                                    chessboard.move(Integer.parseInt(inputArr[1]), (int) toUpperCase(inputArr[0].charAt(0)) - 65, Integer.parseInt(inputArr[3]), (int) toUpperCase(inputArr[2].charAt(0)) - 65);
                                    System.out.println("moved");
                                }


                                //if Pawn reaches other side of field, bring back best dead Character
                                System.out.println(Integer.parseInt(inputArr[3]));
                                if (current.type.equals("Pawn") && Integer.parseInt(inputArr[3]) == 0 && !one.deadCharacters.isEmpty()) {
                                    Character ret = one.checkDeadCharacters();
                                    // replace Pawn with best Character
                                    chessboard.chessboard[Integer.parseInt(inputArr[3])][toUpperCase(inputArr[2].charAt(0)) - 65] = ret;
                                }



                            } else {
                                // Print Chessboard
                                for (int i = 1; i <= 9; i++) {
                                    for (int j = 1; j <= 9; j++) {
                                        if (i == 1 && j != 9) {
                                            System.out.print("--" + (char) (j + 64) + "---" + "   |   ");
                                        } else if (j == 9) {
                                            if ((i - 2) >= 0) System.out.print(" Y : " + (i - 2));
                                        } else if (chessboard.chessboard[i - 2][j - 1] == null) {
                                            System.out.print("XXXX-X" + "   |   ");
                                        } else {
                                            System.out.print(chessboard.chessboard[i - 2][j - 1].toString() + "   |   ");
                                        }
                                    }
                                    System.out.println();
                                }
                                System.out.println("No valid move...!");
                                continue;
                            }
                        } else {
                            // Print Chessboard
                            for (int i = 1; i <= 9; i++) {
                                for (int j = 1; j <= 9; j++) {
                                    if (i == 1 && j != 9) {
                                        System.out.print("--" + (char) (j + 64) + "---" + "   |   ");
                                    } else if (j == 9) {
                                        if ((i - 2) >= 0) System.out.print(" Y : " + (i - 2));
                                    } else if (chessboard.chessboard[i - 2][j - 1] == null) {
                                        System.out.print("XXXX-X" + "   |   ");
                                    } else {
                                        System.out.print(chessboard.chessboard[i - 2][j - 1].toString() + "   |   ");
                                    }
                                }
                                System.out.println();
                            }
                            System.out.println("No valid move...!");
                            continue;
                        }

                    }
                }
                catch (Exception e){
                    System.out.println("To move a character please use the format:  'character(a-h)' 'integer(0-7)' 'character(a-h)' 'integer(0-7)' ");
                    continue;
                }


               player1 = true;
            }

            // Print Chessboard
            for (int i = 1; i<= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    if (i == 1 && j != 9){
                        System.out.print("--" + (char)(j+64) + "---" + "   |   ");
                    }
                    else if( j == 9){
                        if((i-2) >= 0)  System.out. print( " Y : " + (i-2));
                    }
                    else if (chessboard.chessboard[i-2][j-1] == null) {
                        System.out.print("XXXX-X" + "   |   ");
                    }else {
                        System.out.print(chessboard.chessboard[i-2][j-1].toString() + "   |   ");
                    }
                }
                System.out.println();
            }


        }

    }

}



