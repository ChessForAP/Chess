public class Bishop extends Chess
{
    private String color;
    private int x;
    private int y;
    private Bishop(String color)
   {
       this.color= color;
       super.num+=1;
   }
   public String toString()
   {
        return color+”B     ";
   }
   public static Bishop create(String color)
   {
        if(checkNum())
        {
            return new Bishop(color);
        }
        else{
            throw new Error("more than 32 ");
        }
   }
}
