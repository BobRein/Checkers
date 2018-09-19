
import java.util.*;

public class Piece
{
    public static int [] cord = new int [4];
        public static int [] list = new int [2];
    public static boolean firstTry= false;
    public static Scanner reader= new Scanner (System.in);
    public static int a,b,c,d,e,count=0;
    private boolean king;
    private int team;
    private static int direction;
    public Piece( int t, boolean k)
    {
      team = t;
      king =k;
    }
    // default constructor would go here
      public boolean getKing ()
    {
        return king;
    }
    
    public int getTeam ()
    {
        return team;
    }
    
    public static int countpiecesLeft1 (Piece [][] data)
    {
        count =0;
         for (int x=0; x<8; x++)
         {
        for (int i=0; i<8; i++)
     {
         if (data [x] [i] != null && data [x][i].getTeam ()==1)
            count++;
    }
    
}
return count;
    }
    
    public static int countpiecesLeft2 (Piece [][] data)
    {
        count =0;
         for (int x=0; x<8; x++)
         {
        for (int i=0; i<8; i++)
     {
         if (data [x] [i] != null && data [x][i].getTeam ()==2)
            count++;
    }
    
}
return count;
    }
    public void crown(boolean j)
    { 
        king = j;
    }
    
    public static void crownAnyKings (Piece [][] data)
    {
             for (int i=0; i<8; i++)
     {
         if (data [0] [i] != null && data [0][i].getTeam ()==1)
            data [0][i].crown (true);
    }
    for (int j=0; j<8; j++)
     {
         if (data [7] [j] != null && data [7][j].getTeam ()==2)
            data [7][j].crown (true);
    }
    }
    
    public static int moveType (Piece [][] data, int a, int b,int c,int d)
    {


        if (a>7 || a<0 || b>7 || b<0 || c>7 || c<0 || d>7 || d<0 || data [a] [b] == null || data [c] [d] != null)
            return 0;
        else
  {
    if (data[a][b].getTeam()==1) 
     direction = 1;
    else
     direction =-1;
       
    if (data [a][b].getKing ())
       direction =5;
            
    if  ( Math.abs (d-b) == 1 && (a-c==direction || direction ==5))//if it is a simple move                    
     return 1;
    else
    {
     if ( Math.abs (d-b) == 2 &&( a-c==2*direction || direction == 5) && data [a+((c-a)/2)] [b+((d-b)/2)]!=null && data [a+((c-a)/2)] [b+((d-b)/2)].getTeam ()!= data [a][b].getTeam ())
      return 2;
     else 
      return 0;
     }
  }
}
  
  public static void printBoard (Piece [][] data)
    {
        for (int z =0; z<8;z++) 
         {
             System.out.print ("\t"+z);
            }
            System.out.println ();
        for (int i=0; i<8; i++)
        {
           System.out.print (i); 
            for (int x=0; x<8; x++)
            {
          if (data[i][x] == null)
          System.out.print ("\t x"); 
          else
          {
             if(data [i][x].getKing ())
             {
                
             System.out.print ("\t " + (10*data[i][x].getTeam ()));
           }
           else
           {
              System.out.print ("\t " + (data[i][x].getTeam ())); 
            }
           
        }
        
    }
        System.out.println (); 
      
    }
}
   
    public static int [] humanCord (Piece [][] data)
    {
       //this code gets move cordinates from a human    
    do
    {
    if (firstTry)
    {
        System.out.println ("That was an illegal move.");
    }
    System.out.println ("Enter the row of the piece you would like to move.");
    a= reader.nextInt ();
    System.out.println ("Enter the column of the piece you would like to move.");
    b= reader.nextInt ();
    System.out.println ("Enter the row of the new destination.");
    c= reader.nextInt ();
    System.out.println ("Enter the column of the new destination.");
    d= reader.nextInt ();
    firstTry = true;
}while( Piece.moveType (data, a,b,c,d)==0);
firstTry = false;
cord [0]= a;
cord [1]= b;
cord [2]= c;
cord [3]= d;
return cord;
    //this code gets move cordinates from a human 
    }
    
    public static void executeMove (Piece [][] data,int a,int b, int c, int d, int e, int player)
    {
        if (e==1)//simple move
{
    data [c][d] = data [a][b];
    data [a][b]= null;
}

while (e==2)
{ 
    data [a+((c-a)/2)] [b+((d-b)/2)]=null;
    data [c][d] = data [a][b];
    data [a][b]= null;
    a=c;
    b=d;
    Piece.printBoard (data); 
    switch (player)
    {
    case 1:
            System.out.println ("Enter the row of the next jump's destination. Enter zero if you do not wish to jump any further.");
                c= reader.nextInt ();
            System.out.println ("Enter the column of the next jump's destination. Enter zero if you do not wish to jump any further.");
                d= reader.nextInt ();
               break;
    case 2: list= Bot1.getNextJump (data, a,b);
            c= list[0];
            d= list[1];
            break;
    
}
    
    e= Piece.moveType (data, a,b,c,d);
}
     Piece.crownAnyKings (data);
    }
    }

