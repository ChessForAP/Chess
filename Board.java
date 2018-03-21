public class Board
{
    private static Piece[][] table=new Piece[8][8];
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
    public static void move(String str1,String str2){
        char[] ip=str1.toCharArray();
        char[] fp=str2.toCharArray();
        int x1=((int)ip[0]-97);
        int y1=((int)ip[1]-49);
        int x2=((int)fp[0]-97);
        int y2=((int)fp[1]-49);
        if(check(x1,x2,y1,y2)){
            throw new Error("illigal moving"); 
        }
        
        if(table[y2][x2]!=null && table[y1][x1].kill(x2,y2,table[y2][x2].getColor())==1){
            if(table[y1][x1].kill(x2,y2,table[y2][x2].getColor())==2){
                throw new Error("illigal moving");
            }
        }
        table[y1][x1].setPosition(x2,y2);
        table[y2][x2]=table[y1][x1];
        table[y1][x1]=null;
    }
    public static boolean check(int x1,int x2,int y1,int y2){
        if((Math.abs(x1-x2)==2 && Math.abs(y1-y2)==1)||(Math.abs(x1-x2)==1 && Math.abs(y1-y2)==2)){
            return false;
        }
        else{
            while(true){
                if(Math.abs(x1-x2)<=1 && Math.abs(y1-y2)<=1){
                    if(table[y2][x2]!=null && Math.abs(x1-x2)==0 && table[y1][x1].checkfrount(x1,y1)){
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
                }
                if(!(table[y1][x1].getColor().equals("none"))){
                    return true;
                }
            }
        }
    }
}
