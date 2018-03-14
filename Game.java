import java.util.*;
public class Game
{
    Player player1;
    Player player2;
    Board table;
    public void game(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Please Enter the name of User1 :");
        player1= new Player("W",scanner1.next());
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please Enter the name of User2 :");
        player2= new Player("B",scanner2.next());
        table=new Board();
        while(true){
            table.printOut();
            player1.move(table);
            table.printOut();
            player2.move(table);
        }
    }
    
}
