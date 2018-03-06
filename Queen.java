public class Queen extends Chess
{
   private int x;
   private int y;
   private String color;
   private Queen(String color)
   {
       this.color= color;
       super.num+=1;
   }
   public String toString()
   {
        return color+"Q     ";
   }
   public static Queen create(String color)
   {
        if(checkNum())
        {
            return new Queen(color);
        }
        else{
            throw new Error("more than 32 ");
        }
   }
}
