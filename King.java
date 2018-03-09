public class King extends Chess
{
   private int x;
   private int y;
   private String color;
   private King(String color)
   {
       this.color= color;
       super.num+=1;
   }
   public String toString()
   {
        return color+"Ki    ";
   }
   public static King create(String color)
   {
        if(checkNum())
        {
            return new King(color);
        }
        else{
            throw new Error("more than 32 ");
        }
   }
   public void setPosition(int x,int y){
        if(0<=x && x<=7 && y<=7 && 0<=y){
            if(Math.abs(this.x-x)==1 || Math.abs(this.y-y)==1){
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
