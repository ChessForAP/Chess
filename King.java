public class King extends Chess
{
   private int x;
   private int y;
   private String color;
   private King(String color)
   {
       this.color= color;
       Chess.num+=1;
   }
   public String toString()
   {
        return color+"Ki    ";
   }
   public static King creat(String color)
   {
        if(checkNum())
        {
            return new King(color);
        }
        else{
            throw new Error("more than 32 ");
        }
   }
}
