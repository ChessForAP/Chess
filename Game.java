import java.util.*;
public class Game
{
    public void game(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Please Enter the name of User1 :");
        Player player1= new Player("W",scanner1.next());
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please Enter the name of User2 :");
        Player player2= new Player("B",scanner2.next());
        Board table=new board();
        while(true){
            table.printOut();
            move(table,player1);
            if(table.over(player1.getColor())){
                System.out.println(player1.getName()+" win");
                break;
            }
            table.printOut();
            move(table,player2);
            if(table.over(player2.getColor())){
                System.out.println(player2.getName()+" win");
                break;
            }
        }
    }
    private void move(Table table, Player player1){
        Scanner condition = new Scanner(System.in);
        System.out.println(player1.getName()+":");
        String str=condition.next();
        table.changePosition(str.substring(0,2),str.substring(3,5),player1.getColor());
    }
}
