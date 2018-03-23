//upload by Kevin Jiang--Violet Yu--Zoe Du--Yolanda Su--Zoe Du
public class Pawn extends Piece
{
    private String color;
    private int x;
    private int y;
    private boolean var=true;
    private Pawn(String color,int x)
    {
        this.color=color;
        if(color.equals("W")){
            this.y=1;
        }
        else{
            this.y=6;
        }
        this.x=x;
        Piece.num+=1;
    }
    public static Pawn create(String color,int x)
    {
        if(checkNum())
        {
            return new Pawn(color,x);
        }
        else
        {
            throw new Error("more than 32");
        }
    }
    public String toString(){
        return color+"P     ";
    }
    public void setPosition(int x,int y) throws Exception{
        
        if(0<=x && x<=7 && y<=7 && 0<=y)
        {//the moving is inside the board
            
            if(color.equals("W")){
                if(y-this.y==1 && Math.abs(x-this.x)==1){
                    this.x=x;
                    this.y=y;
                }
                else if(y-this.y==1 && this.x-x==0)
                {//move one step for everytime
                    this.x=x;
                    this.y=y;
                }
                else if(y-this.y==2 && var && this.x-x==0)
                {//check only move two step in first time
                    this.x=x;
                    this.y=y;
                }
                else{
                    throw new Exception();
                }
                
            }
            else{
                if(this.y-y==1 && Math.abs(x-this.x)==1){
                    this.x=x;
                    this.y=y;
                }
                else if(this.y-y==1 && this.x-x==0){
                    this.x=x;
                    this.y=y;
                }
                else if(this.y-y==2 && var && this.x-x==0){
                    this.x=x;
                    this.y=y;
                }
                else{
                    throw new Exception();
                }
            }
            
            if(var)
            {//change the var after first time
                var=false;
            }
                
        }
        else{
            throw new Error("out of table");
        }
    }
    public int kill(int x,int y,String color){
        if(this.color.equals(color))
        {//cannot eat self piece
            return 1;
        }
        if(color.equals("B")){
               
            if(y-this.y==1&&Math.abs(x-this.x)==1)
            {//only when towards the oblique
                    return 2;
                }
                else{
                    return 1;
                }
        }
        else{
            if(this.y-y==1&&Math.abs(x-this.x)==1)
            {//only when towards the oblique
                return 2;
            }
    
            else{
                return 1;
            }
        }
    }
    public boolean checkFrount()
    {//check the piece is pawn
        return true;
    }
    public String getColor(){
        return this.color;
    }
}
