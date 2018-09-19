import java.util.*;

public class CheckersClient
{
   public static void main (String [] args)
   { 
           Scanner reader= new Scanner (System.in);
           int turns =0, piecesLeft1,piecesLeft2; 
           String name1="default", name2= "default";
           int [] list= {1,2,3,4};
         
    Piece [][] board = new Piece [8][8];
    for (int x= 0; x<8;x++)
    {
      for (int y= 0; y<8;y++)
      {
          if (x<3 && (x+y)%2==1)
          {
             board [x] [y] = new Piece (2, false); 
            }
           if (x>4 && (x+y)%2==1)
          {
             board [x] [y] = new Piece (1, false); 
            }
        }
    }
    System.out.println ("Welcome to a sporting game of checkers!");
    
    System.out.println ("Choose player 1.");
    System.out.println ("1. Human Player.");
    System.out.println ("2. Robot Master #1");
    int ask1 = reader.nextInt ();
    switch (ask1)//getting player one's name
            { 
                case 1: System.out.println ("Enter Your First Name");
                        name1 = reader.nextLine ();
                        name1 = reader.nextLine ();
                        break;
                case 2: name1 = "Robot Master #1";
                        break;  
                default: System.out.println("Choose somebody on the list.");
            }
    
    System.out.println ("Choose player 2.");
    System.out.println ("1. Human Player.");
    System.out.println ("2. Robot Master #1");
    int ask2 = reader.nextInt ();
        switch (ask2)//getting player two's name
            { 
                case 1: System.out.println ("Enter Your First Name");
                        name2 = reader.nextLine ();
                        name2 = reader.nextLine ();
                        break;
                case 2: name2 = "Robot Master #1";
                        break;
                default: System.out.println("Choose somebody on the list.");
            }

    do//turn
    {
        Piece.printBoard (board); 
       if (turns%2==0)//player #1 turn
        {
            System.out.println (name1);
            System.out.println ("Turn number:"+ ((turns/2)+1));
           switch (ask1)//deciding where to get the cordinates from
            { 
                case 1: list =Piece.humanCord (board);
                        break;
                case 2: list =Bot1.getMove(board,1);
                        break;
             }
            Piece.executeMove (board, list[0],list[1],list[2],list[3],Piece.moveType (board,list[0],list[1],list[2],list[3]), ask1);     
        }
       else// player #2 turn
     { 
         System.out.println (name2);
         System.out.println ("Turn number:"+ ((turns/2)+1));
           switch (ask2)//deciding where to get the cordinates from
            { 
                case 1: list =Piece.humanCord (board);
                        break;
                case 2: list =Bot1.getMove(board,2);
                        break;
             }
            Piece.executeMove (board, list[0],list[1],list[2],list[3],Piece.moveType (board,list[0],list[1],list[2],list[3]),ask2);    
      }
        turns++;
}while(Piece.countpiecesLeft1 (board) >0 && Piece.countpiecesLeft2 (board) >0);//turn ends

if (Piece.countpiecesLeft1 (board) > Piece.countpiecesLeft2 (board))
    System.out.println ("Player 1 wins!");
else
    System.out.println ("Player 2 wins!");
}
    
}
