//upload by all of as--Kevin Jiang--Violet Yu---Zoe Du--Yolanda Su--Carol Li
public class Board
{
    private static Piece[][] table=new Piece[8][8];
    private static int order=1;
    private boolean evolve=false;
    private int x1;
    private int y1;
    public Board(){
        
        for(int i=0;i<8;i++){
            table[1][i]=Pawn.create("W",i);
            table[6][i]=Pawn.create("B",i);
            
        }
        table[0][0]=Rook.create("W",0);
        table[0][7]=Rook.create("W",7);
        table[7][0]=Rook.create("B",0);
        table[7][7]=Rook.create("B",7);
        table[0][1]=Knight.create("W",1);
        table[0][6]=Knight.create("W",6);
        table[7][1]=Knight.create("B",1);
        table[7][6]=Knight.create("B",6);
        table[0][2]=Bishop.create("W",2);
        table[0][5]=Bishop.create("W",5);
        table[7][2]=Bishop.create("B",2);
        table[7][5]=Bishop.create("B",5);
        table[0][3]=Queen.create("W",3);
        table[7][3]=Queen.create("B",3);
        table[0][4]=King.create("W",4);
        table[7][4]=King.create("B",4);
    }
    public Piece[][] getBoard(){
        return table;
    }
    public static void move(String str1,String str2) throws Exception{
        char[] ip=str1.toCharArray();
        char[] fp=str2.toCharArray();
        int x1=((int)ip[0]-97);
        int y1=((int)ip[1]-49);
        int x2=((int)fp[0]-97);
        int y2=((int)fp[1]-49);
        if(order==1) 
        {
            if(table[y1][x1].getColor().equals("B")) //check don't have the same color
            {
                throw new Exception();
            }
        }
        else
        {
            if(table[y1][x1].getColor().equals("W")) //check don't have the same color
            {
                throw new Exception();
            }
        }
        if(check(x1,x2,y1,y2)){
            throw new Exception();
        }
        if(table[y2][x2]!=null) //find if there have a null point
        {
            if((table[y2][x2].getColor()).equals(table[y1][x1].getColor())) //check don't have the same color
            {
                throw new Exception();
            }
            if(table[y1][x1].kill(x2,y2,table[y2][x2].getColor())==1)//check if the piece is pawn, and if it fit the role
            {
                throw new Exception();
            }
        }
        table[y1][x1].setPosition(x2,y2);
        table[y2][x2]=table[y1][x1];
        this.evolve=table[y2][x2].evolve();
        this.x=x2;
        this.y=y2;
        table[y1][x1]=null;
        order=order*-1;
    }
    public static boolean check(int x1,int x2,int y1,int y2) throws Exception{
        if((Math.abs(x1-x2)==2 && Math.abs(y1-y2)==1)||(Math.abs(x1-x2)==1 && Math.abs(y1-y2)==2))//if the piece move follow the knight,keep going
        {
            return false;
        }
        else{
            while(true){
                if(Math.abs(x1-x2)<=1 || Math.abs(y1-y2)<=1){
                    if(table[y2][x2]==null && Math.abs(x1-x2)==1 && table[y1][x1].checkFrount())//check is the piece is Pawn
                    {//can't toward lean when no piece in that place
                        return true;
                    }
                    if(table[y2][x2]!=null && Math.abs(x1-x2)==0 && table[y1][x1].checkFrount())//check is the piece is Pawn
                    {//can't move straight when have piece in that place
                        return true;
                    }
                    return false;
                }
                if(x1<x2-1){
                    x1++;
                }
                else if(x1>x2+1){
                    x1--;
                }
                if(y1<y2-1){
                    y1++;
                }
                else if(y1>y2+1){
                    y1--;
                }//check each place between the place the piece move to to make sure no pice in it
                if(table[y1][x1]!=null){
                    return true;
                }
            }
        }
    }
    public void evolve(String type,String color) throws Exception{
        if(type.equals("rook")){
            table[y][x]=new Rook(x,y,color);
        }
        else if(type.equals("queen")){
            table[y][x]=new Queen(x,y,color);
        }
        else if(type.equals("knight")){
            table[y][x]=new Knight(x,y,color);
        }
        else if(type.equals("bishop")){
            table[y][x]=new Bishop(x,y,color);
        }
        else{
            throw new Exception();
        }
    }
    public boolean getEvolve(){
        return this.evolve;
    }
}
