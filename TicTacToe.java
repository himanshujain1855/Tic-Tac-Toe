package javaprograms;

import java.util.Scanner;

public class TicTacToe {
    // Function Definitions

    /*
     for your reference boardString="7|8|9\n4|5|6\n1|2|3", length=17
     How print_board function works?
        Ans: print_board function takes position of the character and place the character in boardString,
             at given position, and at last it returns new string.
     */
    String print_board(int position,String c,String boardString){
        String s,s1;
        s = boardString;
        s1 = boardString;
        if(position == 1) s1 = s.substring(0,12) + c + s.substring(13,17);
        else if(position == 2) s1 = s.substring(0,14) + c + s.substring(15,17);
        else if(position == 3) s1 = s.substring(0,16) + c + s.substring(17,17);
        else if(position == 4) s1 = s.substring(0,6) + c + s.substring(7,17);
        else if(position == 5) s1 = s.substring(0,8) + c + s.substring(9,17);
        else if(position == 6) s1 = s.substring(0,10) + c + s.substring(11,17);
        else if(position == 7) s1 = c + s.substring(1,17);
        else if(position == 8) s1 = s.substring(0,2) + c + s.substring(3,17);
        else if(position == 9) s1 = s.substring(0,4) + c + s.substring(5,17);
        return s1;
    }
    /*is_win function takes a board_string and checks if user won or not,
        it uses rules of TicTacToe Game.
        it takes help of 8 functions, 3 for horizontals,verticals and 2 for diagonals.
        (function details:- hr1,hr2,hr3,vc1,vc2,vc3,dg1,dg2)
        if all conditions are satisfied then it returns true otherwise it returns false.
     */

    boolean is_win(String board_string){
        // To make easy we need to assign board_string to small name srring
        String s = board_string;
        if(hr1(s)) return true;
        else if(hr2(s)) return true;
        else if(hr3(s)) return true;
        else if(vc1(s)) return true;
        else if(vc2(s)) return true;
        else if(vc3(s)) return true;
        else if(dg1(s)) return true;
        else if(dg2(s)) return true;
        else return false;
    }

    // // Checking Horizontals
    boolean hr1(String s){
        if(s.charAt(0)==s.charAt(2)) {
            if (s.charAt(2) == s.charAt(4)) return true;
            else return false;
        }
        else return false;
    }

    boolean hr2(String s){
        if(s.charAt(6)==s.charAt(8)) {
            if (s.charAt(8) == s.charAt(10)) return true;
            else return false;
        }
        else return false;
    }

    boolean hr3(String s){
        if(s.charAt(12)==s.charAt(14)) {
            if (s.charAt(14) == s.charAt(16)) return true;
            else return false;
        }
        else return false;
    }

    // Checking Verticals
    boolean vc1(String s){
        if(s.charAt(0)==s.charAt(6)) {
            if (s.charAt(6) == s.charAt(12)) return true;
            else return false;
        }
        else return false;
    }

    boolean vc2(String s){
        if(s.charAt(2)==s.charAt(8)) {
            if (s.charAt(8) == s.charAt(14)) return true;
            else return false;
        }
        else return false;
    }

    boolean vc3(String s){
        if(s.charAt(4)==s.charAt(10)) {
            if (s.charAt(10) == s.charAt(16)) return true;
            else return false;
        }
        else return false;
    }

    // Checking Diagonals
    boolean dg1(String s){
        if(s.charAt(0)==s.charAt(8)) {
            if (s.charAt(8) == s.charAt(16)) return true;
            else return false;
        }
        else return false;
    }

    boolean dg2(String s){
        if(s.charAt(4)==s.charAt(8)) {
            if (s.charAt(8) == s.charAt(12)) return true;
            else return false;
        }
        else return false;
    }

    // Driver function
    public static void main(String[] args) {
        boolean isPlayer1Playing=true;
        TicTacToe t=new TicTacToe();
        String boardString = "7|8|9\n4|5|6\n1|2|3\n";
        // player1list is used to check which player is playing at a time

        Scanner sc= new Scanner(System.in);
        String p1,p2="";
        int i,p;
        p1="x";
        p2="o";

        System.out.println("Player 1 "+p1+" Player 2 "+p2);
        System.out.println("\nLet's Start\n");
        System.out.println(boardString);



        for(i=0;i<10;i++){

           if(isPlayer1Playing){

               System.out.println("Player 1 Enter Your Position");
               p = sc.nextInt();
               boardString = t.print_board(p, p1, boardString);
               System.out.println(boardString);
               if(t.is_win(boardString)){

                       System.out.println("Congratulations To Player 1 You Won");
                       break;
                   }
               isPlayer1Playing=false;
           }
           else{

               System.out.println("Player 2 Enter Your Position");
               p = sc.nextInt();
               boardString = t.print_board(p, p2, boardString);
               System.out.println(boardString);
               if(t.is_win(boardString)){
                   System.out.println("Congratulations To Player 2 You Won");
                   break;
               }
               isPlayer1Playing=true;
           }

        }

    }
}
