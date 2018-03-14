public class Piece
{
    private String color="none";
    protected static int num=0;
    Piece(){
    }
    public static boolean checkNum(){
        
        if(num<32){
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        return "       ";
    }
    public String getColor(){
        return this.color;
    }
    public void setPosition(int x,int y){
    }
}