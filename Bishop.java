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
        return color+"B     ";
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
   public void setPosition(int x,int y){
        if(0<=x && x<=7 && y<=7 && 0<=y){
            if(this.x-x==this.y-y || this.x-x==y-this.y){
                this.x=x;
                this.y=y;
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
