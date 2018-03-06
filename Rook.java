public class Rook extends Chess
{
    private String color;
    private int x;
    private int y;
    private Rook(String color)
   {
       this.color= color;
       Chess.num+=1;
   }
   public String toString()
   {
        return color+"R     ";
   }
   public static Rook creat(String color)
   {
        if(checkNum())
        {
            return new Rook(color);
        }
        else{
            throw new Error("more than 32 ");
        }
   }
}
