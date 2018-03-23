//upload by Zoe Du
public class Knight extends Piece
{
    private int x;
    private int y;
    private String color;
    private Knight(String color,int x)
    {
        this.color=color;
        if(color.equals("W")){
            this.y=0;
        }
        else{
            this.y=7;
        }
        super.num+=1;
        this.x=x;
    }
    public String getColor(){
        return color;
    }
    public String toString()
    {
        return color+"Kn    ";
    }
    public static Knight create(String color,int x)
    {
        if(checkNum())
        {
            return new Knight(color,x);
        }
        else
        {
            throw new Error("more than 32");
        }
    }
    public void setPosition(int x,int y) throws Exception{
        if(0<=x && x<=7 && y<=7 && 0<=y){
            if(Math.abs(this.x-x)==2 && Math.abs(y-this.y)==1){
                    this.x=x;
                    this.y=y;
            }
            else if(Math.abs(this.x-x)==1 && Math.abs(y-this.y)==2){
                    this.x=x;
                    this.y=y;
            }
            else{
                throw new Exception();
            }
        }
        else{
            throw new Error("out of table");
        }
    }
}