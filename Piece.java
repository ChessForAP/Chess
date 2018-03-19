
/**
 * Write a description of class Chess here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Piece
{
    private String color;
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
    public void setPosition(int x,int y){
    }
    public String getColor(){
        return this.color;
    }
    public int kill(int x, int y, String str){
        return 0;
    }
}
