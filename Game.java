//upload by Violet Yu--Zoe Du--Yolanda Su--Violet Yu--Kevin Jiang--Yolanda Su--Kevin Jiang--Violet Yu
import java.util.*;
public class Game
{
    Player player1;
    Player player2;
    Board table;
    public  Game() throws Exception{
        ChessTester ct=new ChessTester("C:/Users/13811/Desktop/ChessTest/Castling.txt");
        System.out.println("Please Enter the name of User1 :");
        player1= new Player("W",getString(ct));
        System.out.println("Please Enter the name of User2 :");
        player2= new Player("B",getString(ct));
        table=new Board();
        while(true){
            printOutBoard();
            move(player1,ct);
            if(table.getEvolve()){
                Scanner scanner = new Scanner(System.in);
                System.out.println("change this Pawn to(rook or queen or knight or bishop):");
                String change=getString(ct);
                table.evolve(change);
            }
            printOutBoard();
            move(player2,ct);
            if(table.getEvolve()){
                Scanner condition = new Scanner(System.in);
                Scanner scanner = new Scanner(System.in);
                table.evolve(getString(ct));
            }
        }
    }
    public void move(Player player,ChessTester ct) throws Exception{
        System.out.println("");
        System.out.println(player.getName()+" move piece at:");
        String str1=getString(ct);
        if(str1.equals("0-0-0")){
            if(table.checkCastling("left",player1.getColor())){
                table.castling("left",player1.getColor());
            }
            else{
                System.out.println("can't castling");
                move(player,ct);
            }
        }
        else if(str1.equals("0-0")){
            if(table.checkCastling("right",player1.getColor())){
                table.castling("right",player1.getColor());
            }
            else{
                System.out.println("can't castling");
                move(player,ct);
            }
        }
        else{
            System.out.println("to place:");
            String str2=getString(ct);
        
            try{
                player.move(str1,str2);
            }
            catch(MoveException e){
                System.out.println("illegal moving");
                move(player,ct);
            }
            catch(MyException e){
                System.out.println("Not your chess");
                move(player,ct);
            }
            catch(KillException e){
                System.out.println("can't kill yourself");
                move(player,ct);
            }
        }
    }
    public void printOutBoard(){
        Piece[][] board=table.getBoard();
        for(int i=0;i<8;i++){
            System.out.print((8-i)+"   ");
            for(int j=0;j<8;j++){
                if(board[7-i][j]==null)
                {
                    System.out.print("       ");
                }
                else{
                    System.out.print(board[7-i][j]);
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.print("    ");
        for(int i=65;i<73;i++){
            System.out.print((char)i);
            System.out.print("      ");
        }
    }
    private String getString(ChessTester ct) throws Exception{
        String move=ct.getNext();
        if(move!=null){
            return move;
        }
        else{
            Scanner condition = new Scanner(System.in);
            return condition.next();
        }
    }
}
