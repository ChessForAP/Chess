public class Rook extends Chess
{
    private String color;
    private int x;
    private int y;
    private Rook(String color)
   {
       this.color= color;
       super.num+=1;
   }
   public String toString()
   {
        return color+"R     ";
   }
   public static Rook create(String color)
   {
        if(checkNum())
        {
            return new Rook(color);
        }
        else{
            throw new Error("more than 32 ");
        }
   }
   public void setPosition(int x,int y){
        if(0<=x && x<=7 && y<=7 && 0<=y){
            if(this.x==x || this.y==y){
                this.x=x;
                this.y=y;
                var=false;
            }
            else{
                throw new Error("illegal moving");
            }
        }
        else{
            throw new Error("out of table");
        }
    }
}
