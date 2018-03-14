public class Queen extends Piece
{
   private int x;
   private int y;
   private String color;
   private Queen(String color)
   {
       this.color= color;
       if(color.equals("W")){
            this.y=0;
        }
        else{
            this.y=7;
        }
       this.x=3;
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
   public void setPosition(int x,int y){
        if(0<=x && x<=7 && y<=7 && 0<=y){
            if(this.x-x==this.y-y || this.x-x==y-this.y){
                this.x=x;
                this.y=y;
            }
            else if(this.x==x || this.y==y){
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